package conta;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ContaController contas = new ContaController();

        Scanner leia = new Scanner(System.in);

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123,1,"João Tsunami",10000f, 100.0f);
        contas.cadastrar(cc1);
        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(),124,2,"Maria da Silva", 2000f, 12);
        contas.cadastrar(cp1);
        contas.listarTodas();

        int numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite, valor;



        while(true){
            System.out.print(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                BANCO DO BRAZIL COM Z                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Criar Conta                          ");
            System.out.println("            2 - Listar todas as Contas               ");
            System.out.println("            3 - Buscar Conta por Numero              ");
            System.out.println("            4 - Atualizar Dados da Conta             ");
            System.out.println("            5 - Apagar Conta                         ");
            System.out.println("            6 - Sacar                                ");
            System.out.println("            7 - Depositar                            ");
            System.out.println("            8 - Transferir valores entre Contas      ");
            System.out.println("            9 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     ");
            System.out.print(Cores.TEXT_RESET);

            byte opcao;
            try {
                opcao = leia.nextByte();
            }catch (InputMismatchException e) {
                System.out.println("Digite valores inteiros!\n");
                leia.nextLine();
                opcao = 0;
            }

            switch(opcao){
                case 1:
                    System.out.print(Cores.TEXT_WHITE);
                    System.out.println("Criar Conta\n");

                    System.out.println("Digite o número da agência: ");
                    agencia = leia.nextInt();
                    System.out.println("Digite o nome do titular: ");
                    leia.skip("\\R?");
                    titular = leia.nextLine();



                    do {
                        System.out.println("Digite o tipo da Conta (1-ContaCorrente OU 2-ContaPoupança)");
                        tipo = leia.nextInt();
                    }while(tipo <1 || tipo >2);


                    System.out.println("Digite o saldo da conta (R$): ");
                    saldo = leia.nextFloat();
                    switch(tipo){
                        case 1 -> {
                            System.out.println("Digite o limite de crédito (R$): ");
                            limite = leia.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia,tipo,titular,saldo,limite));
                        }
                        case 2 -> {
                            System.out.println("Digite o dia do aniversario da conta: ");
                            aniversario = leia.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia,tipo,titular,saldo,aniversario));
                        }
                        default ->{
                            System.out.println("Tipo de conta inválido!");
                        }
                    }
                    keyPress();
                    break;
                    case 2:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Listar todas as Contas\n");
                        contas.listarTodas();
                        keyPress();
                        break;
                    case 3:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Consultar dados da Conta - por número\n");

                        System.out.println("Digite o número da conta: ");
                        numero = leia.nextInt();

                        contas.procurarPorNumero(numero);

                        keyPress();
                        break;
                    case 4:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Atualizar dados da Conta\n");

                        System.out.println("Digite o número da conta: ");
                        numero = leia.nextInt();

                        var buscaConta = contas.buscarNoCollection(numero);
                        if(buscaConta != null){
                            tipo = buscaConta.getTipo();

                            System.out.println("Digite o número da agência: ");
                            agencia = leia.nextInt();
                            System.out.println("Digite o nome do titular: ");
                            leia.skip("\\R?");
                            titular = leia.nextLine();

                            System.out.println("Digite o saldo da conta (R$): ");
                            saldo = leia.nextFloat();

                            switch(tipo){
                                case 1 -> {
                                    System.out.println("Digite o limite de crédito (R$): ");
                                    limite = leia.nextFloat();
                                    contas.atualizar(new ContaCorrente(numero,agencia,tipo,titular,saldo,limite));
                                }
                                case 2 -> {
                                    System.out.println("Digite o dia do aniversario da conta: ");
                                    aniversario = leia.nextInt();
                                    contas.atualizar(new ContaPoupanca(numero,agencia,tipo,titular,saldo,aniversario));
                                }
                                default ->{
                                    System.out.println("Tipo de conta inválido!");
                                }
                            }

                        }else{
                            System.out.println("A conta não foi encontrada!");
                        }


                        keyPress();
                        break;
                    case 5:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Apagar a Conta\n");

                        System.out.println("Digite o número da conta: ");
                        numero = leia.nextInt();

                        contas.deletar(numero);

                        keyPress();
                        break;
                    case 6:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Saque\n");

                        System.out.println("Digite o número da conta: ");
                        numero = leia.nextInt();

                        do{
                            System.out.println("Digite o valor do saque (R$): ");
                            valor = leia.nextFloat();
                        }while (valor <=0);
                        contas.sacar(numero,valor);

                        keyPress();
                        break;
                    case 7:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Depósito\n");

                        System.out.println("Digite o número da conta: ");
                        numero = leia.nextInt();

                        do{
                            System.out.println("Digite o valor do depósito (R$): ");
                            valor = leia.nextFloat();
                        }while (valor <=0);

                        contas.depositar(numero,valor);

                        keyPress();
                        break;
                    case 8:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("Transferência entre Contas\n");

                        System.out.println("Digite o número da conta de origem: ");
                        numero = leia.nextInt();
                        System.out.println("Digite o número da conta de destino: ");
                        numeroDestino = leia.nextInt();

                        do{
                            System.out.println("Digitie o valor da transferência (R$): ");
                            valor = leia.nextFloat();
                        }while (valor <=0);
                        contas.transferir(numero,numeroDestino,valor);

                        keyPress();
                        break;
                    case 9:
                        System.out.print(Cores.TEXT_WHITE);
                        System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
                        sobre();
                        leia.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println(Cores.TEXT_RED_BOLD);
                        System.out.println("\nOpção Inválida!\n");
                        break;

            }
        }

    }



    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Matheus Seixas Pereira de Queiroz ");
        System.out.println("Generation Brasil - matheusq@generation.org");
        System.out.println("github.com/MatheusSPQ");
        System.out.println("*********************************************************");
    }

    public static void keyPress(){
        try {

            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();

        } catch (IOException e) {

            System.out.println("Você pressionou uma tecla diferente de enter!");

        }

    }



}

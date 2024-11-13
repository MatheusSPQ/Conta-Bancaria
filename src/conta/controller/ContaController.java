package conta.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;

import java.util.ArrayList;
import java.util.Optional;

public class ContaController implements ContaRepository {

    ArrayList<Conta> listaContas = new ArrayList<>();
    int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNoCollection(numero);
        Optional<Conta> contaOp = Optional.ofNullable(conta);
        if (contaOp.isPresent()) {
            conta.visualizar();
        }else{
            System.out.println("\nA conta número: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void listarTodas() {
        for(var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("\nConta número: " + conta.getNumero() + " foi cadastrada com sucesso!");
    }

    public int gerarNumero() {
        return ++numero;
    }

    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNoCollection(conta.getNumero());
        Optional<Conta> contaOp = Optional.ofNullable(buscaConta);
        if (contaOp.isPresent()) {
            listaContas.set(listaContas.indexOf(buscaConta), conta);
            System.out.println("\nConta número: " + conta.getNumero() + " foi atualizada com sucesso!");
        }else{
            System.out.println("\nConta número: " + conta.getNumero() + " não foi encontrada!");
        }

    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNoCollection(numero);
        if (conta != null) {
            if(listaContas.remove(conta)) {
                System.out.println("\nConta número: " + numero + " foi deletada com sucesso!");
            }
        }else{
            System.out.println("\nnúmero: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void sacar(int numero, float valor) {
        var conta = buscarNoCollection(numero);
        Optional<Conta> contaOp = Optional.ofNullable(conta);
        if (contaOp.isPresent()) {
            if(conta.sacar(valor)) {
                System.out.println("\nSaque na conta: " + numero + " foi realizado com sucesso!");
            }
        }else{
            System.out.println("\nConta numero: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        var conta = buscarNoCollection(numero);
        Optional<Conta> contaOp = Optional.ofNullable(conta);
        if (contaOp.isPresent()) {
            conta.depositar(valor);
            System.out.println("\nDepósito na conta número: " + numero + " foi realizado com sucesso!");
        }else{
            System.out.println("Conta número: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = buscarNoCollection(numeroOrigem);
        var contaDestino = buscarNoCollection(numeroDestino);

        if(contaOrigem != null && contaDestino != null) {
            if(contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                System.out.println("\nTransferência foi efetuada com sucesso!");
            }
        }else{
            System.out.println("\nConta de origem e/ou destino não foram encontradas!");
        }
    }

    public Conta buscarNoCollection(int numero) {
        for(var conta : listaContas) {
            if(conta.getNumero() == numero) {
                return conta;
            }
        }

        return null;
    }
}

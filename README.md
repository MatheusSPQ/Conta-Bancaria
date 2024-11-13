# 🏦 Projeto 01 - Conta Bancária 🚀

## 📋 Sobre o Projeto
O **Projeto Conta Bancária** é um guia prático para aprender os conceitos de **Orientação a Objetos (POO)** em Java. Durante o desenvolvimento, novas funcionalidades serão adicionadas progressivamente para aplicar os conhecimentos adquiridos ao longo do curso. Este projeto servirá como base para o **Projeto Java**, que marca o final do Bloco 01 do curso. 📚💻

### 🎯 Objetivos:
- 📚 Aprender e praticar os conceitos fundamentais de **OOP**.
- 💻 Desenvolver uma aplicação funcional de **Conta Bancária** com diferentes tipos de contas.
- 🛠️ Utilizar boas práticas de programação, como **modularização** e **reuso de código**.

---

## 🗂 Estrutura do Projeto

| 📝 **Classe/Interface** | 📄 **Descrição** |
|------------------------|----------------------------------------------|
| `Menu`                | Classe principal com o método `main`, responsável pelo **menu inicial** da aplicação com todas as funcionalidades. 📑 |
| `Cores`               | Classe utilitária para aplicar **cores** ao menu, melhorando a experiência do usuário. 🎨 |
| `Conta`               | Define o **Objeto Conta** genérico. 💳 |
| `ContaCorrente`       | Define o **Objeto Conta Corrente** com características específicas. 🏦 |
| `ContaPoupanca`       | Define o **Objeto Conta Poupança** com características específicas. 🐷 |
| `ContaRepository`     | Interface que encapsula os **métodos utilizados** no Menu. 🗃️ |
| `ContaController`     | Implementa a interface `ContaRepository` e gerencia as operações bancárias. 📊 |

---

## ⚙️ Funcionalidades Implementadas
- ✅ Criação de contas bancárias (Corrente e Poupança).
- 🔍 Consulta de saldo e informações da conta.
- 💰 Depósito e saque em contas.
- 🔄 Transferência de valores entre contas.

---

## 🚀 Como Executar o Projeto

Certifique-se de ter o **Java JDK** instalado em sua máquina.

1. Clone o repositório:
    ```bash
    git clone https://github.com/MatheusSPQ/Conta-Bancaria.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd Conta-bancaria
    ```
3. Compile o projeto:
    ```bash
    javac -d bin src/conta/*.java src/conta/**/*.java
    ```
4. Execute a aplicação:
    ```bash
    java -cp bin conta.Menu
    ```

---

## 📌 Pré-requisitos
- Java JDK 11+
- Git

---

## 🛠 Tecnologias Utilizadas
- **Java** ☕
- **Git & GitHub** 🐙
- **Orientação a Objetos (OOP)** 📦

---

## 📝 Notas Adicionais
🔧 Este projeto é um material de aprendizado. Durante a execução, alguns caracteres podem ser exibidos de forma errada 
dependendo do terminal utilizado. Caso isso aconteça, ajuste as configurações do terminal para garantir a exibição correta dos caracteres.🌟

---

## 📬 Contato
- **Matheus Queiroz**  
- [LinkedIn](https://www.linkedin.com/in/matheus-queiroz/)  
- [GitHub](https://github.com/MatheusSPQ)

---

**🌟 Se você gostou deste projeto, deixe uma ⭐ no repositório!**

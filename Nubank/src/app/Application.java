package app;

import entidades.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        //Instância de objetos:
        Titular titular1 = new Titular("Marcella Araújo", "000.302.000-80");
        Titular titular2 = new Titular("Alfredo Guilherme", "321.654.789-89");

        System.out.println("------------------------------------------- Conta Corrente -------------------------------------------");

        System.out.println("Conta1");
        ContaCorrente conta1 = new ContaCorrente(1234, titular1, 100, 200,4000);
        conta1.verificaSaldoComLimitePremium();
        conta1.depositar(3200);
        conta1.verificaSaldoComLimitePremium();
        conta1.sacar(1200);

        System.out.println(" ");

        System.out.println("Conta2");
        ContaCorrente conta2 = new ContaCorrente(2234, titular2, 7000, 1000, 15000);
        conta2.verificaSaldoComLimitePremium();
        conta2.depositar(800);
        conta2.verificaSaldoComLimitePremium();
        conta2.sacar(13000);
        //conta2.transferir(50,1234);

        System.out.println("");
        System.out.println("--------------------------------------------- Empréstimo --------------------------------------------");

        System.out.println("Empréstimo1");
        Emprestimo emprestimo1 = new Emprestimo( conta1, 4000,20000,1.5,48);
        emprestimo1.simularEmprestimo();
        emprestimo1.solicitarEmprestimo();
        System.out.println("");

        System.out.println("Empréstimo2");
        Emprestimo emprestimo2 = new Emprestimo( conta2, 15000,250000,1.8,60);
        emprestimo2.simularEmprestimo();
        emprestimo2.solicitarEmprestimo();

        System.out.println("");
        System.out.println("--------------------------------------------- Poupança ---------------------------------------------");
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(1234-5, titular1, 10000);
        contaPoupanca1.depositar(5000);
        contaPoupanca1.rendimentoPoupanca();
        contaPoupanca1.rendimentoPoupanca();
        contaPoupanca1.rendimentoPoupanca();
        contaPoupanca1.sacar(14000);
        contaPoupanca1.verificarSaldoPoupanca();

        System.out.println("");
        System.out.println("------------------------------------------- Investimento ------------------------------------------");
        Investimento investimento = new Investimento(1234-5, titular1,20000);
        investimento.depositar(1000);
        investimento.rendimentoInvestimento();
        investimento.rendimentoInvestimento();
        investimento.sacar(13410);
        investimento.verificarSaldoInvestimento();

    }
}

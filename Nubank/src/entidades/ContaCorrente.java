package entidades;

import java.sql.SQLOutput;

public class ContaCorrente extends Conta{
    //Atributo
    private double limitePremium;
    private double salario;

    //Método Construtor
    public ContaCorrente(int numero, Titular titular, double saldo, double limitePremium, double salario) {
        super(numero, titular, saldo);
        this.limitePremium = limitePremium;
        this.salario = salario;
    }

    // Método Personalizado
    public double verificarSaldo() {
        return this.getSaldo();
    }

    public double verificaSaldoComLimitePremium() {
        System.out.println("O saldo atual da conta corrente com o limite do cheque especial é de R$ " + (this.getSaldo() + limitePremium));
        return this.getSaldo();
    }

    //Método Getter e Setter
    public double getLimitePremium() {
        return limitePremium;
    }

    public void setLimitePremium(double limitePremium) {
        this.limitePremium = limitePremium;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Método herdado da class mãe (Conta)
    @Override
    public int getNumero() {
        return this.getNumero();
    }

    //Método herdado da class mãe (Conta)
    @Override
    public void sacar(double valorSaque) {
        if (valorSaque > this.verificarSaldo() + this.getLimitePremium()) {
            System.out.println("Saldo insuficiente! O valor do saque R$ " + valorSaque + " é superior ao saldo existente na conta corrente!");
        } else {
            if (valorSaque <= this.verificarSaldo() + this.getLimitePremium()) {
                this.setSaldo((this.getSaldo() - valorSaque));
                System.out.println("Débito realizado com sucesso na conta corrente no valor de: R$ " + valorSaque + "D" + '\n' + "Saldo atual da conta corrente com o limite do cheque especial é: R$ " + (this.getSaldo() + limitePremium));
            } else {
                //Verificar quanto está faltando
                double diferenca = this.getSaldo() - valorSaque;

                //Subtrair dos valores
                this.setLimitePremium(this.getLimitePremium() - diferenca);
                this.setSaldo(this.getSaldo() - valorSaque);
                System.out.println("Dédito: R$ " + valorSaque + "D" + '\n' + "Valor utilizado do cheque especial: R$ " + diferenca + "D");
                System.out.println("Saldo atual: R$ " + this.getSaldo());

            }
        }
    }

    //Método herdado da class mãe (Conta)
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(valor + this.getSaldo());
            System.out.println("Depósito realizado com sucesso na conta corrente no valor de: R$ " + valor + "C");

        } else {
            System.out.println("O valor de depósito na conta corrente é inválido!");
        }
    }

    //Método herdado da class mãe (Conta)
    @Override
    public void transferir(double valorTransferencia, Conta destinatario) {
        if (valorTransferencia > this.verificarSaldo() + this.getLimitePremium()) {
            System.out.println("Saldo de conta corrente insuficiente para transferência!");
        } else {
            if (valorTransferencia <= this.verificarSaldo()) {
                this.setSaldo((this.getSaldo() - valorTransferencia));
                destinatario.setSaldo(destinatario.getSaldo() + valorTransferencia);
                System.out.println("Transferência no valor de R$: " + valorTransferencia + "D" + '\n' + "Realizado para: R$ " + destinatario);
                System.out.println("Saldo atual: R$ " + this.getSaldo());

            } else {
                //Verificar quanto está faltando
                double diferenca = this.getSaldo() - valorTransferencia;

                //Subtrair dos valores
                this.setLimitePremium(this.getLimitePremium() - diferenca);
                this.setSaldo(this.getSaldo() - valorTransferencia);
                destinatario.setSaldo(destinatario.getSaldo() + valorTransferencia);

                System.out.println("Transferência: R$ " + valorTransferencia + "D" + '\n' + "Valor cheque especial utilizado: R$ " + diferenca + "D");
                System.out.println("Saldo atual: R$ " + this.getSaldo());

            }
        }
    }
}

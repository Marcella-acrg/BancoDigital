package entidades;

public class Investimento extends Conta{

    // Método Construtor
    public Investimento(int numero, Titular titular, double saldo) {
        super(numero, titular, saldo);
    }

    // Métodos Personalizados
    public double verificarSaldoInvestimento (){
        return this.getSaldo();
    }

    public double rendimentoInvestimento () {
        this.setSaldo(this.getSaldo() * 1.10);
        System.out.println("O rendimento do investimento foi de 10% sobre o saldo existente na conta, logo, foi de R$: " + this.getSaldo());
        return this.getSaldo();
    }

    //Métodos herdados da classe mãe (Conta)
    @Override
    public void sacar(double valorSaque) {
        if (valorSaque > this.verificarSaldoInvestimento()) {
            System.out.println("Saldo de investimento insuficiente para saque!");
        } else if (valorSaque <= this.verificarSaldoInvestimento()) {
            this.setSaldo((this.getSaldo() - valorSaque));
            System.out.println("Saque realizado com sucesso na conta investimento no valor de R$ " + valorSaque);
            System.out.println("O saldo atual da conta investimento é de R$ " + this.getSaldo());
        }

    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(valor + this.getSaldo());
            System.out.println("Depósito realizado com sucesso na conta investimento no valor de R$ " + valor);
        } else {
            System.out.println("O valor do depósito para investimento é inválido!");
        }
    }

    @Override
    public void transferir(double valorTransferencia, Conta destinatario) {
        if (valorTransferencia > this.verificarSaldoInvestimento()) {
            System.out.println("Saldo de investimento insuficiente para saque!");
        } else if (valorTransferencia <= this.verificarSaldoInvestimento()) {
            this.setSaldo((this.getSaldo() - valorTransferencia));
        }
    }

    @Override
    public int getNumero() {
        return 0;
    }
}

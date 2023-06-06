package entidades;

public class ContaPoupanca extends Conta{

    //Método Construtor
    public ContaPoupanca(int numero, Titular titular, double saldo) {
        super(numero, titular, saldo);
    }

    //Método Personalizado
    public double verificarSaldoPoupanca() {
        return this.getSaldo();
    }

    public double rendimentoPoupanca() {
        this.setSaldo(this.getSaldo() * 1.02);
        System.out.println("O rendimento da poupança foi de 2% sobre o saldo existente na conta, logo, foi de R$ " + this.getSaldo());
        return this.getSaldo();
    }

    //Métodos herdados da classe mãe (Conta)
    @Override
    public int getNumero() {
        return this.getNumero();
    }

    @Override
    public void sacar(double valorSaque) {
        if (valorSaque > this.verificarSaldoPoupanca()) {
            System.out.println("Saldo insuficiente para saque!");
        } else if (valorSaque <= this.verificarSaldoPoupanca()) {
                this.setSaldo((this.getSaldo() - valorSaque));
                System.out.println("Saque realizado com sucesso na conta poupança no valor de R$ " + valorSaque);
                System.out.println("O saldo atual da conta poupança é R$ " + this.getSaldo());
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(valor + this.getSaldo());
            System.out.println("Depósito realizado com sucesso no valor de R$ " + valor);
        } else {
            System.out.println("O valor de depósito é inválido!");
        }

    }

    @Override
    public void transferir(double valorTransferencia, Conta destinatario) {
        if (valorTransferencia > this.verificarSaldoPoupanca()) {
            System.out.println("Saldo insuficiente para saque!");
        } else if (valorTransferencia <= this.verificarSaldoPoupanca()) {
            this.setSaldo((this.getSaldo() - valorTransferencia));
        }
    }
}

package entidades;

public class Emprestimo {
    //Atributos
    private Conta conta;
    private double salario;
    private double valorEmprestimo;
    private double taxaJuros;
    private int prazo;
    private double valorParcela;

    //Método Constutor
    public Emprestimo(Conta conta, double salario, double valorEmprestimo, double taxaJuros, int prazo){
        this.conta = conta;
        this.salario = salario;
        this.valorEmprestimo = valorEmprestimo;
        this.taxaJuros = taxaJuros;
        this.prazo = prazo;
    }

    //Métodos Personalizados
    public void simularEmprestimo() {
       double montante = this.valorEmprestimo * this.taxaJuros;
       double juros = montante - this.valorEmprestimo;
       double Parcela = montante / this.prazo;
        System.out.println("Valor do empréstimo: R$ " + this.valorEmprestimo + '\n' + "Prazo: " + this.prazo + " meses" + '\n' + "Taxa: " + this.taxaJuros + " a.a" + '\n' + "Valor da Parcela: R$ " + Parcela + '\n' + "Juros total: R$ " + juros + '\n' +  "Montante: R$ " + montante);
    }

    public void solicitarEmprestimo() {
        double montante = this.valorEmprestimo * this.taxaJuros;
        double juros = montante - this.valorEmprestimo;
        this.valorParcela = montante / this.prazo;
        if((this.valorParcela <= (this.getSalario() * 0.3))) {
            System.out.println("Emprétimo solicitado com sucesso!");
        } else {
            System.out.println("Empréstimo negado, ultrapassa o valor de 30% do salário");
        }
    }

    //Métodos Geterres e Seterres
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public double getvalorParcela() {
        return valorParcela;
    }

    public void setParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
}

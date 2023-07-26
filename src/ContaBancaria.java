import java.util.Scanner;

public class ContaBancaria {
    private double saldo = 0;
    private double receberValor;
    private double transferirValor;

    Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner escolha = new Scanner(System.in);
        boolean opcoes = true;
        ContaBancaria conta = new ContaBancaria();
        while (opcoes) {
            System.out.println("Digite a opção desejada");
            System.out.println("1 - Consulter Saldo " +
                    "2 - Receber Valor " +
                    "3 - Tranferir valor " +
                    "4 - Sair");

            int operacao = escolha.nextInt();
            if (operacao > 4 && operacao < 1) {
                System.out.println("Operação não encontrada por favor digite uma operação válida");
            } else {
                switch (operacao) {
                    case 1:
                        System.out.println("Seu saldo atual é de: " + conta.consultarSaldo());
                        break;
                    case 2:
                        System.out.println("Seu deposito de " + conta.depositoSaldo() + " foi realizado com sucesso!");
                        System.out.println("Saldo atualizado " + conta.consultarSaldo());
                        break;
                    case 3:
                        double valorTransferencia = conta.transferirValor();
                        if (valorTransferencia == 0){
                            System.out.println("Transferência negada, saldo insuficiente!");
                        }
                        else{
                            System.out.println("Transferencia de " + valorTransferencia + " realizada com sucesso!!");
                            System.out.println("Saldo Atualizado: " + conta.consultarSaldo());
                        }
                        break;
                    case 4:
                        System.out.println("SimasBank agradece sua preferência, até logo!");
                        opcoes = false;
                }

            }
        }

    }

    public double consultarSaldo() {
        return saldo;
    }

    public double depositoSaldo() {
        System.out.println("Qual é o valor que deseja depositar: ");
        double valorDeposito = teclado.nextDouble();
        this.saldo += valorDeposito;
        return valorDeposito;
    }

    public double transferirValor() {
        System.out.println("Qual é o valor que deseja transferir: ");
        double transferirValor = teclado.nextDouble();
        if (transferirValor > this.saldo) {
            return 0;
        } else {
            this.saldo -= transferirValor;
            return transferirValor;
        }
    }
}
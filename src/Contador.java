import java.util.Scanner;
import exceptions.ParametrosInvalidosException;

/**
 * Classe que faz uma contagem simples para um desafio da DIO
 */
public class Contador {
    /**
     * Método main a ser chamado quando a classe é invocada
     * via terminal
     *
     * @param args Parâmetros passados via CLI
     */
    public static void main(String[] args) {
        int parametroUm = receberParametro("Digite o primeiro parâmetro");
        int parametroDois = receberParametro("Digite o segundo parâmetro");
        
        try {
            contar(parametroUm, parametroDois);
        
        }catch (ParametrosInvalidosException exception) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    /**
     * Permite informar uma mensagem para instruir o usuário a passar um
     * parâmetro via CLI. Recee este parâmetro também
     *
     * @param mensagem Mensagem a ser passada para o usuário antes de receber
     *                 o parâmetro
     *
     * @return Retorna o parâmetro passado pelo usuário,
     *         parâmetrorecebido via CLI
     */
    static int receberParametro(String mensagem) {
        Scanner terminal = new Scanner(System.in);
        int parametro;
        while (true) {
            try {
                System.out.print(mensagem + ": ");
                parametro = terminal.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("\nVocê precisa passar um número inteiro.\n");
                terminal.next();
            }
        }
        return parametro;
    }

    /**
     * Faz uma contagem entre o parâmetro um e o parâmetro dois
     *
     * @param parametroUm   Parâmetro 1 que o usuário informou anteriormente
     * @param parametroDois Parâmetro 2 que o usuário informou anteriormente
     * @throws ParametrosInvalidosException Se parametroUm > parametroDois
     */
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException();
        } else {
            System.out.println("O número de contagens que faremos é igual à diferença entre o primeiro e o segundo parâmetro. ");

            int diferenca = parametroDois - parametroUm;
            for (int i = 1; i <= diferenca; i++) {
                System.out.println("O número desta iteração é o: " + i);
            }
        }
    }
}
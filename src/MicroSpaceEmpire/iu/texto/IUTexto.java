package MicroSpaceEmpire.iu.texto;

import MicroSpaceEmpire.modelo.Jogo;
import MicroSpaceEmpire.modelo.estados.AguardaInicio;
import MicroSpaceEmpire.modelo.estados.AguardaAposta;
import MicroSpaceEmpire.modelo.estados.AguardaOpcao;
import MicroSpaceEmpire.modelo.estados.Sair;
import java.util.Scanner;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class IUTexto {

    private Jogo jogo;
    private Scanner s;

    public IUTexto(Jogo jogo) {
        this.jogo = jogo;
        s = new Scanner(System.in);
    }

    private void mostraJogo() {
        System.out.println(jogo);
    }

    private void iuAguardaInicio() {
        int opcao;
        System.out.println("Seleccione uma opção");
        System.out.println("1-Iniciar");
        System.out.println("2-Carregar jogo");
        System.out.print("> ");

        while (!s.hasNextInt()) {
            s.next();
        }

        opcao = s.nextInt();

        if (opcao == 1) {
            jogo.iniciar();
        }
    }

    private void iuAguardaAposta() {
        int value;

        System.out.println("\n\n---------------------------------");
        mostraJogo();

        System.out.println();
        System.out.println("Apostar ate " + jogo.getPontuacao() + " ponto(s) ou -1 para terminar o jogo");
        System.out.print("> ");

        while (!s.hasNextInt()) {
            s.next();
        }

        value = s.nextInt();

        if (value >= 0) {
            jogo.apostar(value);
        } else {
            jogo.terminar();
        }

    }

    private void iuAguardaOpcao() {
        int value;

        System.out.println("\n\n---------------------------------");
        mostraJogo();

        System.out.println();
        System.out.println("Retirada do saco: bola PRETA");
        System.out.println();
        System.out.println("1-Perder um ponto");
        System.out.println("2-Remover duas bolas do saco (as bolas pretas voltam para o saco e as bolas brancas sao removidas do jogo)");
        System.out.print("> ");

        while (!s.hasNextInt()) {
            s.next();
        }

        value = s.nextInt();

        if (value == 1) {
            jogo.removerBolaBrancaDePontuacao();
        } else if (value == 2) {
            jogo.retirarDuasBolasDoSaco();
        }

    }

    public void corre() {

        while (!(jogo.getEstado() instanceof Sair)) {

            if (jogo.getEstado() instanceof AguardaInicio) {
                iuAguardaInicio();
            } else if (jogo.getEstado() instanceof AguardaAposta) {
                iuAguardaAposta();
            } else if (jogo.getEstado() instanceof AguardaOpcao) {
                iuAguardaOpcao();
            }

        }

        System.out.println();
        System.out.println("************** Fim do jogo *****************");
        mostraJogo();

    }

}

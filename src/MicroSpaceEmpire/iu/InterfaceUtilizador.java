package MicroSpaceEmpire.iu;

import MicroSpaceEmpire.modelo.MaquinaDeEstados;
import java.util.Scanner;
import MicroSpaceEmpire.modelo.logica.*;

/**
 *
 * @author David
 */
public class InterfaceUtilizador {

    private MaquinaDeEstados ME;
    private Scanner sc;

    public InterfaceUtilizador(MaquinaDeEstados ME) {
        this.ME = ME;
        sc = new Scanner(System.in);
    }

    private void PrintGame() {
        System.out.println(ME);
    }

    public void LetTheGameBeggin() {
        
        while (!(ME.getEstado() instanceof Fim)) {

            if (ME.getEstado() instanceof MenuInicial) {
                iuMenuInicial();
            } else if (ME.getEstado() instanceof Estado_1) {
                iuEstado_1();
            } else if (ME.getEstado() instanceof Estado_2) {
                iuEstado_2();
            } else if (ME.getEstado() instanceof Estado_3) {
                iuEstado_3();
            } else if (ME.getEstado() instanceof Estado_4) {
                iuEstado_4();
            }

        }

        System.out.println();
        System.out.println("************** Fim do jogo *****************");

    }

    private void iuMenuInicial() {
        int opcao;
        System.out.println("Seleccione uma opção:");
        System.out.println("1-Iniciar");
        System.out.println("2-Carregar jogo");
        System.out.println("0-Sair");
        System.out.print("> ");

        while (!sc.hasNextInt()) {
            sc.next();
        }
        opcao = sc.nextInt();
        switch (opcao) {

            case 1:
                ME.NovoJogo();
                break;
            case 2:
                ME.CarregarJogo();
                break;
            case 0:
                ME.Sair();
                break;
            default:
                ME.setEstado(ME.getEstado());
                break;
        }
    }

    private void iuEstado_1() {
        PrintGame();
        int opcao;

        System.out.println("\n\n---------------------------------");

        System.out.println();
        System.out.println("1 - Explorar sistema proximo");
        System.out.println("2 - Explorar sistema distante");
        System.out.println("3 - Conquistar sistema");
        System.out.println("8 - Passar");
        System.out.println("9 - Guardar jogo");
        System.out.println("0 - Sair");
        System.out.print("> ");

        while (!sc.hasNextInt()) {
            sc.next();
        }

        opcao = sc.nextInt();
        switch (opcao) {

            case 1:
                ME.ExplorarNearSystem();
                break;
            case 2:
                ME.ExplorarDistantSystem();
                break;
            case 3:
                ME.ConquistarSistema();
                break;
            case 8:
                ME.Passar();
                break;
            case 9:
                ME.GuardarJogo();
                break;
            case 0:
                ME.Sair();
                break;
            default:
                ME.setEstado(ME.getEstado());
                break;

        }
    }

    private void iuEstado_2() {
        PrintGame();
        int opcao;

        System.out.println("\n\n---------------------------------");

        System.out.println();
        System.out.println("1 - Transformar metal em riqueza");
        System.out.println("2 - Transformar riqueza em metal");
        System.out.println("8 - Passar");
        System.out.println("9 - Guardar jogo");
        System.out.println("0 - Sair");
        System.out.print("> ");

        while (!sc.hasNextInt()) {
            sc.next();
        }

        opcao = sc.nextInt();
        switch (opcao) {

            case 1:
                ME.DecMetalIncRiqueza();
                break;
            case 2:
                ME.DecRiquezaIncMetal();
                break;
            case 8:
                ME.Passar();
                break;
            case 9:
                ME.GuardarJogo();
                break;
            case 0:
                ME.Sair();
                break;
            default:
                ME.setEstado(ME.getEstado());
                break;

        }

    }

    private void iuEstado_3() {
        PrintGame();
        int opcao;

        System.out.println("\n\n---------------------------------");

        System.out.println();
        System.out.println("1 - Construir força militar");
        System.out.println("2 - Comprar tecnologia");
        System.out.println("3 - Construir força militar e comprar tecnologia");
        System.out.println("8 - Passar");
        System.out.println("9 - Guardar jogo");
        System.out.println("0 - Sair");
        System.out.print("> ");

        while (!sc.hasNextInt()) {
            sc.next();
        }

        opcao = sc.nextInt();
        switch (opcao) {

            case 1:
                ME.ConstruirForcaMilitar();
                break;
            case 2:
                ME.DescobrirTecnologia();
                break;
            case 3:
                ME.DescobrirEConstruir();
                break;
            case 8:
                ME.Passar();
                break;
            case 9:
                ME.GuardarJogo();
                break;
            case 0:
                ME.Sair();
                break;
            default:
                ME.setEstado(ME.getEstado());
                break;

        }

    }

    private void iuEstado_4() {
        PrintGame();
        int opcao;

        System.out.println("\n\n---------------------------------");

        System.out.println();
        System.out.println("1 - Avançar");
        System.out.println("9 - Guardar jogo");
        System.out.println("0 - Sair");
        System.out.print("> ");

        while (!sc.hasNextInt()) {
            sc.next();
        }

        opcao = sc.nextInt();
        switch (opcao) {

            case 1:
                ME.RetirarEvento();
                break;
            case 8:
                ME.Passar();
                break;
            case 9:
                ME.GuardarJogo();
                break;
            case 0:
                ME.Sair();
                break;
            default:
                ME.setEstado(ME.getEstado());
                break;

        }

    }

}

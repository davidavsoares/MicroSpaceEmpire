package MicroSpaceEmpire.iu.texto;

import MicroSpaceEmpire.modelo.Jogo;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Main {

    public static void main(String[] args) {
        MainMenu ui = new MainMenu(new Jogo());
        ui.corre();
    }
}

package MicroSpaceEmpire;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.iu.GUI.MicroSpaceEmpireFrame;

public class Main_GUI {

    public static void main(String args[]) {

        ObservableGame ob = new ObservableGame();
        new MicroSpaceEmpireFrame(ob);
    }

}

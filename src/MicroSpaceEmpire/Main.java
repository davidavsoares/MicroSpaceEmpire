package MicroSpaceEmpire;

import MicroSpaceEmpire.iu.InterfaceUtilizador;
import MicroSpaceEmpire.modelo.MaquinaDeEstados;

public class Main {

    /**
     * I.S.E.C.
     *
     * @author DavidSoares [21220084] && JorgeNogueira [21200794]
     * @param args
     */
    public static void main(String[] args) {
        InterfaceUtilizador ui = new InterfaceUtilizador(new MaquinaDeEstados());
        ui.LetTheGameBeggin();
    }

}


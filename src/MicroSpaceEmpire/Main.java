package MicroSpaceEmpire;

import MicroSpaceEmpire.iu.InterfaceUtilizador;
import MicroSpaceEmpire.modelo.MaquinaDeEstados;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfaceUtilizador ui = new InterfaceUtilizador(new MaquinaDeEstados());
        ui.LetTheGameBeggin();
    }

}

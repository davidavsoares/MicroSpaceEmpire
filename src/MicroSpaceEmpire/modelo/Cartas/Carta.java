package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class Carta implements java.io.Serializable {

    private static final long serialVersionUID = 42L;
    private Dados GameInfo;

    public Carta(Dados GameInfo) {
        this.GameInfo = GameInfo;

    }

    public Dados getGameInfo() {
        return GameInfo;
    }

}

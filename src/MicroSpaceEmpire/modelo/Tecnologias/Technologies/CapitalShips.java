package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class CapitalShips extends Technology {

    public CapitalShips() {
        super("Capital Ships");
    }

    @Override
    public String toString() {
        return "CapitalShips";
    }

    public void fazEfeito() {
        //faz os efeitos da carta
    }
}

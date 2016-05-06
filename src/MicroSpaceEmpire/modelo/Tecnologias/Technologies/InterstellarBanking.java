package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class InterstellarBanking extends Technology {

    public InterstellarBanking() {
        super("Interstellar Banking");
    }

    public void fazEfeito() {
        //faz os efeitos da carta
    }

    @Override
    public String toString() {
        return "InterstellarBanking";
    }
}

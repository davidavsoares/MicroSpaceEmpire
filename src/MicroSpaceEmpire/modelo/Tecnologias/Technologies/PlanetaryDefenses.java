package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class PlanetaryDefenses extends Technology {

    public PlanetaryDefenses() {
        super("Planetary Defenses");
    }

    @Override
    public String toString() {
        return "Planetary Defenses";
    }

    public void fazEfeito() {
        //faz os efeitos da carta
    }
}

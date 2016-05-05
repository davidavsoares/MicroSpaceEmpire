package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Strike extends Event {

    public Strike() {
        super("Strike");
    }

    public void fazEfeito() {
        //faz os efeitos da carta
        // year 1 : No resources next turn
        // year 1 : No resources next turn
        //Optional : With Robot Workers, gain 1/2 instead of zero(round up)
    }

}

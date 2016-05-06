package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Asteroid extends Event {

    public Asteroid(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Asteroid";
    }

    public void fazEfeito() {
        //faz os efeitos da carta
        // year 1 : +1 Wealth
        // year 1 : +1 Wealth
    }
}

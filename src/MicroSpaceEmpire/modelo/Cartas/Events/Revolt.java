package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Revolt extends Event {

    public Revolt(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Revolt";
    }

    public void fazEfeito() {
        //faz os efeitos da carta
        // Against System with Least Resistance
        // year 1 : Force +2
        // year 1 : Force +3
        //Optional : +1 System Resistance with Hyper Television
    }
}

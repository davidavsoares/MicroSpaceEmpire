package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class PeaceQuiet extends Event {

    public PeaceQuiet(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Peace & Quiet";
    }

    public void CorreEvento() {
        // não faz nada
    }
}

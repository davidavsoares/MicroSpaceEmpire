package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.PlanetaryDefenses;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class SmallInvasionForce extends Event {

    public SmallInvasionForce(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Small Invasion Force";
    }

    @Override
    public void CorreEvento() {
        int Forca, ResistenciaExtra = 0;

        if (getGameInfo().getANO() == 1) {
            if (getGameInfo().getEmpire().size() == 1) {
                return;
            }
            Forca = 1 + getGameInfo().Dice();
        } else {
            Forca = 2 + getGameInfo().Dice();
        }
        if (getGameInfo().getTechnologyDiscovered().contains(new PlanetaryDefenses(getGameInfo()))) {
            ResistenciaExtra = 1;
        }

        if (Forca >= getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).getResistance() + ResistenciaExtra) {
            getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).SaiImperioEntraUnaligned();
        }
    }
}

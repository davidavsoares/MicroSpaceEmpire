package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.PlanetaryDefenses;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class LargeInvasionForce extends Event {

    public LargeInvasionForce(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Large Invasion Force";
    }

    public void CorreEvento() {
        int Forca;
        if (getGameInfo().getANO() == 1) {
            Forca = 2 + getGameInfo().Dice();
        } else {
            Forca = 3 + getGameInfo().Dice();
        }

        if (Forca >= getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).getResistance()) {

            getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).DesintegrarImperio();
        } else if (getGameInfo().getTechnologyDiscovered().contains(new PlanetaryDefenses(getGameInfo()))) {
            getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).setResistance(getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).getResistance() + 1);
        }
    }
}

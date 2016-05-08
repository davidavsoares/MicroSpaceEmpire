package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.HyperTelevision;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.PlanetaryDefenses;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Revolt2 extends Event {

    public Revolt2(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Revolt";
    }

    public void CorreEvento() {
        int Forca;
        if (!(getGameInfo().getANO() == 2 && getGameInfo().getEmpire().size() == 1)) {
            if (getGameInfo().getANO() == 1) {
                Forca = 1 + getGameInfo().Dice();
            } else {
                Forca = 3 + getGameInfo().Dice();
            }

            if (getGameInfo().getEmpire().size() > 1 && getGameInfo().getTechnologyDiscovered().contains(new HyperTelevision(getGameInfo()))) {
                if (Forca >= (getGameInfo().getMenorResistencia().getResistance() + 1)) {
                    getGameInfo().getMenorResistencia().DesintegrarImperio();
                }
            } else if (Forca >= (getGameInfo().getMenorResistencia().getResistance())) {
                getGameInfo().getMenorResistencia().DesintegrarImperio();
            }
        } else {
            getGameInfo().getEmpire().get(0).DesintegrarImperio();
        }
    }

}

package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.HyperTelevision;

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

    @Override
    public void CorreEvento() {
        int Forca, ResistenciaExtra = 0;
        if (!(getGameInfo().getANO() == 1 && getGameInfo().getEmpire().size() == 1)) {//O evento não causa efeitos caso: seja o 1 ano e so haja 1 sistema no imperio.
            if (getGameInfo().getANO() == 1) {
                Forca = 1 + getGameInfo().Dice();
            } else {
                Forca = 3 + getGameInfo().Dice();
            }

            if (getGameInfo().getEmpire().size() > 1 && getGameInfo().getTechnologyDiscovered().contains(new HyperTelevision(getGameInfo()))) {
                ResistenciaExtra = 1;

            }
            if (Forca >= (getGameInfo().getMenorResistencia().getResistance() + ResistenciaExtra)) {
                getGameInfo().getMenorResistencia().SaiImperioEntraUnaligned();
            }
        }
    }
}

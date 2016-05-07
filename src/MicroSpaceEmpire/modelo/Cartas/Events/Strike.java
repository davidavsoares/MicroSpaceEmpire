package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.RobotWorkers;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Strike extends Event {

    public Strike(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Strike";
    }

    public void CorreEvento() {

        if (getGameInfo().getTechnologyDiscovered().contains(new RobotWorkers(getGameInfo()))) {
            getGameInfo().setPercentagemProducao(50);
        } else {
            getGameInfo().setPercentagemProducao(0);
        }
    }

}

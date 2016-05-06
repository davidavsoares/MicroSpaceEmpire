package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class PlanetaryDefenses extends Technology {

    public PlanetaryDefenses(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Planetary Defenses";
    }

    public void CompraTecnologia() {
        if (getGameInfo().getTechnologyDiscovered().contains(new RobotWorkers(getGameInfo()))) {
            IntegrarTechnologyDiscovered();
            getGameInfo().removeTechnology(this); //exception para caso de ja ter sido comprado
        } else {
            //exception
        }
    }
}

package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class InterstellarBanking extends Technology {

    public InterstellarBanking(Dados GameInfo) {
        super(GameInfo);
    }

    public boolean CompraTecnologia() {
        if (getGameInfo().getTechnologyDiscovered().contains(new InterspeciesCommerce(getGameInfo()))) {
            IntegrarTechnologyDiscovered();
            getGameInfo().removeTechnology(this); //exception para caso de ja ter sido comprado
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Interstellar Banking";
    }
}

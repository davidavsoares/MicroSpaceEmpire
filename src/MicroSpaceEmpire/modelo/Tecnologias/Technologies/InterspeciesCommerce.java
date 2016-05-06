package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class InterspeciesCommerce extends Technology {

    public InterspeciesCommerce(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Interspecies Commerce";
    }

    public boolean CompraTecnologia() {
        IntegrarTechnologyDiscovered();
        getGameInfo().removeTechnology(this); //exception para caso de ja ter sido comprado
        return true;
    }
}

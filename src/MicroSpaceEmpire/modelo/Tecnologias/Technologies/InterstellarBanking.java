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
        super(GameInfo, 3);

    }

    @Override
    public String toString() {
        return "Interstellar Banking";
    }

    @Override
    public void Usa() {
        getGameInfo().setMaxStorage(5);
}
}

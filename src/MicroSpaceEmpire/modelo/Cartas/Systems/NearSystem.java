package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.Sistema;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class NearSystem extends Sistema {

    public NearSystem(Dados GameInfo) {
        super(GameInfo);
    }

    public void IntegrarNearSystemsDeck() //Função polimorfica para fazer um planeta o Deck the sistemas proximos
    {
        getGameInfo().getNearSystemsDeck().add(this);
    }

}

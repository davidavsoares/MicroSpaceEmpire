package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.System;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class DistantSystem extends System {

    public DistantSystem(Dados GameInfo) {
        super(GameInfo);
    }

    public void IntegrarDistantSystemsDeck() {
        getGameInfo().getDistantSystemsDeck().add(this);
    }   
}

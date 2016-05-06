package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.System;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class NearSystem extends System {

    private int Resistance;

    public NearSystem(Dados GameInfo, int r) {
        super(GameInfo);
        Resistance = r;
    }

    @Override
    public int getResistance() {
        return Resistance;
    }

    @Override
    public int getMetalProduction() {
        return 0;
    }

    @Override
    public int getWealthProduction() {
        return 0;
    }

    @Override
    public int getVictoryPoints() {
        return 0;
    }

    public void IntegrarNearSystemsDeck() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getNearSystemsDeck().add(this);
    }

}

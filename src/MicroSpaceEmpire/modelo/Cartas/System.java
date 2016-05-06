package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class System extends Carta {

    public System(Dados GameInfo) {
        super(GameInfo);
    }

    public abstract int getMetalProduction();

    public abstract int getWealthProduction();

    public abstract int getVictoryPoints();

    public abstract int getResistance();

    public void IntegrarImperio() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getEmpire().add(this);
    }

//    public abstract void IntegrarNearSystemsDeck();
//
//    public abstract void IntegrarDistantSystemsDeck();

}

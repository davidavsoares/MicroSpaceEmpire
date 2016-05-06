package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class System extends Carta {

    public System(Dados GameInfo) 
    {
        super(GameInfo);
    }
    
    public int getMetalProduction() 
    {
        return 0;
    }
    
    public int getWealthProduction() 
    {
        return 0;
    }
    
    public int getVictoryPoints() 
    {
        return 0;
    }
    
    public int getResistance() 
    {
        return 0;
    }
    
    public void IntegrarImperio()
    {
        getGameInfo().getEmpire().add(this);
    }
}

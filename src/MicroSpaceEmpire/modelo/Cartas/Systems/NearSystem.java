package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.System;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class NearSystem extends System{
    
    private int Resistance;
    public NearSystem(Dados GameInfo, int r)
    {
        super(GameInfo);
        Resistance = r;
    }
    
    public int getResistance() 
    {
        return Resistance;
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
}

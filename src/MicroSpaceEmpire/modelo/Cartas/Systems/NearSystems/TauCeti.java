package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class TauCeti extends NearSystem {
    private static int VictoryPoints;
    private static int Resistance;
    
    public TauCeti(Dados GameInfo) 
    {
        super(GameInfo);
        VictoryPoints = 1;
        Resistance = 4;
    }

    @Override
    public String toString() 
    {
        return "Tau Ceti";
    }

    @Override
    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }

    @Override
    public int getMetalProduction() 
    {
        return 0;
    }

    @Override
    public int getWealthProduction() 
    {
        return 0;
    }

    @Override
    public int getResistance() 
    {
        return Resistance;
    }
}

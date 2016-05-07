package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Sirius extends NearSystem
{
    private static int VictoryPoints;
    private static int Resistance;
    
    public Sirius(Dados GameInfo) 
    {
        super(GameInfo);
        VictoryPoints = 1;
        Resistance = 6;
    }

    public void setResistance(int Resistance) {
        Sirius.Resistance = Resistance;
    }

    @Override
    public String toString() {
        return "Sirius";
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

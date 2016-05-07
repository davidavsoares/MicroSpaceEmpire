package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Wolf359 extends NearSystem {
    private static int MetalProduction;
    private static int VictoryPoints;
    private static int Resistance;
    
    public Wolf359(Dados GameInfo) 
    {
        super(GameInfo);
        MetalProduction = 1;
        VictoryPoints = 1;
        Resistance = 5;
    }

    public void setResistance(int Resistance) {
        Wolf359.Resistance = Resistance;
    }

    @Override
    public String toString() 
    {
        return "Wolf 359";
    }

    @Override
     public int getVictoryPoints() 
    {
        return VictoryPoints;
    }
    
    @Override
    public int getMetalProduction() 
    {
        return MetalProduction;
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

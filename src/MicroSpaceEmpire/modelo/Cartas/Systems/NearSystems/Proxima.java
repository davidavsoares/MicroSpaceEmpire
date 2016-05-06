package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Proxima extends NearSystem {
    private static int MetalProduction;
    private static int VictoryPoints;
    
    public Proxima(Dados GameInfo) 
    {
        super(GameInfo, 6);
        MetalProduction = 1;
        VictoryPoints = 1;
    }

    @Override
    public String toString() {
        return "Proxima";
    }

    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }
    
    public int getMetalProduction() 
    {
        return MetalProduction;
    }

}

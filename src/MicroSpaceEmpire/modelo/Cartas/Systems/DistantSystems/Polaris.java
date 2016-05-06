package MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Polaris extends DistantSystem {
    private static int MetalProduction;
    private static int VictoryPoints;
    
    public Polaris(Dados GameInfo) {
        super(GameInfo, 9);
        MetalProduction = 1;
        VictoryPoints = 2;
    }

    @Override
    public String toString() {
        return "Polaris";
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

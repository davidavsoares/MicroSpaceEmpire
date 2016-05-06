package MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Canopus extends DistantSystem {
    private static int WealthProduction;
    private static int VictoryPoints;
    
    public Canopus(Dados GameInfo) {
        super(GameInfo, 9);
        WealthProduction = 1;
        VictoryPoints = 2;
    }

    @Override
    public String toString() {
        return "Canopus";
    }

    public int getWealthProduction() 
    {
        return WealthProduction;
    }
    
    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }
}

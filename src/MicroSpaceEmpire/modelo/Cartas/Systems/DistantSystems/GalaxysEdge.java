package MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class GalaxysEdge extends DistantSystem {
    private static int VictoryPoints;
    
    public GalaxysEdge(Dados GameInfo) {
        super(GameInfo, 10);
        VictoryPoints = 3;
    }

    @Override
    public String toString() {
        return "GalaxysEdge";
    }

    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }
}

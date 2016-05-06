package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class EpsilonEridani extends NearSystem {
    private static int VictoryPoints;
    
    public EpsilonEridani(Dados GameInfo) {
        super(GameInfo, 8);
        VictoryPoints = 1;
    }

    @Override
    public String toString() {
        return "EpsilonEridani";
    }

    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }

}

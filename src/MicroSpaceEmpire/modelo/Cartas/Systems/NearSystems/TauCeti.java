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
    
    public TauCeti(Dados GameInfo) 
    {
        super(GameInfo, 4);
        VictoryPoints = 1;
    }

    @Override
    public String toString() {
        return "TauCeti";
    }

    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }
}

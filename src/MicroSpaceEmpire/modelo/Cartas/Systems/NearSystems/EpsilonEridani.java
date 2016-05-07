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
    private static int Resistance;
    
    public EpsilonEridani(Dados GameInfo) {
        super(GameInfo);
        VictoryPoints = 1;
        Resistance = 8;
    }

    public void setResistance(int Resistance) {
        EpsilonEridani.Resistance = Resistance;
    }

    @Override
    public String toString() {
        return "Epsilon Eridani";
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

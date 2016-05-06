package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Cygnus extends NearSystem {
    private static int WealthProdution;
    private static int VictoryPoints;

    @Override
    public String toString() {
        return "Cygnus";
    }
    
    public Cygnus(Dados GameInfo) 
    {
        super(GameInfo, 5);
        WealthProdution = 1;
        VictoryPoints = 1;
    }

    public int getWealthProduction() 
    {
        return WealthProdution;
    }
    
    public int getVictoryPoints() 
    {
        return VictoryPoints;
    }
}

package MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Procyon extends NearSystem {
    private static int WealthProdution;
    private static int VictoryPoints;
    
    public Procyon(Dados GameInfo) {
        super(GameInfo, 7);
        WealthProdution = 1;
        VictoryPoints = 1;
    }

    @Override
    public String toString() {
        return "Procyon";
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

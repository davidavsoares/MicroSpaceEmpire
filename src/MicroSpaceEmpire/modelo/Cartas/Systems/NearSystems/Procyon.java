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
    private static int Resistance;
    
    public Procyon(Dados GameInfo) {
        super(GameInfo);
        WealthProdution = 1;
        VictoryPoints = 1;
        Resistance = 7;
    }

    public void setResistance(int Resistance) {
        Procyon.Resistance = Resistance;
    }

    @Override
    public String toString() {
        return "Procyon";
    }

    @Override
    public int getWealthProduction() 
    {
        return WealthProdution;
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
    public int getResistance() 
    {
        return Resistance;
    }

}

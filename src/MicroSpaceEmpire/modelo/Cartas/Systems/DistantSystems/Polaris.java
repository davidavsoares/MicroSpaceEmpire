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
    private static int Resistance;

    public Polaris(Dados GameInfo) {
        super(GameInfo);
        MetalProduction = 1;
        VictoryPoints = 2;
        Resistance = 9;
    }

    public void setResistance(int Resistance) {
        Polaris.Resistance = Resistance;
    }

    @Override
    public String toString() {
        return "Polaris";
    }

    public int getVictoryPoints() {
        return VictoryPoints;
    }

    public int getMetalProduction() {
        return MetalProduction;
    }

    @Override
    public int getWealthProduction() {
        return 0;
    }

    @Override
    public int getResistance() {
        return Resistance;
    }
}

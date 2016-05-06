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
    private static int Resistance;

    public Canopus(Dados GameInfo) {
        super(GameInfo);
        WealthProduction = 1;
        VictoryPoints = 2;
        Resistance = 9;
    }

    @Override
    public String toString() {
        return "Canopus";
    }
    @Override
    public int getWealthProduction() {
        return WealthProduction;
    }
    @Override
    public int getVictoryPoints() {
        return VictoryPoints;
    }
    @Override
    public int getMetalProduction() {
        return 0;
    }
    @Override
    public int getResistance() {
        return Resistance;
    }
}

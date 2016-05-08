package MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Canopus extends DistantSystem {

    private static final int MetalProduction = 0;
    private static final int WealthProduction = 1;
    private static final int VictoryPoints = 2;
    private static final int Resistance = 9;

    public Canopus(Dados GameInfo) {
        super(GameInfo);
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
        return MetalProduction;
    }

    @Override
    public int getResistance() {
        return Resistance;
    }
}

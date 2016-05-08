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
    private static int Resistance;

    public GalaxysEdge(Dados GameInfo) {
        super(GameInfo);
        VictoryPoints = 3;
        Resistance = 10;
    }

    @Override
    public String toString() {
        return "Galaxy's Edge";
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
    public int getWealthProduction() {
        return 0;
    }

    @Override
    public int getResistance() {
        return Resistance;
    }
}

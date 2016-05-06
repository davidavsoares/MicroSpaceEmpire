package MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystem;
import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class HomeWorld extends StartingSystem {

    private static int MetalProduction;
    private static int WealthProduction;

    public HomeWorld(Dados GameInfo) {
        super(GameInfo);
        MetalProduction = 1;
        WealthProduction = 1;
    }

    @Override
    public String toString() {
        return "HomeWorld";
    }

    @Override
    public int getMetalProduction() {
        return MetalProduction;
    }

    @Override
    public int getWealthProduction() {
        return WealthProduction;
    }

    @Override
    public int getVictoryPoints() {
        return 0;
    }

    @Override
    public int getResistance() {
        return 0;
    }
}

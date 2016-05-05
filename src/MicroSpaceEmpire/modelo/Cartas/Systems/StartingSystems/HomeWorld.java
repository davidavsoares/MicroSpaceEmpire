package MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems;

import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystem;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class HomeWorld extends StartingSystem {

    public HomeWorld() {
        super("Home World");
    }

    public void fazEfeito() {
        //faz os efeitos da carta
        // +1 Metal Production
        // +1 Wealth Production
    }
}

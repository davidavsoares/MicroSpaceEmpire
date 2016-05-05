package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.System;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class DistantSystem extends System {

    private int Resistance;

    public DistantSystem(String n, int r) {
        super(n);
        Resistance = r;
    }
}

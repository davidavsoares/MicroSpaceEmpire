package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.System;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class NearSystem extends System{
    
    private int Resistance;
    public NearSystem(String n, int r)
    {
        super(n);
        Resistance = r;
    }
    
}

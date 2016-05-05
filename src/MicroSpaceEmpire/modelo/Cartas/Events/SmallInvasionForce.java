package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class SmallInvasionForce extends Event{
    
    public SmallInvasionForce() 
    {
        super("Small Invasion Force");
    }
    public void fazEfeito()
    {
        //faz os efeitos da carta
        // Against Last Empire System
        // year 1 : Force +1
        // year 1 : Force +2
        //Optional : +1 Resistance with Planetary Defenses
    }
}

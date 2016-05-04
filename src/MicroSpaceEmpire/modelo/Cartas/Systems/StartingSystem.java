/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.modelo.Cartas.Systems;

import MicroSpaceEmpire.modelo.Cartas.System;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class StartingSystem extends System{
    private int Wealth;
    private int Metal;
    
    public StartingSystem(String n, int w, int m)
    {
        super(n);
        Wealth = w;
        Metal = m;
    }

    public StartingSystem() {
        super("Home World");
        this.Wealth = 1;
        this.Metal = 1;
    }

    public int getWealth() {
        return Wealth;
    }

    public int getMetal() {
        return Metal;
    }
    
}

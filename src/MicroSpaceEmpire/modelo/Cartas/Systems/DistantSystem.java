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
public class DistantSystem extends System{
    private int Resistance;
    private int Wealth;
    private int Metal;
    private int VictoryPoints;
    
    public DistantSystem(String n,int r,int w,int m,int vp)
    {
        super(n);
        Wealth = w;
        Metal = m;
        Resistance = r;
        VictoryPoints = vp;
    }
}

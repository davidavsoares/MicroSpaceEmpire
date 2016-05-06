/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class Carta {

    private Dados GameInfo;

    public Carta(Dados GameInfo) {
        this.GameInfo = GameInfo;

    }

    public Dados getGameInfo() {
        return GameInfo;
    }

}

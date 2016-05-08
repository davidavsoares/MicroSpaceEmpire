/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class Estado_11 extends Estado_0 {

    public Estado_11(Dados GameInfo) {
        super(GameInfo);
    }

    public IEstado ElConquistador(int index) {
        getGameInfo().getUnalignedSystems().get(index - 1).Batalha();
        return new Estado_2(getGameInfo());
    }
}

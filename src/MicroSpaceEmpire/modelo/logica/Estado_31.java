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
public class Estado_31 extends Estado_0 {

    public Estado_31(Dados GameInfo) {
        super(GameInfo);

    }
    @Override
    public IEstado ConstruirForcaMilitar() {
        ConstroiForcaMilitar();
        return new Estado_4(getGameInfo());
    }

    public IEstado Passar() {
        return new Estado_4(getGameInfo());
    }
}

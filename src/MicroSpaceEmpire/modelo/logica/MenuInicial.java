package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class MenuInicial extends Estado_0 {

    public MenuInicial(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public IEstado CarregarJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEstado NovoJogo() {
        return new Estado_1(getGameInfo());
    }
}

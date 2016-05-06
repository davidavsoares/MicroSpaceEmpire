package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class Estado_1 extends Estado_0 {

    public Estado_1(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public IEstado ConquistarSistema() {
        return new Estado_2(getGameInfo());
    }

    @Override
    public IEstado ExplorarNearSystem() {
        return new Estado_2(getGameInfo());
    }

    @Override
    public IEstado ExplorarDistantSystem() {
        return new Estado_2(getGameInfo());
    }

}

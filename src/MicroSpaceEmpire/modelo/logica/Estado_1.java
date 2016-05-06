package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.ForwardStarbases;

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
        if (!getGameInfo().isEmptyUnalignedSystems()) {
            return new Estado_2(getGameInfo());
        } else {
            return this; //Exception
        }
    }

    @Override
    public IEstado ExplorarNearSystem() {
        return new Estado_2(getGameInfo());
    }

    @Override
    public IEstado ExplorarDistantSystem() {
        if (getGameInfo().containsTechnologyDiscovered(new ForwardStarbases())) {
            return new Estado_2(getGameInfo());
        } else {
            return this; //Exception
        }
    }
}

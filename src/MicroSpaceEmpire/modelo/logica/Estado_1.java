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
        if (getGameInfo().isEmptyUnalignedSystems()) {
            
            return new Estado_1(getGameInfo());
        } else {
            return new Estado_11(getGameInfo()); //Exception
        }
    }

    @Override
    public IEstado ExplorarNearSystem() {
        if (getGameInfo().isEmptyUnalignedSystems()) {
            getGameInfo().getNearSystemsDeck().get(0).Batalha();
            return new Estado_2(getGameInfo());
        }
        return this;
    }

    @Override
    public IEstado ExplorarDistantSystem() {
        if (getGameInfo().containsTechnologyDiscovered(new ForwardStarbases(getGameInfo())) && getGameInfo().isEmptyUnalignedSystems()) {
            getGameInfo().getDistantSystemsDeck().get(0).Batalha();
            return new Estado_2(getGameInfo());
        } else {
            return this; //Exception
        }
    }

    public IEstado Passar() {
        return new Estado_2(getGameInfo());
    }
}

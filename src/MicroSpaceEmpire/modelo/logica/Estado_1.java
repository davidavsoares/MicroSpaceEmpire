package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.ForwardStarbases;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_1 extends Estado_Base {

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
            getGameInfo().getNearSystemsDeck().get(0).AtacarSistema();
            return new Estado_2(getGameInfo());
        }
        return this;
    }

    @Override
    public IEstado ExplorarDistantSystem() {
        if (getGameInfo().containsTechnologyDiscovered(new ForwardStarbases(getGameInfo())) && getGameInfo().isEmptyUnalignedSystems()) {
            getGameInfo().getDistantSystemsDeck().get(0).AtacarSistema();
            return new Estado_2(getGameInfo());
        } else {
            return this; //Exception
        }
    }

    @Override
    public IEstado Passar() {
        return new Estado_2(getGameInfo());
    }
}

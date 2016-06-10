package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.InterspeciesCommerce;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_2 extends Estado_Base {

    public Estado_2(Dados GameInfo) {
        super(GameInfo);

        GameInfo.RecolheMetaleRiqueza();

    }

    @Override
    public IEstado DecMetalIncRiqueza() {
        if (getGameInfo().containsTechnologyDiscovered(new InterspeciesCommerce(getGameInfo()))) {
            if (getGameInfo().getMetalStorage() < 2 || getGameInfo().getWealthStorage() == getGameInfo().getMaxStorage()) {
                return this;
            } else {
                getGameInfo().setMetalStorage(getGameInfo().getMetalStorage() - 2);
                getGameInfo().setWealthStorage(getGameInfo().getWealthStorage() + 1);
                return new Estado_3(getGameInfo());
            }
        } else {
            return this;
        }
    }

    @Override
    public IEstado DecRiquezaIncMetal() {
        if (getGameInfo().containsTechnologyDiscovered(new InterspeciesCommerce(getGameInfo()))) {
            if (getGameInfo().getWealthStorage() < 2 || getGameInfo().getMetalStorage() == getGameInfo().getMaxStorage()) {
                return this;
            } else {
                getGameInfo().setMetalStorage(getGameInfo().getMetalStorage() + 1);

                getGameInfo().setWealthStorage(getGameInfo().getWealthStorage() - 2);
                return new Estado_3(getGameInfo());
            }
        } else {
            return this;
        }
    }

    public IEstado Passar() {
        return new Estado_3(getGameInfo());
    }

}

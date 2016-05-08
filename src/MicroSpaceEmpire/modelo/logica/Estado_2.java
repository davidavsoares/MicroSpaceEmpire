package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.InterspeciesCommerce;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_2 extends Estado_0 {

    public Estado_2(Dados GameInfo) {
        super(GameInfo);

        GameInfo.RecolheMetaleRiqueza();

    }

    @Override
    public IEstado DecMetalIncRiqueza() {
        if (getGameInfo().containsTechnologyDiscovered(new InterspeciesCommerce(getGameInfo()))) {
            if (getGameInfo().getMetal() < 2 || getGameInfo().getWealth() == getGameInfo().getMaxStorage()) {
                return this;
            } else {
                getGameInfo().setMetal(getGameInfo().getMetal() - 2);
                getGameInfo().setWealth(getGameInfo().getWealth() + 1);
                return new Estado_3(getGameInfo());
            }
        } else {
            return this;
        }
    }

    @Override
    public IEstado DecRiquezaIncMetal() {
        if (getGameInfo().containsTechnologyDiscovered(new InterspeciesCommerce(getGameInfo()))) {
            if (getGameInfo().getWealth() < 2 || getGameInfo().getMetal() == getGameInfo().getMaxStorage()) {
                return this;
            } else {
                getGameInfo().setMetal(getGameInfo().getMetal() + 1);

                getGameInfo().setWealth(getGameInfo().getWealth() - 2);
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

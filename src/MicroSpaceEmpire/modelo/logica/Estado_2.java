package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class Estado_2 extends Estado_0 {

    public Estado_2(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public IEstado DecMetalIncRiqueza() {
        return new Estado_3(getGameInfo());
    }

    @Override
    public IEstado DecRiquezaIncMetal() {
        return new Estado_3(getGameInfo());
    }
        public IEstado Passar() {
        return new Estado_3(getGameInfo());
    }

}

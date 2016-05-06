package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class Estado_3 extends Estado_0 {

    public Estado_3(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public IEstado DescobrirTecnologia() {
        return new Estado_4(getGameInfo());
    }

    @Override
    public IEstado ConstruirForcaMilitar() {
        return new Estado_4(getGameInfo());
    }

    @Override
    public IEstado DescobrirEConstruir() {
        return new Estado_4(getGameInfo());
    }

}

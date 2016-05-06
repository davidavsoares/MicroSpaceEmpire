package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class Estado_32 extends Estado_0 {

    public Estado_32(Dados GameInfo) {
        super(GameInfo);

    }

    @Override
    public IEstado DescobrirTecnologia(String tech) {
        if (getGameInfo().getTechnology(tech).CompraTecnologia()) {
            return new Estado_4(getGameInfo());
        } else {
            return this;
        }
    }
}

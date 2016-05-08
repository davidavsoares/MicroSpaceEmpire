package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public class Estado_32 extends Estado_0 {

    boolean Repeticao;

    public Estado_32(Dados GameInfo, boolean Repeticao) {
        super(GameInfo);
        this.Repeticao = Repeticao;

    }

    @Override
    public IEstado DescobrirTecnologia(String tech) {
        if (getGameInfo().getTechnology(tech) != null) {
            if (getGameInfo().getTechnology(tech).CompraTecnologia()) {
                if (Repeticao) {
                    return new Estado_31(getGameInfo());
                } else {
                    return new Estado_4(getGameInfo());
                }
            }
        } else if (Repeticao) {
            return new Estado_31(getGameInfo());
        }
        return new Estado_4(getGameInfo());
    }
}

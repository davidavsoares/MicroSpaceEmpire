package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_32 extends Estado_3 {

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
                    //return new Fase_4(getGameInfo());
                    return super.Fase_4();
                }
            } else {
                return this;
            }
        }
        if (Repeticao) {
            return new Estado_31(getGameInfo());
        } else {
            return super.Fase_4();
        }
    }

    @Override
    public IEstado VoltarMenuAnterior() {
        return new Estado_3(getGameInfo(), Repeticao);
    }
}

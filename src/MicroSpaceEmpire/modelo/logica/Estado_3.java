package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_3 extends Estado_0 {

    public boolean Repeticao;

    public Estado_3(Dados GameInfo) {
        super(GameInfo);
        Repeticao = true;

    }

    public boolean isRepeticao() {
        return Repeticao;
    }

    @Override
    public IEstado DescobrirTecnologia() {
        return new Estado_32(getGameInfo(), Repeticao);
    }

    @Override
    public IEstado ConstruirForcaMilitar() {
        if (Repeticao) {
            Repeticao = ConstroiForcaMilitar();
            return this;
        }
        return this;
    }

    public IEstado Passar() {
        return new Estado_4(getGameInfo());
    }

}

package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_31 extends Estado_0 {

    public Estado_31(Dados GameInfo) {
        super(GameInfo);

    }
    @Override
    public IEstado ConstruirForcaMilitar() {
        ConstroiForcaMilitar();
        return new Estado_4(getGameInfo());
    }

    @Override
    public IEstado Passar() {
        return new Estado_4(getGameInfo());
    }
}

package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_31 extends Estado_3 {

    public Estado_31(Dados GameInfo) {
        super(GameInfo);

    }

    @Override
    public IEstado ConstruirForcaMilitar() {
        if (!ConstroiForcaMilitar()) {
            //        return new Fase_4(getGameInfo());       // Comentado para possibilitar omissao do estado Fase_4;
            return super.Fase_4();
        } else {
            return this;
        }
    }

    @Override
    public IEstado Passar() {
//        return new Fase_4(getGameInfo());       // Comentado para possibilitar omissao do estado Fase_4;
        return super.Fase_4();
    }
}

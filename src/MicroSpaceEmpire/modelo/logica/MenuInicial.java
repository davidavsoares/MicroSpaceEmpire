package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class MenuInicial extends Estado_0 {

    public MenuInicial(Dados GameInfo) {
        super(GameInfo);
    }

    public IEstado CarregarJogo() {
        return this;
    }

    @Override
    public IEstado NovoJogo() {
        return new Estado_1(getGameInfo());
    }
}

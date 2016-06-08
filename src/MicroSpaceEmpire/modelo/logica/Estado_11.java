package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_11 extends Estado_Base {

    public Estado_11(Dados GameInfo) {
        super(GameInfo);
    }

    @Override
    public IEstado ConquistaUnaligned(int index) {
        getGameInfo().getUnalignedSystems().get(index - 1).AtacarSistema();
        return new Estado_2(getGameInfo());
    }

    @Override
    public IEstado VoltarMenuAnterior() {
        return new Estado_1(getGameInfo());
    }
}

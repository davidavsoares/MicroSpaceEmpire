package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_4 extends Estado_0 {

    public Estado_4(Dados GameInfo) {
        super(GameInfo);
        VerificaFim();
        RetirarEvento();
    }

    @Override
    public void RetirarEvento() {
        getGameInfo().getEventDeck().get(0).TrocaEvento();
    }

    @Override
    public IEstado VerificaFim() {
        if (getGameInfo().getEmpire().isEmpty()) {
            return new Fim(getGameInfo());
        } else if (getGameInfo().getANO() == 1 && getGameInfo().isEmptyEventDeck()) {
            getGameInfo().setANO(2);
            getGameInfo().ReiniciarEventos();
            return new Estado_1(getGameInfo());
        } else if (getGameInfo().getANO() == 2 && getGameInfo().isEmptyEventDeck()) {
            return new Fim(getGameInfo());
        }
        return new Estado_1(getGameInfo());
    }
}

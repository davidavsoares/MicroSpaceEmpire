package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
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
        if (getGameInfo().getANO() == 1 && getGameInfo().isEmptyEventDeck()) {
            getGameInfo().setANO(2);
            getGameInfo().RecolheEventDeck();
            return new Estado_1(getGameInfo());
        } else if (getGameInfo().getANO() == 2 && getGameInfo().isEmptyEventDeck()) {
            getGameInfo().CalculaVictoryPoints();
            return new Fim(getGameInfo());
        }
        return new Estado_1(getGameInfo());
    }
}

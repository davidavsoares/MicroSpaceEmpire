package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class Event extends Carta {

    public Event(Dados GameInfo) {
        super(GameInfo);
    }

    public void IntegrarEventDeck() //Função fazer um Evento integrar o deck de eventos
    {
        getGameInfo().getEventDeck().add(this);
    }

    public void IntegrarEventDiscard() //Função fazer um Evento integrar o deck de eventos utilizados
    {
        getGameInfo().getEventDiscard().add(this);
    }
}

package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import java.util.ArrayList;
import java.util.Observable;

public class ObservableGame extends Observable {

    MaquinaDeEstados ME;

    public ObservableGame() {
        ME = new MaquinaDeEstados();
    }

    public Dados getDataGame() {
        return ME.getGameInfo();
    }

    public void setMaquinaDeEstados(MaquinaDeEstados ME) {
        this.ME = ME;

        setChanged();
        notifyObservers();
    }

    public MaquinaDeEstados getMaquinaDeEstados() {
        return ME;
    }

    public int getDice() {
        return ME.getDice();
    }

    public ArrayList<Sistema> getEmpire() {
        return ME.getEmpire();
    }

    public ArrayList<Sistema> getUnalignedSystems() {
        return ME.getUnalignedSystems();
    }

    public ArrayList<Event> getEventDeck() {
        return ME.getEventDeck();
    }

    public Event getCurrentEvent() {
        return ME.getCurrentEvent();
    }

    public int getMetalProduction() {
        return ME.getMetalProduction();
    }

    public int getWealthProduction() {
        return ME.getWealthProduction();
    }

    public int getMetalStorage() {
        return ME.getMetalStorage();
    }

    public int getWealthStorage() {
        return ME.getWealthStorage();
    }

    public int getMilitaryStrength() {
        return ME.getMilitaryStrength();
    }

    public void Sair() {
        ME.Sair();

        setChanged();
        notifyObservers();
    }

    public void ExplorarNearSystem() {
        ME.ExplorarNearSystem();
    }

}

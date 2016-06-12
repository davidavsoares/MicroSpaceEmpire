package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;
import MicroSpaceEmpire.modelo.logica.IEstado;
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
        setChanged();
        notifyObservers();
    }

    public void ExplorarDistantSystem() {
        ME.ExplorarNearSystem();
        setChanged();
        notifyObservers();
    }

    public void VoltarMenuAnterior() {
        ME.VoltarMenuAnterior();
        setChanged();
        notifyObservers();
    }

    public void Passar() {
        ME.Passar();
        setChanged();
        notifyObservers();
    }

    public void DecRiquezaIncMetal() {
        ME.DecRiquezaIncMetal();
        setChanged();
        notifyObservers();
    }

    public void DecMetalIncRiqueza() {
        ME.DecMetalIncRiqueza();
        setChanged();
        notifyObservers();
    }

    public void ConstruirForcaMilitar() {
        ME.ConstruirForcaMilitar();
        setChanged();
        notifyObservers();
    }

    public void DescobrirTecnologia() {
        ME.DescobrirTecnologia();
        setChanged();
        notifyObservers();
    }

    public void NovoJogo() {
        ME.NovoJogo();
        setChanged();
        notifyObservers();
    }

    public void DescobrirTecnologia(String Tech) {
        ME.DescobrirTecnologia(Tech);
        setChanged();
        notifyObservers();
    }

    public void Batalha(int opcao) {
        ME.Batalha(opcao + 1);
        setChanged();
        notifyObservers();
    }

    public void ConquistarSistema() {
        ME.ConquistarSistema();
        setChanged();
        notifyObservers();
    }

    public ArrayList<Technology_SuperClasse> getTechnologyDiscovered() {
        return ME.getTechnologyDiscovered();
    }

    public IEstado getEstado() {
        return ME.getEstado();
    }

}

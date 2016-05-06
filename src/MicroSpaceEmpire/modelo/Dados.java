package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.Canopus;
import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.System;
import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystem;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.HomeWorld;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author David
 */
public class Dados {

    private ArrayList<System> NearSystemsDeck;          //Sistemas proximos (Face voltada para baixo)
    private ArrayList<System> DistantSystemsDeck;       //Sistemas distantes (Face voltada para baixo)
    private ArrayList<System> Empire;                   //Sistemas pertencentes ao império
    private ArrayList<System> UnalignedSystems;         //Sistemas desalinhados 
    private ArrayList<Technology> Technologies;         //Tecnologias não desenvolvidas
    private ArrayList<Technology> TechnologyDiscovered; //Tecnologias compradas
    private ArrayList<Event> EventDeck;                 //Eventos (Face voltada para baixo)
    private ArrayList<Event> EventDiscard;              //Eventos já utilizados

    private Event CurrentEvent;                         //Evento actual
    static int ANO;                                     //Ano actual
    private int MilitaryStrength;
    private int Wealth;
    private int VictoryPoints;
    private int metal;
    private int DADO;

    public Dados() {
        DistantSystemsDeck = new ArrayList<>();         //Cria um array com os sistemas distantes
        NearSystemsDeck = new ArrayList<>();            //Cria um array com os sistemas distantes
        Empire = new ArrayList<>();                     //Cria um array com os sistemas que pertencem ao imperio
        UnalignedSystems = new ArrayList<>();           //Cria um array com os sistemas desalinhados
        EventDeck = new ArrayList<>();                  //Cria  um array com os eventos
        TechnologyDiscovered = new ArrayList<>();       //Cria um array com as tecnologias descobertas
        Technologies = new ArrayList<>();
        PreparaJogo();                                  //Chama a funcao que prepara inicialmente o jogo       
    }

    public void PreparaJogo() {
        MilitaryStrength = 0;
        ANO = 1;
        PreparaEventos();
        PreparaSistemas();
        PreparaTecnologias();
        Collections.shuffle(DistantSystemsDeck);        //Baralha o Deck dos sistemas distantes
        Collections.shuffle(NearSystemsDeck);           //Baralha o Deck dos sistemas proximos

        //Empire.add(new HomeWorld());
        (new HomeWorld(this)).IntegrarImperio();

        //~~~~~~~~~~~~~~Retirar o primeiro evento~~~~~~~~~~~~~~~~~~~//
    }

    public void PreparaEventos() {

        (new Asteroid(this)).IntegrarEventDeck();           // Adiciona 'Asteroid' ao Deck de eventos
        (new DerelictShip(this)).IntegrarEventDeck();       // Adiciona 'Derelict Ship' ao Deck de eventos
        (new LargeInvasionForce(this)).IntegrarEventDeck(); // Adiciona 'Large Invasion Force' ao Deck de eventos
        (new Revolt(this)).IntegrarEventDeck();             // Adiciona 'Revolt' ao Deck de eventos
        (new SmallInvasionForce(this)).IntegrarEventDeck(); // Adiciona 'Small Invasion Force' ao Deck de eventos
        (new Strike(this)).IntegrarEventDeck();             // Adiciona 'Strike' ao Deck de eventos
        Collections.shuffle(EventDeck);                     // Baralha o Deck dos eventos

    }

    public void setDADO(int DADO) {
        this.DADO = DADO;
    }

    public void setMilitaryStrength(int MilitaryStrength) {
        this.MilitaryStrength = MilitaryStrength;
        if (this.MilitaryStrength < 0) {
            this.MilitaryStrength = 0;
        }
    }

    public static int getANO() {
        return ANO;
    }

    public int getMilitaryStrength() {
        return MilitaryStrength;
    }

    public void PreparaSistemas() {
        //--------------Distant Systems--------------------------//
        (new Polaris(this)).IntegrarDistantSystemsDeck();
        (new Canopus(this)).IntegrarDistantSystemsDeck();
        (new GalaxysEdge(this)).IntegrarDistantSystemsDeck();
        //--------------Near Systems-----------------------------//
        (new Cygnus(this)).IntegrarNearSystemsDeck();
        (new EpsilonEridani(this)).IntegrarNearSystemsDeck();
        (new Procyon(this)).IntegrarNearSystemsDeck();
        (new Proxima(this)).IntegrarNearSystemsDeck();
        (new Sirius(this)).IntegrarNearSystemsDeck();
        (new TauCeti(this)).IntegrarNearSystemsDeck();
        (new Wolf359(this)).IntegrarNearSystemsDeck();
    }

    public void PreparaTecnologias() {
        (new CapitalShips(this)).IntegrarTechnologies();
        (new ForwardStarbases(this)).IntegrarTechnologies();
        (new RobotWorkers(this)).IntegrarTechnologies();
        (new PlanetaryDefenses(this)).IntegrarTechnologies();
        (new HyperTelevision(this)).IntegrarTechnologies();
        (new InterstellarDiplomacy(this)).IntegrarTechnologies();
        (new InterspeciesCommerce(this)).IntegrarTechnologies();
        (new InterstellarBanking(this)).IntegrarTechnologies();
    }

    public ArrayList<System> getEmpire() {      //Funcao que permite adicionar um sistema ao império
        return Empire;
    }

    public ArrayList<Event> getEventDeck() {       //Funcao que permite adicionar um evento ao Deck correspondente
        return EventDeck;
    }

    public ArrayList<System> getNearSystemsDeck() {       //Funcao que permite adicionar um evento ao Deck correspondente
        return NearSystemsDeck;
    }

    public ArrayList<System> getDistantSystemsDeck() {       //Funcao que permite adicionar um evento ao Deck correspondente
        return DistantSystemsDeck;
    }

    public ArrayList<System> getUnalignedSystems() {        //Funcao que permite adicionar um sistema aos sistemas desalinhados
        return UnalignedSystems;
    }

    public ArrayList<Technology> getTechnologies() {
        return Technologies;
    }

    public int Dice() {
        int dice = (int) (Math.random() * 6 + 1);
        return dice;
    }

    public ArrayList<Technology> getTechnologyDiscovered() {
        return TechnologyDiscovered;
    }

    public ArrayList<Event> getEventDiscard() {             //Funcao que permite adicionar um evento á lista dos já utilizados
        return EventDiscard;
    }

    public boolean isEmptyUnalignedSystems() {
        return UnalignedSystems.isEmpty();
    }

    public boolean isEmptyDistantSystemsDeck() {
        return DistantSystemsDeck.isEmpty();
    }

    public boolean isEmptyEventDeck() {
        return EventDeck.isEmpty();
    }

    public boolean isEmptyEventDiscard() {
        return EventDiscard.isEmpty();
    }

    public boolean isEmptyNearSystemsDeck() {
        return NearSystemsDeck.isEmpty();
    }

    public boolean isEmptyTechnologies() {
        return Technologies.isEmpty();
    }

    public boolean isEmptyTechnologyDiscovered() {
        return TechnologyDiscovered.isEmpty();
    }

    public boolean containsTechnologyDiscovered(Technology o) {
        return TechnologyDiscovered.contains(o);
    }

    public boolean removeTechnology(Technology o) {
        return Technologies.remove(o);
    }

    public boolean removeSystem(System o) {
        if (o instanceof DistantSystem) {
            return DistantSystemsDeck.remove(o);
        } else {
            return NearSystemsDeck.remove(o);
        }
    }

    public Technology getTechnology(String tech) {
        for (Technology Tech : Technologies) {
            if (tech.equalsIgnoreCase(Tech.toString())) {
                return Tech;
            }
        }
        return null; //CRIAR EXCEPTION
    }

    @Override
    public String toString() {
        String s;

        s = "\n\n" + "Império: " + Empire;                                     //Imprime as cartas que fazem parte do império
        s += "\n" + "Unaligned Systems: " + UnalignedSystems;
        s += "\n" + "Tecnologias descobertas: " + TechnologyDiscovered;         //Imprime as cartas que fazem parte do império
        s += "\n" + "Evento actual: " + CurrentEvent;                           //Imprime a carta de evento actual
        s += "\n" + "Eventos descartados: " + EventDiscard;                     //Imprime os eventos que já ocorreram
        s += "\n" + "Dado: " + DADO;
        s += "\n" + "Military Strength: " + MilitaryStrength;
//        s += "\n\t(" + bolasBrancasRemovidas.size() + " bolas brancas):" + bolasBrancasRemovidas;
//        s += "\n\t(" + bolasPretasRemovidas.size() + " bolas pretas):" + bolasPretasRemovidas;

        return s;
    }

}

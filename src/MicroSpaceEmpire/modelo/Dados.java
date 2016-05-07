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
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author David
 */
public class Dados implements java.io.Serializable {

    private static final long serialVersionUID = 42L;
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
    private int WealthProduction;
    private int MetalProduction;
    private int MilitaryStrength;
    private int Wealth;
    private int VictoryPoints;
    private int Metal;
    private int DADO;
    private int MaxStorage;
    private int MaxMilitary;
    private int MaxProdution;
    private int PercentagemProducao;

    public Dados() {

        DistantSystemsDeck = new ArrayList<>();         //Cria um array com os sistemas distantes
        NearSystemsDeck = new ArrayList<>();            //Cria um array com os sistemas distantes
        Empire = new ArrayList<>();                     //Cria um array com os sistemas que pertencem ao imperio
        UnalignedSystems = new ArrayList<>();           //Cria um array com os sistemas desalinhados
        EventDeck = new ArrayList<>();                  //Cria  um array com os eventos
        EventDiscard = new ArrayList<>();
        TechnologyDiscovered = new ArrayList<>();       //Cria um array com as tecnologias descobertas
        Technologies = new ArrayList<>();
        PreparaJogo();                                  //Chama a funcao que prepara inicialmente o jogo       
    }

    public void PreparaJogo() {
        PercentagemProducao = 100;
        MaxProdution = 5;
        MaxStorage = 3;
        MaxMilitary = 3;
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
        (new Revolt2(this)).IntegrarEventDeck();            // Adiciona 'Revolt2' ao Deck de eventos
        (new SmallInvasionForce(this)).IntegrarEventDeck(); // Adiciona 'Small Invasion Force' ao Deck de eventos
        (new Strike(this)).IntegrarEventDeck();             // Adiciona 'Strike' ao Deck de eventos
        Collections.shuffle(EventDeck);                     // Baralha o Deck dos eventos

    }

    public void setANO(int ANO) {
        Dados.ANO = ANO;
    }

    public System getMenorResistencia() {
        if (Empire.size() == 1) {
            return Empire.get(0);
        }
        int min = 20, index = 0;
        for (int i = 1; i < Empire.size(); i++) {
            if (Empire.get(i).getResistance() < min) {
                min = Empire.get(i).getResistance();
                index = i;
            }
        }
        return Empire.get(index);

    }

    public void RecolheEventDeck() {
        EventDiscard.add(CurrentEvent);
        Collections.shuffle(EventDiscard);
        for (int i = 0; i < EventDiscard.size() - 2; i++) {
            EventDeck.add(EventDiscard.get(i));
        }
        EventDiscard.removeAll(EventDiscard);
    }

    public boolean isEmpty() {
        return Empire.isEmpty();
    }

    public int getPercentagemProducao() {
        return PercentagemProducao;
    }

    public void setPercentagemProducao(int PercentagemProducao) {
        this.PercentagemProducao = PercentagemProducao;
    }

    public int getMaxMilitary() {
        return MaxMilitary;
    }

    public void setMaxMilitary(int MaxMilitary) {
        this.MaxMilitary = MaxMilitary;
    }

    public int getMaxStorage() {
        return MaxStorage;
    }

    public void setMaxStorage(int MaxStorage) {
        this.MaxStorage = MaxStorage;
    }

    public void Recolhe() {
        setMetal(Metal + round(MetalProduction * PercentagemProducao / 100));
        setWealth(Wealth + round(WealthProduction * PercentagemProducao / 100));
    }

    public void setMetal(int metal) {
        this.Metal = metal;
        if (this.Metal < 0) {
            Metal = 0;
        } else if (Metal > MaxStorage) {
            Metal = MaxStorage;
        }
    }

    public void setWealth(int Wealth) {
        this.Wealth = Wealth;
        if (this.Wealth < 0) {
            this.Wealth = 0;
        } else if (Wealth > MaxStorage) {
            Wealth = MaxStorage;
        }
    }

    public void setDADO(int DADO) {
        this.DADO = DADO;
    }

    public void setMilitaryStrength(int MilitaryStrength) {
        this.MilitaryStrength = MilitaryStrength;
        if (this.MilitaryStrength < 0) {
            this.MilitaryStrength = 0;
        } else if (this.MilitaryStrength > MaxMilitary) {
            this.MilitaryStrength = MaxMilitary;
        }
    }

    public Event getCurrentEvent() {
        return CurrentEvent;
    }

    public void setCurrentEvent(Event CurrentEvent) {
        this.CurrentEvent = CurrentEvent;
    }

    public int getWealthProduction() {
        return WealthProduction;
    }

    public void setWealthProduction(int WealthProduction) {
        this.WealthProduction = WealthProduction;
        if (this.WealthProduction < 0) {
            this.WealthProduction = 0;
        } else if (WealthProduction > MaxProdution) {
            WealthProduction = MaxProdution;
        }
    }

    public int getMetalProduction() {
        return MetalProduction;
    }

    public void setMetalProduction(int MetalProduction) {
        this.MetalProduction = MetalProduction;
        if (this.MetalProduction < 0) {
            this.MetalProduction = 0;
        } else if (MetalProduction > MaxProdution) {
            MetalProduction = MaxProdution;
        }
    }

    public int getWealth() {
        return Wealth;
    }

    public int getVictoryPoints() {
        return VictoryPoints;
    }

    public void setVictoryPoints(int VictoryPoints) {
        this.VictoryPoints = VictoryPoints;
    }

    public int getMetal() {
        return Metal;
    }

    public int getANO() {
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

    public System DesintegrarImperio(System o) {
        setMetalProduction(o.getMetalProduction());
        setWealthProduction(o.getWealthProduction());
        return Empire.remove(Empire.indexOf(o));
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
        s += "\n" + "Força Militar: " + MilitaryStrength;
        s += "\n" + "Riqueza: " + Wealth;
        s += "\n" + "Producao de Riqueza: " + WealthProduction;
        s += "\n" + "Metal: " + Metal;
        s += "\n" + "Produção de metal: " + MetalProduction;
        //s += "\n" + "Pontos de vitória: " + VictoryPoints;
//        s += "\n\t(" + bolasBrancasRemovidas.size() + " bolas brancas):" + bolasBrancasRemovidas;
//        s += "\n\t(" + bolasPretasRemovidas.size() + " bolas pretas):" + bolasPretasRemovidas;

        return s;
    }

}

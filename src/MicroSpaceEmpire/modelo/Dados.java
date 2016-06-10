package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.Canopus;
import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystem;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.HomeWorld;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.*;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Dados implements java.io.Serializable {

    private static final long serialVersionUID = 42L;           //Permite Guardar e Carregar o jogo

    private final ArrayList<Sistema> NearSystemsDeck;            //Sistemas proximos (Face voltada para baixo)
    private final ArrayList<Sistema> DistantSystemsDeck;         //Sistemas distantes (Face voltada para baixo)
    private final ArrayList<Sistema> Empire;                     //Sistemas pertencentes ao império
    private final ArrayList<Sistema> UnalignedSystems;           //Sistemas desalinhados 
    private final ArrayList<Technology_SuperClasse> TechnologiesAvaliable;           //Tecnologias não desenvolvidas
    private final ArrayList<Technology_SuperClasse> TechnologyDiscovered;   //Tecnologias compradas
    private final ArrayList<Event> EventDeck;                   //Eventos (Face voltada para baixo)
    private final ArrayList<Event> EventDiscard;                //Eventos já utilizados

    private Event CurrentEvent;                                 //Evento actual
    private Event RemovedEvent;                                 //Evento removido ao inicio

    static int ANO;                                             //Ano actual
    private int WealthProduction;                               //Producao de riqueza
    private int MetalProduction;                                //Producao de metal
    private int MilitaryStrength;                               //Capacidade militar
    private int WealthStorage;                                         //Riqueza
    private int VictoryPoints;                                  //Pontos de victoria
    private int MetalStorage;                                          //Metal em Stock
    private int DADO;                                           //Valor que saiu no dado
    private int MaxStorage;                                     //Capacidade de armazenamento
    private int MaxMilitary;                                    //Capacidade militar maxima
    private int MaxProdution;                                   //Producao maxima de riqueza e metal
    private int PercentagemProducao;                            //Percentagem de producao de metal e riqueza

    private boolean Diplomacy = false;

    public Dados() {

        DistantSystemsDeck = new ArrayList<>();         //Cria um array com os sistemas distantes
        NearSystemsDeck = new ArrayList<>();            //Cria um array com os sistemas distantes
        Empire = new ArrayList<>();                     //Cria um array com os sistemas que pertencem ao imperio
        UnalignedSystems = new ArrayList<>();           //Cria um array com os sistemas desalinhados
        EventDeck = new ArrayList<>();                  //Cria  um array com os eventos
        EventDiscard = new ArrayList<>();               //Cria  um array com os eventos já utilizados
        TechnologyDiscovered = new ArrayList<>();       //Cria um array com as tecnologias descobertas
        TechnologiesAvaliable = new ArrayList<>();      //Cria  um array com as tecnologias

        // PreparaJogo();                                  //Chama a funcao que prepara inicialmente o jogo       
    }

    public void PreparaJogo() {
        RemovedEvent = null;
        CurrentEvent = null;
        ANO = 1;
        WealthProduction = 0;
        MetalProduction = 0;
        MilitaryStrength = 0;
        WealthStorage = 0;
        MetalStorage = 0;
        DADO = 0;
        MaxStorage = 3;
        MaxMilitary = 3;
        MaxProdution = 3;
        PercentagemProducao = 100;
        VictoryPoints = 0;

        PreparaEventos();

        PreparaSistemas();

        PreparaTecnologias();
    }

//--------------------------------------------Funcoes dos [SISTEMAS]----------//
    public void PreparaSistemas() {

//---------------------------------------------------Sistema Inicial----------//
        (new HomeWorld(this)).IntegrarImperio();

//------------------------------------------------Sistemas Distantes----------//
        (new Polaris(this)).IntegrarDistantSystemsDeck();
        (new Canopus(this)).IntegrarDistantSystemsDeck();
        (new GalaxysEdge(this)).IntegrarDistantSystemsDeck();
        Collections.shuffle(DistantSystemsDeck);        //Baralha o Deck dos sistemas distantes

//-------------------------------------------------Sistemas Proximos----------//
        (new Cygnus(this)).IntegrarNearSystemsDeck();
        (new EpsilonEridani(this)).IntegrarNearSystemsDeck();
        (new Procyon(this)).IntegrarNearSystemsDeck();
        (new Proxima(this)).IntegrarNearSystemsDeck();
        (new Sirius(this)).IntegrarNearSystemsDeck();
        (new TauCeti(this)).IntegrarNearSystemsDeck();
        (new Wolf359(this)).IntegrarNearSystemsDeck();
        Collections.shuffle(NearSystemsDeck);           //Baralha o Deck dos sistemas proximos
    }

    public boolean removeSystem(Sistema o) {
        if (isEmptyUnalignedSystems()) {
            if (o instanceof DistantSystem) {
                return DistantSystemsDeck.remove(o);
            } else {
                return NearSystemsDeck.remove(o);
            }
        } else {
            return UnalignedSystems.remove(o);
        }
    }

    public boolean getDiplomacy() {
        return Diplomacy;
    }

    public void setDiplomacy(boolean Diplomacy) {
        this.Diplomacy = Diplomacy;
    }
//[Imperio]-------------------------------------------------------------------//    

    public Sistema getMenorResistencia() {       //Funcao para obter o sistema com menor resistencia do império
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

    public void RecolheMetaleRiqueza() {
        setMetalStorage(MetalStorage + round(getMetalProduction() * PercentagemProducao / 100));
        setWealthStorage(WealthStorage + round(WealthProduction * PercentagemProducao / 100));

        setPercentagemProducao(100);
    }

    public void setWealthProduction(int WealthProduction) {
        this.WealthProduction = WealthProduction;
        if (this.WealthProduction < 0) {
            this.WealthProduction = 0;
        } else if (this.WealthProduction > MaxProdution) {
            this.WealthProduction = MaxProdution;
        }
    }

    public void setMetalProduction(int MetalProduction) {
        this.MetalProduction = MetalProduction;
        if (this.MetalProduction < 0) {
            this.MetalProduction = 0;
        } else if (this.MetalProduction > MaxProdution) {
            this.MetalProduction = MaxProdution;
        }
    }

    public ArrayList<Sistema> getEmpire() {      //Funcao que permite adicionar um sistema ao império
        return Empire;
    }

//[Near Sistems]--------------------------------------------------------------// 
    public ArrayList<Sistema> getNearSystemsDeck() {       //Funcao que permite adicionar um evento ao Deck correspondente
        return NearSystemsDeck;
    }

    public boolean isEmptyNearSystemsDeck() {
        return NearSystemsDeck.isEmpty();
    }
//[Distant Sistems]-----------------------------------------------------------// 

    public ArrayList<Sistema> getDistantSystemsDeck() {       //Funcao que permite adicionar um evento ao Deck correspondente
        return DistantSystemsDeck;
    }

    public boolean isEmptyDistantSystemsDeck() {
        return DistantSystemsDeck.isEmpty();
    }
//[Unaligned Sistems]---------------------------------------------------------//

    public ArrayList<Sistema> getUnalignedSystems() {        //Funcao que permite adicionar um sistema aos sistemas desalinhados
        return UnalignedSystems;
    }

    public String getStrUnalignedSystems() {
        String s;
        s = "\n\n" + "Sistemas desalinhados: ";
        for (int i = 0; i < UnalignedSystems.size(); i++) {
            s += "\n" + (i + 1) + " " + UnalignedSystems.get(i).toString();
        }
        return s;
    }

    public boolean isEmptyUnalignedSystems() {
        return UnalignedSystems.isEmpty();
    }

//[TECNOLOGIAS]-----------------------------Funcoes de [TECNOLOGIAS]----------//
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

    public ArrayList<Technology_SuperClasse> getTechnologies() {
        return TechnologiesAvaliable;
    }

    public ArrayList<Technology_SuperClasse> getTechnologyDiscovered() {
        return TechnologyDiscovered;
    }

    public boolean isEmptyTechnologies() {
        return TechnologiesAvaliable.isEmpty();
    }

    public boolean containsTechnologyDiscovered(Technology_SuperClasse o) {
        return TechnologyDiscovered.contains(o);
    }

//    public boolean removeTechnology(Technology_SuperClasse o) {
//        return TechnologiesAvaliable.remove(o);
//    }
    public Technology_SuperClasse getTechnology(String tech) throws StringException {
        if (TechnologiesAvaliable.isEmpty()) {
            throw new StringException("There are no more technologies avaliable to discover");
        }
        for (Technology_SuperClasse Tech : TechnologiesAvaliable) {
            if (tech.equalsIgnoreCase(Tech.toString())) {
                return Tech;
            }
        }
        throw new StringException("Technology already discovered");
    }
//----------------------------------------------Funcoes de [EVENTOS]----------//

    public void PreparaEventos() {

        (new Asteroid(this)).IntegrarEventDeck();           // Adiciona 'Asteroid' ao Deck de eventos
        (new DerelictShip(this)).IntegrarEventDeck();       // Adiciona 'Derelict Ship' ao Deck de eventos
        (new LargeInvasionForce(this)).IntegrarEventDeck(); // Adiciona 'Large Invasion Force' ao Deck de eventos
        (new Revolt(this)).IntegrarEventDeck();             // Adiciona 'Revolt' ao Deck de eventos
        (new Revolt2(this)).IntegrarEventDeck();            // Adiciona 'Revolt2' ao Deck de eventos
        (new SmallInvasionForce(this)).IntegrarEventDeck(); // Adiciona 'Small Invasion Force' ao Deck de eventos
        (new Strike(this)).IntegrarEventDeck();             // Adiciona 'Strike' ao Deck de eventos
        Collections.shuffle(EventDeck);                     // Baralha o Deck dos eventos

        RemovedEvent = EventDeck.get(0);
        EventDeck.remove(0);
    }

    public ArrayList<Event> getEventDeck() {       //Funcao que permite adicionar um evento ao Deck correspondente
        return EventDeck;
    }

    public ArrayList<Event> getEventDiscard() {             //Funcao que permite adicionar um evento á lista dos já utilizados
        return EventDiscard;
    }

    public void ReiniciarEventos() {
        EventDiscard.add(RemovedEvent);
        EventDiscard.add(CurrentEvent);
        Collections.shuffle(EventDiscard);
        for (int i = 0; i < EventDiscard.size() - 2; i++) {
            EventDeck.add(EventDiscard.get(i));
        }
        EventDiscard.removeAll(EventDiscard);
    }

    public boolean isEmptyEventDeck() {
        return EventDeck.isEmpty();
    }

    public boolean isEmptyEventDiscard() {
        return EventDiscard.isEmpty();
    }

    public Event getCurrentEvent() {
        return CurrentEvent;
    }

    public void setCurrentEvent(Event CurrentEvent) {
        this.CurrentEvent = CurrentEvent;
    }

//-------------------------------------------------Funcoes de [JOGO]----------//   
    public void setANO(int ANO) {
        Dados.ANO = ANO;
    }

    public int getPercentagemProducao() {
        return PercentagemProducao;
    }

    public void setPercentagemProducao(int PercentagemProducao) {
        this.PercentagemProducao = PercentagemProducao;
    }

    /*    public int getMaxMilitary() {
    return MaxMilitary;
    }*/
    public void setMaxMilitary(int MaxMilitary) {
        this.MaxMilitary = MaxMilitary;
    }

    public int getMaxStorage() {
        return MaxStorage;
    }

    public void setMaxStorage(int MaxStorage) {
        this.MaxStorage = MaxStorage;
    }

    public void setMetalStorage(int metal) {
        this.MetalStorage = metal;
        if (this.MetalStorage < 0) {
            this.MetalStorage = 0;
        } else if (MetalStorage > MaxStorage) {
            this.MetalStorage = this.MaxStorage;
        }
    }

    public int getMetalProduction() {
        int somatorio = 0;
        for (Sistema imperio : Empire) {
            somatorio += imperio.getMetalProduction();
        }
        return somatorio;
    }

    public int getWealthProduction() {
        int somatorio = 0;
        for (Sistema imperio : Empire) {
            somatorio += imperio.getWealthProduction();
        }
        return somatorio;
    }

    public void setWealthStorage(int WealthStorage) {
        this.WealthStorage = WealthStorage;
        if (this.WealthStorage < 0) {
            this.WealthStorage = 0;
        } else if (this.WealthStorage > MaxStorage) {
            this.WealthStorage = MaxStorage;
        }
    }

    public void setDADO(int DADO) {
        this.DADO = DADO;
    }

    public int getDice() {
        return DADO;
    }

    public int getWealthStorage() {
        return WealthStorage;
    }

    public int getMetalStorage() {
        return MetalStorage;
    }

    public void setMilitaryStrength(int MilitaryStrength) {
        this.MilitaryStrength = MilitaryStrength;
        if (this.MilitaryStrength < 0) {
            this.MilitaryStrength = 0;
        } else if (this.MilitaryStrength > MaxMilitary) {
            this.MilitaryStrength = MaxMilitary;
        }
    }

    public void AdicionaVictoryPoints(int VictoryPoints) {
        this.VictoryPoints += VictoryPoints;
    }

    public int getANO() {
        return ANO;
    }

    public int getMilitaryStrength() {
        return MilitaryStrength;
    }

    public int Dice() {
        int dice = (int) (Math.random() * 6 + 1);
        return dice;
    }

    public String CalculaVictoryPoints() {
        String s;
        s = "\n\n" + "           -------------Victory Points-----------------\n\n";
        // Obtem victory points dos sistemas no imperio //
        for (int i = 0; i < Empire.size(); i++) {
            AdicionaVictoryPoints(Empire.get(i).getVictoryPoints());
        }
        s += "\n" + "           Pontos de império:    " + VictoryPoints;

        // Obtem victory points das tecnologias //
        AdicionaVictoryPoints(TechnologyDiscovered.size());
        s += "\n" + "           Pontos de tecnologias descobertas: " + TechnologyDiscovered.size();
        // Obtem victory points de exploracao //
        if (NearSystemsDeck.isEmpty() && DistantSystemsDeck.isEmpty()) {
            s += "\n" + "           Bónus de Exploração:   1";
            AdicionaVictoryPoints(1);
            // Obtem victory points senhor da guerra //
            if (isEmptyUnalignedSystems()) {
                s += "\n" + "           Bónus senhora da guerra:   3";
                AdicionaVictoryPoints(3);
            }
        }
        // Obtem victory points bonus cientifico //
        if (isEmptyTechnologies()) {
            s += "\n" + "           Bónus cientifico:  1";
            AdicionaVictoryPoints(1);
        }
        s += "\n           Total:   " + VictoryPoints;
        return s;
    }
//------------------------------------------------Funcoes de [Dados]----------//

    @Override
    public String toString() {
        String s;

        s = "\n" + "---------------[ANO " + ANO + "]-------------";
        s += "\n\n" + "Império:          " + Empire;                                     //Imprime as cartas que fazem parte do império
        s += "\n" + "Sistemas desalinhados: " + UnalignedSystems;

        s += "\n\n" + "Tecnologias: " + TechnologiesAvaliable;
        s += "\n" + "Tecnologias descobertas: " + TechnologyDiscovered;         //Imprime as cartas que fazem parte do império

        s += "\n\n" + "Evento actual:       [" + CurrentEvent + "]";                           //Imprime a carta de evento actual
        s += "\n" + "Eventos descartados: " + EventDiscard;                     //Imprime os eventos que já ocorreram

        s += "\n\n" + "[Producao de Riqueza:  " + WealthProduction + "]   ";
        s += "[Riqueza:         " + WealthStorage + " of " + MaxProdution + "]   ";

        s += "\n" + "[Produção de metal:    " + MetalProduction + "]   ";
        s += "[Metal:           " + MetalStorage + " of " + MaxProdution + "]   ";

        s += "\n" + "                            [Força Militar:   " + MilitaryStrength + " of " + MaxMilitary + "]   ";

        s += "\n\n" + "[Valor saido no dado:  " + DADO + "]";

        return s;
    }
}

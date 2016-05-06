package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.System;
import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.HomeWorld;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author David
 */
public class Dados {

    private ArrayList<NearSystem> NearSystems;
    private ArrayList<DistantSystem> DistantSystems;
    private ArrayList<System> Empire;
    private ArrayList<System> UnalignedSystems;
    private ArrayList<Technology> Technologies;
    private ArrayList<Event> EventDeck;
    private ArrayList<Event> EventDiscard;
    private ArrayList<Technology> TechnologyDiscovered;

    private Event CurrentEvent;
    static int ANO;

    public Dados() {
        DistantSystems = new ArrayList<>();       //Cria um array com os sistemas distantes
        NearSystems = new ArrayList<>();       //Cria um array com os sistemas distantes
        Empire = new ArrayList<>();               //Cria um array com os sistemas que pertencem ao imperio
        UnalignedSystems = new ArrayList<>();     //Cria um array com os sistemas desalinhados
        EventDeck = new ArrayList<>();            //Cria  um array com os eventos
        TechnologyDiscovered = new ArrayList<>(); //Cria um array com as tecnologias descobertas

        PreparaJogo();
    }

    public void PreparaJogo() {

//        PreparaEventos();
//        PreparaSistemas();
//        Collections.shuffle(DistantSystems);      //Baralha o Deck dos sistemas distantes
//        Collections.shuffle(NearSystems);          //Baralha o Deck dos sistemas proximos

        //Empire.add(new HomeWorld(this));
        (new HomeWorld(this)).IntegrarImperio();

        //~~~~~~~~~~~~~~Retirar o primeiro evento~~~~~~~~~~~~~~~~~~~//
    }

//    public void PreparaEventos() {
//
//        EventDeck.add(new Asteroid());
//        EventDeck.add(new DerelictShip());
//        EventDeck.add(new LargeInvasionForce());
//        EventDeck.add(new PeaceQuiet());
//        EventDeck.add(new Revolt());
//        EventDeck.add(new SmallInvasionForce());
//        EventDeck.add(new Strike());
//
//        Collections.shuffle(EventDeck);            //Baralha o Deck dos eventos
//
//    }
//
//    public void PreparaSistemas() {
//
//        DistantSystems.add(new Polaris());
//        DistantSystems.add(new Canopus());
//        DistantSystems.add(new GalaxysEdge());
//
//        NearSystems.add(new Cygnus());
//        NearSystems.add(new EpsilonEridani());
//        NearSystems.add(new Procyon());
//        NearSystems.add(new Proxima());
//        NearSystems.add(new Sirius());
//        NearSystems.add(new TauCeti());
//        NearSystems.add(new Wolf359());
//
//    }

       public ArrayList<System> getEmpire() {
        return Empire;
    }
//    
//        public boolean EventDeckVazio() {
//        return EventDeck.isEmpty();
//    }
    @Override
    public String toString() {
        String s;

//        s = "PONTUACAO: " + getPontuacao();
        s = "\n\n" + "Império: " + Empire;                                     //Imprime as cartas que fazem parte do império
        s += "\n" + "Tecnologias descobertas: " + TechnologyDiscovered;         //Imprime as cartas que fazem parte do império
        s += "\n" + "Evento actual: " + CurrentEvent;                           //Imprime a carta de evento actual
        s += "\n" + "Eventos descartados: " + EventDiscard;                     //Imprime os eventos que já ocorreram
//        s += "\n\t(" + bolasBrancasRemovidas.size() + " bolas brancas):" + bolasBrancasRemovidas;
//        s += "\n\t(" + bolasPretasRemovidas.size() + " bolas pretas):" + bolasPretasRemovidas;

        return s;
    }

}

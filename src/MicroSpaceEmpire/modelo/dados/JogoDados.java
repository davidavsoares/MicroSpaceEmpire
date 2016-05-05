package MicroSpaceEmpire.modelo.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.System;

import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.*;

import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.*;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class JogoDados {
    private ArrayList<NearSystem> NearSystems;
    private ArrayList<DistantSystem> DistantSystems;
    private ArrayList<System> Empire;
    private ArrayList<System> UnalignedSystems;
    // private ArrayList<Tecnologie> Tecnologies;
    private ArrayList<Event> EventDeck;
    private ArrayList<Event> EventDiscard;

    private Event CurrentEvent;
    static int ANO;

    public JogoDados() {
//        iniciar();
    }               //Construtor que chama a função iniciar()

    public void iniciar() {

        DistantSystems = new ArrayList<>();       //Cria um array com os sistemas distantes
        Empire = new ArrayList<>();               //Cria um array com os sistemas que pertencem ao imperio
        UnalignedSystems = new ArrayList<>();     //Cria um array com os sistemas desalinhados
        EventDeck = new ArrayList<>();            //Cria  um array com os eventos

        PreparaJogo();
    }

    public void PreparaJogo() {

        PreparaEventos();
        PreparaSistemas();
        Collections.shuffle(DistantSystems);      //Baralha o Deck dos sistemas distantes
        Collections.shuffle(NearSystems);          //Baralha o Deck dos sistemas proximos

        Empire.add(new HomeWorld());
        
        //~~~~~~~~~~~~~~Retirar o primeiro evento~~~~~~~~~~~~~~~~~~~//

    }

    public void PreparaEventos() {

        EventDeck.add(new Asteroid());
        EventDeck.add(new DerelictShip());
        EventDeck.add(new LargeInvasionForce());
        EventDeck.add(new PeaceQuiet());
        EventDeck.add(new Revolt());
        EventDeck.add(new SmallInvasionForce());
        EventDeck.add(new Strike());

        Collections.shuffle(EventDeck);            //Baralha o Deck dos eventos

    }

    public void PreparaSistemas() {

        DistantSystems.add(new Polaris());
        DistantSystems.add(new Canopus());
        DistantSystems.add(new GalaxysEdge());

        NearSystems.add(new Cygnus());
        NearSystems.add(new EpsilonEridani());
        NearSystems.add(new Procyon());
        NearSystems.add(new Proxima());
        NearSystems.add(new Sirius());
        NearSystems.add(new TauCeti());
        NearSystems.add(new Wolf359());

    }

    public int getValoApostado() {
        return valorApostado;
    }

    public boolean setValorApostado(int value) {
        if (bolasBrancasPontuacao.size() < value || value < 0) {
            return false;
        }

        valorApostado = value;
        return true;
    }

    public ArrayList<System> getEmpire() {
        return Empire;
    }

    public List<BolaBranca> getBolasBrancasPontuacao() {
        return bolasBrancasPontuacao;
    }

    public List<BolaBranca> getBolasBrancasRemovidas() {
        return bolasBrancasRemovidas;
    }

    public List<BolaPreta> getBolasPretasRemovidas() {
        return bolasPretasRemovidas;
    }

    public boolean EventDeckVazio() {
        return EventDeck.isEmpty();
    }

    public Bola retiraBolaDoSaco() throws EmptyException {
        int index;

        if (saco.isEmpty()) {
            throw new EmptyException("bag");
        }

        index = (int) (Math.random() * saco.size());
        return saco.remove(index);
    }

    public void retiraBolaBrancaPontuacao() throws EmptyException {

        if (bolasBrancasPontuacao.isEmpty()) {
            throw new EmptyException("pontuacao");
        }
        BolaBranca bola = bolasBrancasPontuacao.remove(0);
        bolasBrancasRemovidas.add(bola);

    }

    public void perdeAposta() {

        try {
            for (int i = 0; i < valorApostado; i++) {
                retiraBolaBrancaPontuacao();
            }
        } catch (EmptyException e) {
        }

        valorApostado = 0;
    }

    public void ganhaAposta() {
        Bola bola;

        try {
            for (int i = 0; i < valorApostado; i++) {

                bola = retiraBolaDoSaco();

//                if(bola instanceof BolaBranca){
//                    saco.add(bola);
//                }else if (bola instanceof BolaPreta){
//                    bolasPretasRemovidas.add((BolaPreta)bola);
//                }
                bola.serReveladaDoSacoAposRetiradaBolaBranca();

            }
        } catch (EmptyException e) {
        }

        valorApostado = 0;

    }

    public int getPontuacao() {
        return bolasBrancasPontuacao.size();
    }

    @Override
    public String toString() {
        String s;

        s = "PONTUACAO: " + getPontuacao();
        s += "\n\n" + "Bolas brancas de pontuacao: " + bolasBrancasPontuacao;
        s += "\n" + "Saco (" + saco.size() + " bolas): " + saco;
        s += "\n" + "Bolas removidas do jogo:";
        s += "\n\t(" + bolasBrancasRemovidas.size() + " bolas brancas):" + bolasBrancasRemovidas;
        s += "\n\t(" + bolasPretasRemovidas.size() + " bolas pretas):" + bolasPretasRemovidas;

        return s;
    }

}

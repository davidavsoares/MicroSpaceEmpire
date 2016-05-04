package MicroSpaceEmpire.modelo.dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class JogoDados {

    private List<Bola> saco;
    private List<BolaBranca> bolasBrancasPontuacao;
    private List<BolaBranca> bolasBrancasRemovidas;
    private List<BolaPreta> bolasPretasRemovidas;
    private int valorApostado;

    //MSE
//    private ArrayList<NearSystem> NearSystems;
//    private ArrayList<DistantSystem> DistantSystems;
//    private ArrayList<System> Empire;
//    private ArrayList<System> UnalignedSystems;
//
//    private ArrayList<Event> EventDeck;
//    private ArrayList<Event> EventDiscard;
//
//    private Event CurrentEvent;
    static final int NBOLAS = 10;

    public JogoDados() {
//        iniciar();
    }

    public void iniciar() {

//        //MSE
//        saco = new ArrayList<>();
//        DistantSystems = new ArrayList<>();
//        Empire = new ArrayList<>();
//        UnalignedSystems = new ArrayList<>();
//
//        EventDeck = new ArrayList<>();

        saco = new ArrayList<>();
        bolasBrancasPontuacao = new ArrayList<>();
        bolasBrancasRemovidas = new ArrayList<>();
        bolasPretasRemovidas = new ArrayList<>();

        for (int i = 0; i < NBOLAS; i++) {
            saco.add(new BolaBranca(this));
            saco.add(new BolaPreta(this));
        }

        Collections.shuffle(saco);

        valorApostado = 0;
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

    public List<Bola> getSaco() {
        return saco;
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

    public boolean isSacoVazio() {
        return saco.isEmpty();
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

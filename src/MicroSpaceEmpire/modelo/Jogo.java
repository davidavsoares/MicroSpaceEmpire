package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.dados.JogoDados;
import MicroSpaceEmpire.modelo.estados.AguardaInicio;
import MicroSpaceEmpire.modelo.estados.IEstado;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Jogo {

    private JogoDados jogoDados;
    private IEstado estado;

    public Jogo() {
        jogoDados = new JogoDados();
        estado = new AguardaInicio(jogoDados);
    }

    public JogoDados getJogoDados() {
        return jogoDados;
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }

    //--- Metodos de consulta de informacao ---
    public int getPontuacao() //Pontos de vitoria
    {
        return jogoDados.getPontuacao();
    }

    @Override
    public String toString() {
        return jogoDados.toString();
    }

    //--- Metodos delegados no estado corrente ---
    public void iniciar() {
        setEstado(getEstado().iniciar());
    }

    public void CarregarJogo() {
        setEstado(getEstado().CarregarJogo());
    }

    public void terminar() {
        setEstado(getEstado().terminar());
    }

    public void apostar(int valorApostado) {
        setEstado(getEstado().apostar(valorApostado));
    }

    public void removerBolaBrancaDePontuacao() {
        setEstado(getEstado().removerBolaBrancaDePontuacao());
    }

    public void retirarDuasBolasDoSaco() {
        setEstado(getEstado().retirarDuasBolasDoSaco());
    }

    public void Estado_1() {
        setEstado(getEstado().Estado_1());
    }

    public void Estado_2() {
        setEstado(getEstado().Estado_2());
    }

    public void Estado_3() {
        setEstado(getEstado().Estado_3());
    }

    public void Estado_4() {
        setEstado(getEstado().Estado_4());
    }

}

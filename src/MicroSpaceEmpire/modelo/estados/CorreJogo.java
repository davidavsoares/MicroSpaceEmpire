package MicroSpaceEmpire.modelo.estados;

import MicroSpaceEmpire.modelo.dados.JogoDados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class CorreJogo implements IEstado {

    private JogoDados jogoDados;

    public CorreJogo(JogoDados jogoDados) {
        this.jogoDados = jogoDados;
    }

    public JogoDados getJogoDados() {
        return jogoDados;
    }

    public void setJogoDados(JogoDados jogoDados) {
        this.jogoDados = jogoDados;
    }

    @Override
    public IEstado iniciar() {
        return this;
    }

    @Override
    public IEstado CarregarJogo() {
        return this;
       

    }

    @Override
    public IEstado terminar() {
        return this;
    }

    @Override
    public IEstado apostar(int nBalls) {
        return this;
    }

    @Override
    public IEstado removerBolaBrancaDePontuacao() {
        return this;
    }

    @Override
    public IEstado retirarDuasBolasDoSaco() {
        return this;
    }

    @Override
    public IEstado Estado_1() {
        return this;
    }

    @Override
    public IEstado Estado_2() {
        return this;
    }

    @Override
    public IEstado Estado_3() {
        return this;
    }

    @Override
    public IEstado Estado_4() {
        return this;
    }

}

package MicroSpaceEmpire.modelo.dados;

import MicroSpaceEmpire.modelo.estados.IEstado;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class Bola {

    private JogoDados jogoDados;

    public Bola(JogoDados jogoDados) {
        this.jogoDados = jogoDados;
    }

    public JogoDados getJogoDados() {
        return jogoDados;
    }

    public void setJogoDados(JogoDados jogoDados) {
        this.jogoDados = jogoDados;
    }

    // consequencia de retirar bola do saco - conforme o tipo de bola
    public abstract IEstado serRetiradaDoSacoAposAposta();

    // uma das opcoes caso tenha sido retirada bola preta
    public abstract void serReveladaDoSacoAposOpcao();

    // saiu bola branca do saco, a aposta foi ganha e revelam-se bolas do saco ...
    public abstract void serReveladaDoSacoAposRetiradaBolaBranca();

}

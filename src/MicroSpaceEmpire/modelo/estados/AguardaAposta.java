package MicroSpaceEmpire.modelo.estados;

import MicroSpaceEmpire.modelo.dados.Bola;
import MicroSpaceEmpire.modelo.dados.JogoDados;
import MicroSpaceEmpire.modelo.dados.EmptyException;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class AguardaAposta extends CorreJogo {

    public AguardaAposta(JogoDados jogoDados) {
        super(jogoDados);
    }

    @Override
    public IEstado terminar() {
        return new Sair(getJogoDados());
    }

    @Override
    public IEstado apostar(int valorApostado) {
        if (!getJogoDados().setValorApostado(valorApostado)) {
            return this;
        }

        Bola bolaRetirada;
        try {
            bolaRetirada = getJogoDados().retiraBolaDoSaco();
        } catch (EmptyException e) {
            return new Sair(getJogoDados());
        }

        return bolaRetirada.serRetiradaDoSacoAposAposta();

    }
}

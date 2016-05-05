package MicroSpaceEmpire.modelo.dados;

import MicroSpaceEmpire.modelo.estados.AguardaAposta;
import MicroSpaceEmpire.modelo.estados.Sair;
import MicroSpaceEmpire.modelo.estados.IEstado;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class BolaBranca extends Bola {

    public BolaBranca(JogoDados jogoDados) {
        super(jogoDados);
    }

    @Override
    public IEstado serRetiradaDoSacoAposAposta() {
        getJogoDados().getBolasBrancasPontuacao().add(this);
        getJogoDados().ganhaAposta();
        if (getJogoDados().EventDeckVazio()) {
            return new Sair(getJogoDados());
        }

        return new AguardaAposta(getJogoDados());
    }

    @Override
    public void serReveladaDoSacoAposOpcao() {
        //According to the rules, the bola is thrown out...
        getJogoDados().getBolasBrancasRemovidas().add(this);
    }

    @Override
    public String toString() {
        return "Branca";
    }

    public void serReveladaDoSacoAposRetiradaBolaBranca() {
        getJogoDados().getEmpire().add(this);
    }
}

package MicroSpaceEmpire.modelo.dados;

import MicroSpaceEmpire.modelo.estados.AguardaOpcao;
import MicroSpaceEmpire.modelo.estados.Sair;
import MicroSpaceEmpire.modelo.estados.IEstado;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class BolaPreta extends Bola {

    public BolaPreta(JogoDados jogoDados) {
        super(jogoDados);
    }

    @Override
    public IEstado serRetiradaDoSacoAposAposta() {
        getJogoDados().getBolasPretasRemovidas().add(this);

        getJogoDados().perdeAposta();

        if (getJogoDados().isSacoVazio()) {
            return new Sair(getJogoDados());    //Should not be necessary...
        }

        return new AguardaOpcao(getJogoDados());
    }

    @Override
    public void serReveladaDoSacoAposOpcao() {
        //According to the rules, the bola returns to the bag...
        getJogoDados().getEmpire().add(this);
    }

    @Override
    public String toString() {
        return "Preta";
    }

    @Override
    public void serReveladaDoSacoAposRetiradaBolaBranca() {
        getJogoDados().getBolasPretasRemovidas().add(this);
    }

}

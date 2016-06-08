package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_Base implements IEstado, java.io.Serializable {

    private static final long serialVersionUID = 42L;
    private final Dados GameInfo;

    public Estado_Base(Dados GameInfo) {
        this.GameInfo = GameInfo;
    }

    public Dados getGameInfo() {
        return GameInfo;
    }

//-----------INICIAR---------//
    @Override
    public IEstado CarregarJogo() {
        return this;
    }

    @Override
    public IEstado NovoJogo() {
        return this;
    }
//-----------ESTADO[1]---------//

    @Override
    public IEstado ConquistarSistema() {
        return this;
    }

    @Override
    public IEstado ExplorarNearSystem() {
        return this;
    }

    @Override
    public IEstado ExplorarDistantSystem() {
        return this;
    }

    @Override
    public IEstado VoltarMenuAnterior() {
        return this;
    }

//-----------ESTADO[2]---------//
    @Override
    public IEstado DecRiquezaIncMetal() {
        return this;
    }

    @Override
    public IEstado DecMetalIncRiqueza() {
        return this;
    }
//-----------ESTADO[3]---------//

    @Override
    public IEstado DescobrirTecnologia() {
        return this;
    }

    @Override
    public IEstado ConstruirForcaMilitar() {
        return this;
    }

//    @Override
//    public IEstado DescobrirEConstruir() {
//        return this;
//    }

//    public boolean ConstroiForcaMilitar() {
//        if (getGameInfo().getMetal() >= 1 && getGameInfo().getWealth() >= 1) {
//            getGameInfo().setMetal(getGameInfo().getMetal() - 1);
//            getGameInfo().setWealth(getGameInfo().getWealth() - 1);
//            getGameInfo().setMilitaryStrength(getGameInfo().getMilitaryStrength() + 1);
//            return false;
//        } else {
//            return true;
//        }
//    }

    //-----------ESTADO[3.2]---------//
    @Override
    public IEstado DescobrirTecnologia(String tech) {
        return this;
    }
//-----------ESTADO[4]---------//

    public void VerificaFimAno() {

    }

    public void RetirarEvento() {

    }

//-----------OUTROS---------//
    @Override
    public IEstado Passar() {
        return this;
    }
//
//    public void ContarPontos() {
//
//    }

    @Override
    public IEstado Sair() {
        return new Fim(GameInfo);
    }

    @Override
    public IEstado VerificaFim() {
        return this;
    }

    @Override
    public IEstado ConquistaUnaligned(int index) {
        return this;
    }

    @Override
    public IEstado Fase_4() {
        return this;
    }

}

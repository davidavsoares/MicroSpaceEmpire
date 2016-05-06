package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 *
 * @author David
 */
public abstract class Estado_0 implements IEstado {

    private Dados GameInfo;

    public Estado_0(Dados GameInfo) {
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

    @Override
    public IEstado DescobrirEConstruir() {
        return this;
    }
//-----------ESTADO[4]---------//

    @Override
    public IEstado VerificaFimAno() {
        return this;
    }

    @Override
    public IEstado RetirarEvento() {
        return this;
    }

//-----------OUTROS---------//
    @Override
    public IEstado Passar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEstado ContarPontos() {
        return this;
    }

    @Override
    public IEstado Sair() {
        return new Fim(GameInfo);
    }

    @Override
    public IEstado GuardarJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
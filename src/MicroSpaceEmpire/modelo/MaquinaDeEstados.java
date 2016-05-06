package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.logica.IEstado;
import MicroSpaceEmpire.modelo.logica.MenuInicial;

/**
 *
 * @author David
 */
public class MaquinaDeEstados {

    private IEstado estado;

    private Dados GameInfo;

    public Dados getGameInfo() {
        return GameInfo;
    }

    public void setGameInfo(Dados GameInfo) {
        this.GameInfo = GameInfo;
    }

    @Override
    public String toString() {
        return GameInfo.toString();
    }

    public MaquinaDeEstados() {
        GameInfo = new Dados();
        estado = new MenuInicial(GameInfo);
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }

    public IEstado CarregarJogo() {
        return estado.CarregarJogo();
    }

    public void NovoJogo() {
        setEstado(estado.NovoJogo());
    }

    public void ConquistarSistema() {
        setEstado(estado.ConquistarSistema());
    }

    public void ExplorarNearSystem() {
        setEstado(estado.ExplorarNearSystem());
    }

    public void ExplorarDistantSystem() {
        setEstado(estado.ExplorarDistantSystem());
    }

    public void Passar() {
        setEstado(estado.Passar());
    }

    public void RecolherMR() {
        setEstado(estado.DecMetalIncRiqueza());
    }

    public void DescobrirTecnologia() {
        setEstado(estado.DescobrirTecnologia());
    }

    public void DescobrirTecnologia(String tech) {
        setEstado(estado.DescobrirTecnologia(tech));
    }

    public void ConstruirForcaMilitar() {
        setEstado(estado.ConstruirForcaMilitar());
    }

    public void DescobrirEConstruir() {
        setEstado(estado.DescobrirEConstruir());
    }

    public IEstado VerificaFimAno() {
        return estado.VerificaFimAno();
    }

    public IEstado RetirarEvento() {
        return estado.RetirarEvento();
    }

    public IEstado ContarPontos() {
        return estado.ContarPontos();
    }

    public void Sair() {
        setEstado(getEstado().Sair());
    }

    public IEstado GuardarJogo() {
        return estado.GuardarJogo();
    }

    public void DecMetalIncRiqueza() {
        setEstado(estado.DecMetalIncRiqueza());
    }

    public void DecRiquezaIncMetal() {
        setEstado(estado.DecRiquezaIncMetal());
    }
}

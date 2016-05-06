package MicroSpaceEmpire.modelo.logica;

/**
 *
 * @author David
 */
public interface IEstado {

//-----------INICIAR---------//
    IEstado CarregarJogo();

    IEstado NovoJogo();
//-----------ESTADO[1]---------//

    IEstado ConquistarSistema();

    IEstado ExplorarNearSystem();

    IEstado ExplorarDistantSystem();

    IEstado Passar();
//-----------ESTADO[2]---------//

    IEstado DecMetalIncRiqueza();
    
    IEstado DecRiquezaIncMetal();
//-----------ESTADO[3]---------//

    IEstado DescobrirTecnologia();

    IEstado ConstruirForcaMilitar();

    IEstado DescobrirEConstruir();
//-----------ESTADO[4]---------//

    IEstado VerificaFimAno();

    IEstado RetirarEvento();

    IEstado ContarPontos();
    
    
    
    
//-----------OUTROS---------//
    IEstado Sair();
    
    IEstado GuardarJogo();

}

package MicroSpaceEmpire.modelo.logica;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
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

    IEstado ConquistaUnaligned(int index);
//-----------ESTADO[2]---------//

    IEstado DecMetalIncRiqueza();

    IEstado DecRiquezaIncMetal();
//-----------ESTADO[3]---------//

    IEstado DescobrirTecnologia();

    IEstado ConstruirForcaMilitar();

    IEstado DescobrirEConstruir();

//-----------ESTADO[3.2]---------//
    IEstado DescobrirTecnologia(String tech);
//-----------ESTADO[4]---------//

    IEstado VerificaFim();
//-----------OUTROS---------//

    IEstado Sair();

    IEstado GuardarJogo();

}

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

    IEstado ConquistaUnaligned(int index);

    IEstado VoltarMenuAnterior();
//-----------ESTADO[2]---------//

    IEstado DecMetalIncRiqueza();

    IEstado DecRiquezaIncMetal();
//-----------ESTADO[3]---------//

    IEstado DescobrirTecnologia();

    IEstado ConstruirForcaMilitar();

//    IEstado DescobrirEConstruir();

    IEstado Fase_4();

//-----------ESTADO[3.2]---------//
    IEstado DescobrirTecnologia(String tech);
//-----------ESTADO[4]---------//

    IEstado VerificaFim();
//-----------OUTROS---------//

    IEstado Passar();

    IEstado Sair();

}

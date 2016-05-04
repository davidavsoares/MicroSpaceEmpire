package MicroSpaceEmpire.modelo.estados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public interface IEstado {

    IEstado iniciar();

    IEstado terminar();

    IEstado Estado_1();

    IEstado Estado_2();

    IEstado Estado_3();

    IEstado Estado_4();

    IEstado apostar(int nBolas);

    // opcoes como resultado de ter saido bola preta do saco
    IEstado removerBolaBrancaDePontuacao();

    IEstado retirarDuasBolasDoSaco();

}

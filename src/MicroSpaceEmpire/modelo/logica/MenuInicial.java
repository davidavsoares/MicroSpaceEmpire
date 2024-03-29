package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class MenuInicial extends Estado_Base {

    public MenuInicial(Dados GameInfo) {
        super(GameInfo);

    }

    @Override
    public IEstado CarregarJogo() {
        return this;
    }

    @Override
    public IEstado NovoJogo() {         // chamar construtor no novo jogo
        //getGameInfo().PreparaJogo();
        return new Estado_1(getGameInfo());
    }

    @Override
    public IEstado Sair() {
       return new Fim(getGameInfo());
    }
    
    

}

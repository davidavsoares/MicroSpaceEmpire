package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_3 extends Estado_Base {

    public boolean Repeticao = true;

    public Estado_3(Dados GameInfo) {
        super(GameInfo);
        GameInfo.setDiplomacy(false);
    }

    Estado_3(Dados gameInfo, boolean Repeticao) {
        super(gameInfo);
        this.Repeticao = Repeticao;
    }

//    public boolean isRepeticao() {
//        return Repeticao;
//    }
    @Override
    public IEstado DescobrirTecnologia() {
        return new Estado_32(getGameInfo(), Repeticao);
    }

    @Override
    public IEstado ConstruirForcaMilitar() {
        if (Repeticao) {
            Repeticao = ConstroiForcaMilitar();
            return this;
        }
        return this;
    }

    @Override
    public IEstado Passar() {
        return Fase_4();
    }

    @Override
    public IEstado Fase_4() {
        getGameInfo().getEventDeck().get(0).TrocaEvento();
        if (getGameInfo().getEmpire().isEmpty()) {
            return new MenuInicial(new Dados());
        } else if (getGameInfo().getANO() == 1 && getGameInfo().isEmptyEventDeck()) {
            getGameInfo().setANO(2);
            getGameInfo().ReiniciarEventos();
            RetirarEvento();
            return new Estado_1(getGameInfo());
        } else if (getGameInfo().getANO() == 2 && getGameInfo().isEmptyEventDeck()) {
            return new MenuInicial(new Dados());
        }
        RetirarEvento();
        return new Estado_1(getGameInfo());
    }

    public boolean ConstroiForcaMilitar() {
        if (getGameInfo().getMetalStorage() >= 1 && getGameInfo().getWealthStorage() >= 1) {
            getGameInfo().setMetalStorage(getGameInfo().getMetalStorage() - 1);
            getGameInfo().setWealthStorage(getGameInfo().getWealthStorage() - 1);
            getGameInfo().setMilitaryStrength(getGameInfo().getMilitaryStrength() + 1);
            return false;
        } else {
            return true;
        }
    }
}

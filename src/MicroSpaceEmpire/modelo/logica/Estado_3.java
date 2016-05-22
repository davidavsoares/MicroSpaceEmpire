package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_3 extends Estado_0 {

    public boolean Repeticao = true;

    public Estado_3(Dados GameInfo) {
        super(GameInfo);
        GameInfo.setDiplomacy(false);
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
        return new Estado_4(getGameInfo());
    }

    @Override
    public IEstado Fase_4() {
        getGameInfo().getEventDeck().get(0).TrocaEvento();
                if (getGameInfo().getEmpire().isEmpty()) {
            return new Fim(getGameInfo());
        } else if (getGameInfo().getANO() == 1 && getGameInfo().isEmptyEventDeck()) {
            getGameInfo().setANO(2);
            getGameInfo().ReiniciarEventos();
            RetirarEvento();
            return new Estado_1(getGameInfo());
        } else if (getGameInfo().getANO() == 2 && getGameInfo().isEmptyEventDeck()) {
            return new Fim(getGameInfo());
        }
        RetirarEvento();
        return new Estado_1(getGameInfo());
    }

}

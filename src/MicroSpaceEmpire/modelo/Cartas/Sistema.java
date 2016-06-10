package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class Sistema extends Carta {

    private int DADO;

    public Sistema(Dados GameInfo) {
        super(GameInfo);

    }
// -------------------------- ETAPA 1 --------------------------------------- //

    public void AtacarSistema() {
        if (getGameInfo().getDiplomacy()) {
            getGameInfo().removeSystem(this);
            IntegrarImperio();
        } else if (!ConquistarSistema()) {
            ExplorarSistema();
        }
    }

    public boolean ConquistarSistema() {        //Funcao que tenta conquistar um sistema
        if (getGameInfo().getMilitaryStrength() + (DADO = (getGameInfo().Dice())) >= this.getResistance()) {
//  VER VALIDACOES DE SISTEMA ESTAR VAZIO!!!            if (getGameInfo().isEmptyUnalignedSystems()) {
            getGameInfo().removeSystem(this);
            this.IntegrarImperio();
            getGameInfo().setDADO(DADO);
            return true;
//            }
        }
        getGameInfo().setDADO(DADO);
        return false;
    }

    public void ExplorarSistema() {        //Funcao explora um sistema em caso de nao conseguir conquistar
        getGameInfo().removeSystem(this);
        this.IntegrarUnaligned();
        getGameInfo().setMilitaryStrength(getGameInfo().getMilitaryStrength() - 1);
    }
// -------------------------- IMPERIO --------------------------------------- //

    public void IntegrarImperio() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getEmpire().add(this);
        getGameInfo().setMetalProduction(getGameInfo().getMetalProduction());
        getGameInfo().setWealthProduction(getGameInfo().getWealthProduction());
    }

    public Sistema DesintegrarImperio() {
        if (getGameInfo().getEmpire().remove(this));
        {
            return this;
        }
    }

    public void SaiImperioEntraUnaligned() {
        getGameInfo().getUnalignedSystems().add(DesintegrarImperio());
    }

    public void SaiUnalignedEntraImperio() {
        getGameInfo().getUnalignedSystems().remove(this);
        IntegrarImperio();
    }

//------------------SISTEMAS DESALINHADOS-------------------------------------//
    public void IntegrarUnaligned() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getUnalignedSystems().add(this);
    }

    public Sistema DesintegrarUnaligned() {                      //Função que remove um sistem do array de desalinhados e o devolve
        if (getGameInfo().getUnalignedSystems().remove(this));
        {
            return this;
        }
    }

    public abstract int getMetalProduction();

    public abstract int getWealthProduction();

    public abstract int getVictoryPoints();

    public abstract int getResistance();
}

package MicroSpaceEmpire.modelo.Cartas;

import MicroSpaceEmpire.modelo.Dados;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class System extends Carta {

    private int DADO;

    public System(Dados GameInfo) {
        super(GameInfo);

    }

    public int getDADO() {
        return DADO;
    }

    public abstract int getMetalProduction();

    public abstract int getWealthProduction();

    public abstract int getVictoryPoints();

    public abstract int getResistance();

    public abstract void setResistance(int Resistance);

    public void IntegrarImperio() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getEmpire().add(this);
        getGameInfo().setMetalProduction(getGameInfo().getMetalProduction() + this.getMetalProduction());
        getGameInfo().setWealthProduction(getGameInfo().getWealthProduction() + this.getWealthProduction());
    }

    public void IntegrarUnaligned() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getUnalignedSystems().add(this);
    }

    public void DesintegrarImperio() {
        getGameInfo().DesintegrarImperio(this).IntegrarUnaligned();

    }

    public boolean ConquistaSistema() {        //Funcao que remove um sistema do deck e adiciona ao Imperio
        if (getGameInfo().getMilitaryStrength() + (DADO = (getGameInfo().Dice())) >= this.getResistance()) {
//            if (getGameInfo().isEmptyUnalignedSystems()) {
                getGameInfo().removeSystem(this);
                this.IntegrarImperio();
                getGameInfo().setDADO(DADO);
                return true;
//            }
        }
        getGameInfo().setDADO(DADO);
        return false;
    }

    public void ExploraSistema() {        //Funcao que remove um sistema do deck e adiciona ao Imperio
        getGameInfo().removeSystem(this);
        this.IntegrarUnaligned();
        getGameInfo().setMilitaryStrength(getGameInfo().getMilitaryStrength() - 1);
    }

    public void Batalha() {
        if (!ConquistaSistema()) {
            ExploraSistema();
        }

    }

}

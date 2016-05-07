package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Estado_0 implements IEstado, java.io.Serializable {

    private static final long serialVersionUID = 42L;
    private Dados GameInfo;

    public Estado_0(Dados GameInfo) {
        this.GameInfo = GameInfo;
    }

    public Dados getGameInfo() {
        return GameInfo;
    }

//-----------INICIAR---------//
    @Override
    public IEstado CarregarJogo() {
        return this;
    }

    @Override
    public IEstado NovoJogo() {
        return this;
    }
//-----------ESTADO[1]---------//

    @Override
    public IEstado ConquistarSistema() {
        return this;
    }

    @Override
    public IEstado ExplorarNearSystem() {
        return this;
    }

    @Override
    public IEstado ExplorarDistantSystem() {
        return this;
    }
//-----------ESTADO[2]---------//

    @Override
    public IEstado DecRiquezaIncMetal() {
        return this;
    }

    @Override
    public IEstado DecMetalIncRiqueza() {
        return this;
    }
//-----------ESTADO[3]---------//

    @Override
    public IEstado DescobrirTecnologia() {
        return this;
    }

    @Override
    public IEstado ConstruirForcaMilitar() {
        return this;
    }

    @Override
    public IEstado DescobrirEConstruir() {
        return this;
    }

    public boolean ConstroiForcaMilitar() {
        if (getGameInfo().getMetal() >= 1 || getGameInfo().getWealth() >= 1) {
            getGameInfo().setMetal(getGameInfo().getMetal() - 1);
            getGameInfo().setWealth(getGameInfo().getWealth() - 1);
            getGameInfo().setMilitaryStrength(getGameInfo().getMilitaryStrength() + 1);
            return false;
        } else {
            return true;
        }
    }

    //-----------ESTADO[3.2]---------//
    @Override
    public IEstado DescobrirTecnologia(String tech) {
        return this;
    }
//-----------ESTADO[4]---------//

    @Override
    public IEstado VerificaFimAno() {
        return this;
    }

    @Override
    public IEstado RetirarEvento() {
        return this;
    }

//-----------OUTROS---------//
    @Override
    public IEstado Passar() {
        return this;
    }

    @Override
    public IEstado ContarPontos() {
        return this;
    }

    @Override
    public IEstado Sair() {
        return new Fim(GameInfo);
    }

    @Override
    public IEstado GuardarJogo() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GameInfo);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();

        }
        return this;
    }

}

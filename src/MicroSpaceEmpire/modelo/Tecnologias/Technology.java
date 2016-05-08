package MicroSpaceEmpire.modelo.Tecnologias;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.ForwardStarbases;
import java.util.Objects;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Technology implements java.io.Serializable {

    private static final long serialVersionUID = 42L;
    private Dados GameInfo;
    private int Custo;

    public int getCusto() {
        return Custo;
    }

    public Technology(Dados GameInfo) {
        this.GameInfo = GameInfo;
    }

    public Technology(Dados GameInfo, int Custo) {
        this.GameInfo = GameInfo;
        this.Custo = Custo;
    }

    public void IntegrarDescobertas() //Função polimorfica para fazer um planeta integrar o imperio
    {
        getGameInfo().getTechnologyDiscovered().add(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.GameInfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Technology other = (Technology) obj;
        if (!Objects.equals(this.GameInfo, other.GameInfo)) {
            return false;
        }
        return true;
    }

    public boolean IntegrarTechnologyDiscovered() {
        if (GameInfo.getWealth() >= Custo) {
            GameInfo.setWealth(GameInfo.getWealth() - Custo);
            IntegrarDescobertas();
            return true;
        }
        return false;
    }

    public void IntegrarTechnologies() {
        GameInfo.getTechnologies().add(this);
    }

    public Dados getGameInfo() {
        return GameInfo;
    }

    public boolean CompraTecnologia() {
        return false;
    }

}

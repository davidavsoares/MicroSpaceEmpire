package MicroSpaceEmpire.modelo.Tecnologias;

import MicroSpaceEmpire.modelo.Dados;
import java.util.Objects;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public abstract class Technology_SuperClasse implements java.io.Serializable {

    private static final long serialVersionUID = 42L;
    private Dados GameInfo;
    private int Custo;

    public int getCusto() {
        return Custo;
    }

    public Technology_SuperClasse(Dados GameInfo) {
        this.GameInfo = GameInfo;
    }

    public Technology_SuperClasse(Dados GameInfo, int Custo) {
        this.GameInfo = GameInfo;
        this.Custo = Custo;
    }

    public void IntegrarDescobertas() //Função polimorfica para fazer um planeta integrar o imperio
    {
        GameInfo.getTechnologyDiscovered().add(this);
        Usa();
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
        final Technology_SuperClasse other = (Technology_SuperClasse) obj;
        if (!Objects.equals(this.GameInfo, other.GameInfo)) {
            return false;
        }
        return true;
    }

    public boolean CompraTecnologia() {
        if (GameInfo.getWealthStorage() >= Custo) {
            GameInfo.setWealthStorage(GameInfo.getWealthStorage() - Custo);
            DesintegrarTechnologies();
            IntegrarDescobertas();
            return true;
        }
        return false;
    }

    public void IntegrarTechnologies() {
        GameInfo.getTechnologies().add(this);
    }

    public Technology_SuperClasse DesintegrarTechnologies() {
        GameInfo.getTechnologies().remove(this);
        return this;
    }

    public Dados getGameInfo() {
        return GameInfo;
    }
    
    public abstract void Usa();


}

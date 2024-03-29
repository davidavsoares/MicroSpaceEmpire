package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class InterstellarDiplomacy extends Technology_SuperClasse {
    
    public InterstellarDiplomacy(Dados GameInfo) {
        super(GameInfo, 5);
    }
    
    @Override
    public String toString() {
        return "Interstellar Diplomacy";
    }
    
    @Override
    public void Usa() {
        getGameInfo().setDiplomacy(true);
    }
    
}

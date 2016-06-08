package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class ForwardStarbases extends Technology_SuperClasse {

    public ForwardStarbases(Dados GameInfo) {
        super(GameInfo, 4);
    }

    @Override
    public String toString() {
        return "Forward Starbases";
    }

    @Override
    public void Usa() {
 }

}

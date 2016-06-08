package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class InterspeciesCommerce extends Technology_SuperClasse {

    public InterspeciesCommerce(Dados GameInfo) {
        super(GameInfo, 2);
    }

    @Override
    public String toString() {
        return "Interspecies Commerce";
    }

    @Override
    public void Usa() {
}

}

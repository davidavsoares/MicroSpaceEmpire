package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class PlanetaryDefenses extends Technology_SuperClasse {

    public PlanetaryDefenses(Dados GameInfo) {
        super(GameInfo, 4);

    }

    @Override
    public String toString() {
        return "Planetary Defenses";
    }

    @Override
    public void Usa() {
    }
}

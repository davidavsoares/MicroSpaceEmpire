package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class RobotWorkers extends Technology {

    public RobotWorkers(Dados GameInfo) {
        super(GameInfo, 2);

    }

    @Override
    public String toString() {
        return "Robot Workers";
    }
}

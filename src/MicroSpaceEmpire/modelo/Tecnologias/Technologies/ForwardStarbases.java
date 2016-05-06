package MicroSpaceEmpire.modelo.Tecnologias.Technologies;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technology;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class ForwardStarbases extends Technology {

    public ForwardStarbases(Dados GameInfo) {
        super(GameInfo);
    }

    public void CompraTecnologia() {
        if (getGameInfo().getTechnologyDiscovered().contains(new CapitalShips(getGameInfo()))) {
            IntegrarTechnologyDiscovered();
            getGameInfo().removeTechnology(this); //exception para caso de ja ter sido comprado
        } else {
            //exception
        }
    }

    @Override
    public String toString() {
        return "Forward Starbases";
    }

//    @Override
//    public boolean equals(Object obj) {
//        boolean sameSame = false;
//
//        if (obj != null && obj instanceof ForwardStarbases) {
//            sameSame = this.toString().equals(((ForwardStarbases) obj).toString());
//        }
//        return sameSame;
//    }
}

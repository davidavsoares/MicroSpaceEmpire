package MicroSpaceEmpire.modelo.Cartas.Events;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.PlanetaryDefenses;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class SmallInvasionForce extends Event{
    
    public SmallInvasionForce(Dados GameInfo) 
    {
        super(GameInfo);
    }

    @Override
    public String toString() {
        return "Small Invasion Force";
    }
    public void CorreEvento() {
        int Forca;
        if (getGameInfo().getANO() == 1) {
            Forca = 1 + getGameInfo().Dice();
        } else {
            Forca = 2 + getGameInfo().Dice();
        }
        if (Forca >= (getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).getResistance() + 1)&& 
                getGameInfo().getTechnologyDiscovered().contains(new PlanetaryDefenses(getGameInfo()))) {
            
            getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).DesintegrarImperio();
        }
        else if(Forca >= getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).getResistance())
        {
            getGameInfo().getEmpire().get(getGameInfo().getEmpire().size() - 1).DesintegrarImperio();
        }
    }
}

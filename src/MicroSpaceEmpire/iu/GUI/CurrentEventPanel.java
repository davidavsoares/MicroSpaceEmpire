package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CurrentEventPanel extends JPanel implements Constants {

    private ObservableGame observableGame;
//    private BlackAndWhitePanel blackAndWhitePanel;

    public CurrentEventPanel(ObservableGame observableGame) {

        this.observableGame = observableGame;

        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Event CurrentEvent = observableGame.getCurrentEvent();

        if (CurrentEvent instanceof Asteroid) {
            g.drawImage(MicroSpaceEmpirePanel.getAsteroidImage(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof DerelictShip) {
            g.drawImage(MicroSpaceEmpirePanel.getDerelictShipImage(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof LargeInvasionForce) {
            g.drawImage(MicroSpaceEmpirePanel.getLargeInvasionForceImage(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof PeaceQuiet) {
            g.drawImage(MicroSpaceEmpirePanel.getPeaceQuietImage(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof Revolt) {
            g.drawImage(MicroSpaceEmpirePanel.getRevoltImage(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof Revolt2) {
            g.drawImage(MicroSpaceEmpirePanel.getRevolt2Image(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof SmallInvasionForce) {
            g.drawImage(MicroSpaceEmpirePanel.getSmallInvasionForceImage(), 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof Strike) {
            g.drawImage(MicroSpaceEmpirePanel.getStrikeImage(), 0, 0, CARD_X, CARD_Y, this);

        }
    }

}

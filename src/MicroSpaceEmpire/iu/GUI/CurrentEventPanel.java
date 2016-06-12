package MicroSpaceEmpire.iu.GUI;

import static MicroSpaceEmpire.iu.GUI.Constants.CARD_X;
import static MicroSpaceEmpire.iu.GUI.Constants.CARD_Y;
import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CurrentEventPanel extends JPanel implements Constants {

    private ObservableGame ob;

    static private Image//EVENTOS
            AsteroidImage = null, DerelictShipImage = null, LargeInvasionForceImage = null,
            PeaceQuietImage = null, RevoltImage = null, Revolt2Image = null, SmallInvasionForceImage = null,
            StrikeImage = null;

    public CurrentEventPanel(ObservableGame ob) {

        this.ob = ob;

        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Event CurrentEvent = ob.getCurrentEvent();

        if (CurrentEvent instanceof Asteroid) {
            g.drawImage(AsteroidImage, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof DerelictShip) {
            g.drawImage(DerelictShipImage, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof LargeInvasionForce) {
            g.drawImage(LargeInvasionForceImage, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof PeaceQuiet) {
            g.drawImage(PeaceQuietImage, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof Revolt) {
            g.drawImage(RevoltImage, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof Revolt2) {
            g.drawImage(Revolt2Image, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof SmallInvasionForce) {
            g.drawImage(SmallInvasionForceImage, 0, 0, CARD_X, CARD_Y, this);
        } else if (CurrentEvent instanceof Strike) {
            g.drawImage(StrikeImage, 0, 0, CARD_X, CARD_Y, this);

        }
    }

    static {
        try {
            //CARREGA IMAGENS DE EVENTOS
            AsteroidImage = ImageIO.read(Resources.getResourceFile("images/Event/Asteroid.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            DerelictShipImage = ImageIO.read(Resources.getResourceFile("images/Event/DerelictShip.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            LargeInvasionForceImage = ImageIO.read(Resources.getResourceFile("images/Event/LargeInvasionForce.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            PeaceQuietImage = ImageIO.read(Resources.getResourceFile("images/Event/PeaceQuiet.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            RevoltImage = ImageIO.read(Resources.getResourceFile("images/Event/Revolt.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            Revolt2Image = ImageIO.read(Resources.getResourceFile("images/Event/Revolt2.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            SmallInvasionForceImage = ImageIO.read(Resources.getResourceFile("images/Event/SmallInvasionForce.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            StrikeImage = ImageIO.read(Resources.getResourceFile("images/Event/Strike.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }
}

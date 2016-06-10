package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Events.*;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CurrentEventPanel extends JPanel implements Constants {

    private ObservableGame ob;

    static private BufferedImage//EVENTOS
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
            AsteroidImage = ImageIO.read(Resources.getResourceFile("images/Event/Asteroid.jpg"));
            DerelictShipImage = ImageIO.read(Resources.getResourceFile("images/Event/DerelictShip.jpg"));
            LargeInvasionForceImage = ImageIO.read(Resources.getResourceFile("images/Event/LargeInvasionForce.jpg"));
            PeaceQuietImage = ImageIO.read(Resources.getResourceFile("images/Event/PeaceQuiet.jpg"));
            RevoltImage = ImageIO.read(Resources.getResourceFile("images/Event/Revolt.jpg"));
            Revolt2Image = ImageIO.read(Resources.getResourceFile("images/Event/Revolt2.jpg"));
            SmallInvasionForceImage = ImageIO.read(Resources.getResourceFile("images/Event/SmallInvasionForce.jpg"));
            StrikeImage = ImageIO.read(Resources.getResourceFile("images/Event/Strike.jpg"));
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }
}

package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.Cartas.Carta;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.HomeWorld;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class UnalignedSystemPanel extends JPanel implements Constants {

    private ObservableGame observableGame;
//    private BlackAndWhitePanel blackAndWhitePanel;

    public UnalignedSystemPanel(ObservableGame observableGame) {

        this.observableGame = observableGame;

        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Sistema> UnalignedSystems = observableGame.getUnalignedSystems();

        int x = 0, y = 0;
        for (Carta sistema : UnalignedSystems) {

            if (x + CARD_X + BETWEEN_PANELS_X > getWidth()) {
                x = 0;
                y += CARD_Y + BETWEEN_PANELS_Y;
            }
            
            if (sistema instanceof HomeWorld) {
                g.drawImage(MicroSpaceEmpirePanel.getHomeWorldImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Cygnus) {
                g.drawImage(MicroSpaceEmpirePanel.getCygnusImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof EpsilonEridani) {
                g.drawImage(MicroSpaceEmpirePanel.getEpsilonEridaniImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Procyon) {
                g.drawImage(MicroSpaceEmpirePanel.getProcyonImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Proxima) {
                g.drawImage(MicroSpaceEmpirePanel.getProximaImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Sirius) {
                g.drawImage(MicroSpaceEmpirePanel.getSiriusImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof TauCeti) {
                g.drawImage(MicroSpaceEmpirePanel.getTauCetiImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Wolf359) {
                g.drawImage(MicroSpaceEmpirePanel.getWolf359Image(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Canopus) {
                g.drawImage(MicroSpaceEmpirePanel.getCanopusImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof GalaxysEdge) {
                g.drawImage(MicroSpaceEmpirePanel.getGalaxysEdgeImage(), x, y, CARD_X, CARD_Y, this);
            } else if (sistema instanceof Polaris) {
                g.drawImage(MicroSpaceEmpirePanel.getPolarisImage(), x, y, CARD_X, CARD_Y, this);
            }

            x += CARD_X + BETWEEN_PANELS_X;

        }
    }

}

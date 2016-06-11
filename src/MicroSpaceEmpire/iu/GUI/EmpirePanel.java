package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.Cartas.Carta;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.HomeWorld;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EmpirePanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JPanel coluna1, coluna2, coluna3, coluna4;

    private JPanel HW;
    private JPanel NSC;
    private JPanel NSEE;
    private JPanel NSP;
    private JPanel NSPr;
    private JPanel NSS;
    private JPanel NSTC;
    private JPanel NSW;

    private JPanel DSC;
    private JPanel DSG;
    private JPanel DSP;

    public EmpirePanel(ObservableGame ob) {

        this.ob = ob;
        ob.addObserver(this);

        setOpaque(false);
        //setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X*4, CARD_Y*4));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

        setLayout(new GridLayout(0, 4));

        coluna1 = new JPanel(new BoxLayout(coluna1, BoxLayout.Y_AXIS));
        coluna2 = new JPanel(new BoxLayout(coluna2, BoxLayout.Y_AXIS));
        coluna3 = new JPanel(new BoxLayout(coluna3, BoxLayout.Y_AXIS));
        coluna4 = new JPanel(new BoxLayout(coluna4, BoxLayout.Y_AXIS));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Sistema> Empire = ob.getEmpire();

        int x = 0, y = 0;

        for (Carta sistema : Empire) {

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

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}

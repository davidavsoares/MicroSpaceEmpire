package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class EventDiscardPanel extends JPanel implements Constants {

    private ObservableGame ob;
//    private BlackAndWhitePanel blackAndWhitePanel;

    public EventDiscardPanel(ObservableGame observableGame) {

        this.ob = observableGame;

        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MicroSpaceEmpirePanel.getEventBackImage(), 0, 0, CARD_X, CARD_Y, this);

    }
}

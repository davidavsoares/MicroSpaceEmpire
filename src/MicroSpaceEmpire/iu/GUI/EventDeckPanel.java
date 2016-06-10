package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class EventDeckPanel extends JPanel implements Constants {

    private ObservableGame ob;

    public EventDeckPanel(ObservableGame ob) {

        this.ob = ob;

        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!ob.getEventDeck().isEmpty()) {
            g.drawImage(MicroSpaceEmpirePanel.getEventBackImage(), 0, 0, CARD_X, CARD_Y, this);
        }
    }

}

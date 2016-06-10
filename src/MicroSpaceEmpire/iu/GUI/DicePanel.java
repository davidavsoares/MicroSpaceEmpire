package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class DicePanel extends JPanel implements Constants {

    private ObservableGame ob;
//    private BlackAndWhitePanel blackAndWhitePanel;

    public DicePanel(ObservableGame ob) {

        this.ob = ob;

        setOpaque(false);

        setMaximumSize(new Dimension(DICE_X, DICE_Y));
        setPreferredSize(new Dimension(DICE_X, DICE_Y));
        setMinimumSize(new Dimension(DICE_X, DICE_Y));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int index = ob.getDice() - 1;
        
        g.drawImage(MicroSpaceEmpirePanel.getDice(index), 0, 0, DICE_X, DICE_Y, this);
    }
}

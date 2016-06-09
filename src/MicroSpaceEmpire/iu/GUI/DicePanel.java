package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

        int Dice = ob.getDice();

        if (Dice == 1) {
            g.drawImage(MicroSpaceEmpirePanel.getDice1Image(), 0, 0, DICE_X, DICE_Y, this);
        } else if (Dice == 2) {
            g.drawImage(MicroSpaceEmpirePanel.getDice2Image(), 0, 0, DICE_X, DICE_Y, this);
        } else if (Dice == 3) {
            g.drawImage(MicroSpaceEmpirePanel.getDice3Image(), 0, 0, DICE_X, DICE_Y, this);
        } else if (Dice == 4) {
            g.drawImage(MicroSpaceEmpirePanel.getDice4Image(), 0, 0, DICE_X, DICE_Y, this);
        } else if (Dice == 5) {
            g.drawImage(MicroSpaceEmpirePanel.getDice5Image(), 0, 0, DICE_X, DICE_Y, this);
        } else if (Dice == 6) {
            g.drawImage(MicroSpaceEmpirePanel.getDice6Image(), 0, 0, DICE_X, DICE_Y, this);
        }

    }
}

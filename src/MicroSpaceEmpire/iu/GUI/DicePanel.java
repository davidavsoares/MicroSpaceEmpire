package MicroSpaceEmpire.iu.GUI;

import static MicroSpaceEmpire.iu.GUI.Constants.RESOURCES_X;
import static MicroSpaceEmpire.iu.GUI.Constants.RESOURCES_Y;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JLabel DiceImgL;

    public DicePanel(ObservableGame ob) {

        this.ob = ob;
        this.ob.addObserver(this);
        this.setLayout(new BorderLayout());
        
        int index = ob.getDice();
        setOpaque(false);

        setMaximumSize(new Dimension(DICE_X, DICE_Y));
        setPreferredSize(new Dimension(DICE_X, DICE_Y));
        setMinimumSize(new Dimension(DICE_X, DICE_Y));

        ImageIcon DiceImg;
        Image img = MicroSpaceEmpirePanel.getDice(0);
        DiceImg = new ImageIcon(img.getScaledInstance(DICE_X, DICE_Y, java.awt.Image.SCALE_SMOOTH));
        DiceImgL = new JLabel(DiceImg);
        DiceImgL.setPreferredSize(new Dimension(RESOURCES_X, RESOURCES_Y));

        this.add(DiceImgL, BorderLayout.CENTER);
        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        int index = ob.getDice();
        ImageIcon DiceImg;
        Image img = MicroSpaceEmpirePanel.getDice(index);
        DiceImg = new ImageIcon(img.getScaledInstance(DICE_X, DICE_Y, java.awt.Image.SCALE_SMOOTH));
        DiceImgL.setIcon(DiceImg);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

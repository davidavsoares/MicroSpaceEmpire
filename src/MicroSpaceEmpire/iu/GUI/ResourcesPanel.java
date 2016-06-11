package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kalin
 */
public class ResourcesPanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JPanel WProductionP;
    private JPanel MProductionP;
    private JPanel MStrengthP;
    private JPanel WStorageP;
    private JPanel MStorageP;
    private JLabel WPImgL;
    private JLabel MPImgL;
    private JLabel MSImgL;
    private JLabel WSImgL;
    private JLabel MStImgL;

    public ResourcesPanel(ObservableGame ob) {
        this.ob = ob;
        this.ob.addObserver(this);
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel WProductionL = new JLabel(" Wealth Production");
        WProductionL.setForeground(Color.WHITE);
        JLabel MProductionL = new JLabel("  Metal Production");
        MProductionL.setForeground(Color.WHITE);
        JLabel MStrengthL = new JLabel("  Military Strength");
        MStrengthL.setForeground(Color.WHITE);
        JLabel WStorageL = new JLabel("  Wealth Storage");
        WStorageL.setForeground(Color.WHITE);
        JLabel MStorageL = new JLabel("   Metal Storage");
        MStorageL.setForeground(Color.WHITE);

        JPanel WProductionP = new JPanel(new BorderLayout());
        JPanel MProductionP = new JPanel(new BorderLayout());
        JPanel MStrengthP = new JPanel(new BorderLayout());
        JPanel WStorageP = new JPanel(new BorderLayout());
        JPanel MStorageP = new JPanel(new BorderLayout());

        ImageIcon WPImg;
        Image img = MicroSpaceEmpirePanel.getWealthProduction(ob.getWealthProduction());
        WPImg = new ImageIcon(img.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        WPImgL = new JLabel(WPImg);
        WPImgL.setPreferredSize(new Dimension(RESOURCES_X, RESOURCES_Y));
        //WPImgL.setMaximumSize(new Dimension(RESOURCES_X, RESOURCES_Y));

        ImageIcon MPImg;
        Image img2 = MicroSpaceEmpirePanel.getMetalProduction(ob.getMetalProduction());
        MPImg = new ImageIcon(img2.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        MPImgL = new JLabel(MPImg);
        MPImgL.setPreferredSize(new Dimension(RESOURCES_X, RESOURCES_Y));

        ImageIcon MSImg;
        Image img3 = MicroSpaceEmpirePanel.getMilitaryStrength(ob.getMilitaryStrength());
        MSImg = new ImageIcon(img3.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        MSImgL = new JLabel(MSImg);
        MSImgL.setPreferredSize(new Dimension(RESOURCES_X, RESOURCES_Y));

        ImageIcon WSImg;
        Image img4 = MicroSpaceEmpirePanel.getWealthStorage(ob.getWealthStorage());
        WSImg = new ImageIcon(img4.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        WSImgL = new JLabel(WSImg);
        WSImgL.setPreferredSize(new Dimension(RESOURCES_X, RESOURCES_Y));

        ImageIcon MStImg;
        Image img5 = MicroSpaceEmpirePanel.getMetalStorage(ob.getMetalStorage());
        MStImg = new ImageIcon(img5.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        MStImgL = new JLabel(MStImg);
        MStImgL.setPreferredSize(new Dimension(RESOURCES_X, RESOURCES_Y));

//        WPImgL.setAlignmentY(CENTER_ALIGNMENT);
        WProductionL.setAlignmentY(CENTER_ALIGNMENT);
        WProductionP.add(WPImgL, BorderLayout.CENTER);
        WProductionP.add(WProductionL, BorderLayout.NORTH);
        WProductionP.setOpaque(false);

        MProductionL.setAlignmentY(CENTER_ALIGNMENT);
        MProductionP.add(MPImgL, BorderLayout.CENTER);
        MProductionP.add(MProductionL, BorderLayout.NORTH);
        MProductionP.setOpaque(false);

        MStrengthL.setAlignmentY(CENTER_ALIGNMENT);
        MStrengthP.add(MSImgL, BorderLayout.CENTER);
        MStrengthP.add(MStrengthL, BorderLayout.NORTH);
        MStrengthP.setOpaque(false);

        WStorageL.setAlignmentY(CENTER_ALIGNMENT);
        WStorageP.add(WSImgL, BorderLayout.CENTER);
        WStorageP.add(WStorageL, BorderLayout.NORTH);
        WStorageP.setOpaque(false);

        MStorageL.setAlignmentY(CENTER_ALIGNMENT);
        MStorageP.add(MStImgL, BorderLayout.CENTER);
        MStorageP.add(MStorageL, BorderLayout.NORTH);
        MStorageP.setOpaque(false);

        this.add(WProductionP);
        this.add(MProductionP);
        this.add(MStrengthP);
        this.add(WStorageP);
        this.add(MStorageP);
        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {

        ImageIcon WPImg;
        Image img = MicroSpaceEmpirePanel.getWealthProduction(ob.getWealthProduction());
        WPImg = new ImageIcon(img.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        WPImgL.setIcon(WPImg);

        ImageIcon MPImg;
        Image img2 = MicroSpaceEmpirePanel.getMetalProduction(ob.getMetalProduction());
        MPImg = new ImageIcon(img2.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        MPImgL.setIcon(MPImg);

        ImageIcon MSImg;
        Image img3 = MicroSpaceEmpirePanel.getMilitaryStrength(ob.getMilitaryStrength());
        MSImg = new ImageIcon(img3.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        MSImgL.setIcon(MSImg);

        ImageIcon WSImg;
        Image img4 = MicroSpaceEmpirePanel.getWealthStorage(ob.getWealthStorage());
        WSImg = new ImageIcon(img4.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        WSImgL.setIcon(WSImg);

        ImageIcon MStImg;
        Image img5 = MicroSpaceEmpirePanel.getMetalStorage(ob.getMetalStorage());
        MStImg = new ImageIcon(img5.getScaledInstance(RESOURCES_X, RESOURCES_Y, java.awt.Image.SCALE_SMOOTH));
        MStImgL.setIcon(MStImg);

    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

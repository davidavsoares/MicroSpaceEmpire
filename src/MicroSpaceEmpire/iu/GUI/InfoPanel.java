package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author kalin
 */
public class InfoPanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private DicePanel DP;
    private ResourcesPanel RP;
    private TechnologyPanel TP;
    private Menu31Panel M31P;
    private Menu3Panel M3P;
    private Menu2Panel M2P;
    private Menu11Panel M11P;
    private Menu1Panel M1P;
    private MenuInicialPanel MIP;

    public InfoPanel(ObservableGame observableGame) {
        setOpaque(false);
        this.ob = observableGame;
        this.ob.addObserver(this);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension((CARD_X * 2), (CARD_Y * 2)));

        DP = new DicePanel(ob);
        RP = new ResourcesPanel(ob);
        TP = new TechnologyPanel(ob);
        M31P = new Menu31Panel(ob);
        M3P = new Menu3Panel(ob);
        M2P = new Menu2Panel(ob);
        M11P = new Menu11Panel(ob);
        M1P = new Menu1Panel(ob);
        MIP = new MenuInicialPanel(ob);

        JPanel WestPanel = new JPanel(new BorderLayout());
        WestPanel.add(RP, BorderLayout.CENTER);
        WestPanel.add(DP, BorderLayout.SOUTH);
        WestPanel.setAlignmentY(CENTER_ALIGNMENT);
        WestPanel.setOpaque(false);
        
        this.add(WestPanel, BorderLayout.WEST);
        this.add(TP, BorderLayout.CENTER);
        this.add(M31P, BorderLayout.CENTER);
        this.add(M3P, BorderLayout.CENTER);
        this.add(M2P, BorderLayout.CENTER);
        this.add(M11P, BorderLayout.CENTER);
        this.add(M1P, BorderLayout.CENTER);
        this.add(MIP, BorderLayout.CENTER);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kalin
 */
public class InfoPanel extends JPanel implements Constants {

    private ObservableGame ob;
    private DicePanel DP;
    private ResourcesPanel RP;
    
    public InfoPanel(ObservableGame observableGame) {
        setOpaque(false);
        this.ob = observableGame;
        this.setLayout(new BorderLayout());
        
        DP = new DicePanel(ob);
        RP = new ResourcesPanel(ob);
        JPanel WestPanel = new JPanel(new BorderLayout());
        WestPanel.add(RP, BorderLayout.CENTER);
        WestPanel.add(DP, BorderLayout.SOUTH);
        WestPanel.setAlignmentY(CENTER_ALIGNMENT);
        WestPanel.setOpaque(false);
        this.add(WestPanel, BorderLayout.WEST);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

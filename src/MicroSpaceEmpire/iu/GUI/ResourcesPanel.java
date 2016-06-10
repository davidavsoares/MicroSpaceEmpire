/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author kalin
 */
public class ResourcesPanel extends JPanel implements Constants{
    private ObservableGame observableGame;
    
    public ResourcesPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {    
        super.paintComponent(g);
    }
}

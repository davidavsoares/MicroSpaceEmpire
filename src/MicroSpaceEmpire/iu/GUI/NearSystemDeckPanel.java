
package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class NearSystemDeckPanel extends JPanel implements Constants {

    private ObservableGame observableGame;
//    private BlackAndWhitePanel blackAndWhitePanel;

    public NearSystemDeckPanel(ObservableGame observableGame) {
        
        this.observableGame = observableGame;
        
        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {    
        super.paintComponent(g);
        //VALIDACAO VAZIO
        g.drawImage(MicroSpaceEmpirePanel.getSystemBackImage(), 0, 0,CARD_X, CARD_Y, this);

    }

}



package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DistantSystemDeckPanel extends JPanel implements Constants {

    private ObservableGame observableGame;
//    private BlackAndWhitePanel blackAndWhitePanel;

    public DistantSystemDeckPanel(ObservableGame observableGame) {
        
        this.observableGame = observableGame;
        
       setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

    }

    @Override
    public void paintComponent(Graphics g) {    
        super.paintComponent(g);
        g.drawImage(MicroSpaceEmpirePanel.getSystemBackImage(), 0, 0,CARD_X, CARD_Y, this);
        //List<Ball> bag = observableGame.getBag();
               
//        int x = BORDER_X, y = BORDER_Y;
//        
//        for( Ball ball: bag){          
//        
//            if(x + DIM_X_BALL + BORDER_X > getWidth()){
//                x = BORDER_X;
//                y += DIM_Y_BALL + GAP_Y_BALLS; 
//            }
//            
//            if(ball instanceof WhiteBall){
//                 g.drawImage(BlackAndWhitePanel.getWhiteBallImage(), x, y, DIM_X_BALL, DIM_Y_BALL, this);
//            } else if(ball instanceof BlackBall){
//                 g.drawImage(BlackAndWhitePanel.getBlackBallImage(), x, y, DIM_X_BALL, DIM_Y_BALL, this);
//            }
//            
//            x += DIM_X_BALL + GAP_X_BALLS;
//        
//        }
    }

}


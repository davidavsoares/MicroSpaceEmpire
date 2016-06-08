
package MicroSpaceEmpire.iu.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import MicroSpaceEmpire.modelo.ObservableGame;
//import ui.GUI.Constants;
import static MicroSpaceEmpire.iu.GUI.Constants.*;

public class MicroSpaceEmpireFrame extends JFrame implements Observer, Constants {
    
    private ObservableGame observableGame;       
    private MicroSpaceEmpirePanel MSEPanel;
    
    public MicroSpaceEmpireFrame( ObservableGame j) {
        this( j, 200,100, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y ) {
        this( j, x,y, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MicroSpaceEmpireFrame( ObservableGame j, int x, int y, int width, int height) {
        
        super("Micro Space Empire"); 

        observableGame = j;
        j.addObserver(this);
        
        Container cp = getContentPane(); 
               
        MSEPanel = new MicroSpaceEmpirePanel(observableGame);
        cp.add(MSEPanel, BorderLayout.CENTER);
               
        setLocation(x, y); 
        setSize(width,height); 
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
  
}


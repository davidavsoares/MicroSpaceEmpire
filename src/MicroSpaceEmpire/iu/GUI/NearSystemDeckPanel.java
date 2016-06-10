package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NearSystemDeckPanel extends JPanel implements Constants {
    
    private ObservableGame observableGame;
    private JButton TirarCarta;
    
    public NearSystemDeckPanel(ObservableGame ob) {
        
        ImageIcon CardImg;
        Image img = MicroSpaceEmpirePanel.getNearSystemBackImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        
        this.setLayout(new BorderLayout());
        
        this.observableGame = ob;
        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));
        
        TirarCarta = new JButton("", CardImg);
        TirarCarta.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        //TirarCarta.setMargin(new Insets(0, 0, 0, 0));
        add(TirarCarta, BorderLayout.NORTH);
       
        TirarCarta.addActionListener(new TirarCarta_NearSystem());
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //VALIDACAO VAZIO

        //g.drawImage(MicroSpaceEmpirePanel.getSystemBackImage(), 0, 0, CARD_X, CARD_Y, this);
    }
    
    class TirarCarta_NearSystem implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}

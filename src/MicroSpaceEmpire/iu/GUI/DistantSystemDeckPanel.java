package MicroSpaceEmpire.iu.GUI;

import static MicroSpaceEmpire.iu.GUI.Constants.CARD_X;
import static MicroSpaceEmpire.iu.GUI.Constants.CARD_Y;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DistantSystemDeckPanel extends JPanel implements Constants {

    private ObservableGame ob;
    private JButton TirarCarta;

    public DistantSystemDeckPanel(ObservableGame ob) {

        ImageIcon CardImg;
        Image img = MicroSpaceEmpirePanel.getDistantSystemBackImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));

        this.ob = ob;
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setMaximumSize(new Dimension(CARD_X, CARD_Y));
        this.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        this.setMinimumSize(new Dimension(CARD_X, CARD_Y));

        TirarCarta = new JButton("", CardImg);
        TirarCarta.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        add(TirarCarta, BorderLayout.NORTH);
        TirarCarta.addActionListener(new TirarCarta_DistantSystem());

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //VALIDACAO PARA VAZIO!
        g.drawImage(MicroSpaceEmpirePanel.getNearSystemBackImage(), 0, 0, CARD_X, CARD_Y, this);
    }

    class TirarCarta_DistantSystem implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            TirarCarta.setOpaque(true);
        }
    }

}

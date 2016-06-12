package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
public class NearSystemDeckPanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JButton TirarCarta;

    public NearSystemDeckPanel(ObservableGame ob) {

        ImageIcon CardImg;
        Image img = MicroSpaceEmpirePanel.getNearSystemBackImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));

        this.setLayout(new BorderLayout());

        this.ob = ob;
        ob.addObserver(this);
        setOpaque(false);
        setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X, CARD_Y));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));

        TirarCarta = new JButton("", CardImg);
        TirarCarta.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        add(TirarCarta, BorderLayout.NORTH);

        TirarCarta.addActionListener(new TirarCarta_NearSystem());

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //VALIDACAO VAZIO

        //g.drawImage(MicroSpaceEmpirePanel.getSystemBackImage(), 0, 0, CARD_X, CARD_Y, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        TirarCarta.setEnabled(ob.getEstado() instanceof Estado_1);
    }

    class TirarCarta_NearSystem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ob.ExplorarNearSystem();
        }
    }
}

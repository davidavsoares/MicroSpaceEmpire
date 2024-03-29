package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.MenuInicial;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
public class MenuInicialPanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JButton NJogoB;
    private JButton SairB;

    private JLabel Separador;
    private JLabel Separador2;
    private JLabel Separador3;

    public MenuInicialPanel(ObservableGame ob) {
        this.ob = ob;
        this.ob.addObserver(this);
        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);
        String NJ = "Novo Jogo";
        String Sair = "Sair";

        NJogoB = new JButton(NJ);
        NJogoB.setForeground(Color.BLACK);

        SairB = new JButton(Sair);
        SairB.setForeground(Color.BLACK);

        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);
        Separador3 = new JLabel("---------------------------------------------------");
        Separador3.setForeground(Color.WHITE);

        NJogoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.NovoJogo();
            }
        });

        SairB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

        this.add(Separador);
        this.add(NJogoB);
        this.add(Separador2);
        this.add(SairB);
        this.add(Separador3);

        update(ob, null);
    }

    @Override
    public void update(Observable t, Object o) {
        setVisible(ob.getEstado() instanceof MenuInicial);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

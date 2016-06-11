package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author kalin
 */
public class Menu1Panel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JButton PassarB;
    private JButton ConquistarB;

    private JLabel Separador;
    private JLabel Separador2;
    private JLabel Separador3;

    private JTextArea Dados;

    public Menu1Panel(ObservableGame ob) {
        this.ob = ob;
        this.ob.addObserver(this);
        this.setLayout(new GridLayout(0, 1, 0, 10));
        this.setOpaque(false);

        JPanel Cont = new JPanel();
        Cont.setOpaque(false);

        PassarB = new JButton("Passar");
        PassarB.setForeground(Color.BLACK);
        PassarB.setPreferredSize(new Dimension(50, 30));
        PassarB.setMaximumSize(new Dimension(50, 30));

        ConquistarB = new JButton("Conquistar");
        ConquistarB.setForeground(Color.BLACK);
        ConquistarB.setPreferredSize(new Dimension(50, 30));
        ConquistarB.setMaximumSize(new Dimension(50, 30));

        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);
        Separador3 = new JLabel("---------------------------------------------------");
        Separador3.setForeground(Color.WHITE);

        Dados = new JTextArea("\n Pode conquistar um sistema\n que esteja nos unaligned \n systems no canto superior direito\n premindo Conquistar\n ou passar premindo Passar ");
        Dados.setForeground(Color.WHITE);
        Dados.setOpaque(false);

        PassarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                //setVisible(false);
                ob.Passar();
            }
        });
        ConquistarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                //setVisible(false);
                ob.ConquistarSistema();
            }
        });

        Cont.add(Dados);

        this.add(Cont);
        this.add(Separador);
        this.add(ConquistarB);
        //this.add(Separador2);
        this.add(PassarB);
        this.add(Separador3);

        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(ob.getEstado() instanceof Estado_1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

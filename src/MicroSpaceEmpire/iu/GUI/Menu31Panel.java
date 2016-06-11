package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_31;
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
import javax.swing.JTextArea;

/**
 *
 * @author kalin
 */
public class Menu31Panel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JButton AvancarB;
    private JButton CFMilitarB;
    private JTextArea Dados;
    private JLabel Separador;
    private JLabel Separador2;
    private JLabel Separador3;

    public Menu31Panel(ObservableGame ob) {
        this.ob = ob;
        this.ob.addObserver(this);
        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);

        String x = "\n---------------------------------------------------\nPode construir força militar\npremindo Construir Força Militar\nou avançar premindo Avançar";
        String CF = "Construir Força Militar";

        AvancarB = new JButton("Avancar");
        AvancarB.setForeground(Color.BLACK);
        CFMilitarB = new JButton(CF);
        CFMilitarB.setForeground(Color.BLACK);
        Dados = new JTextArea(x);
        Dados.setForeground(Color.WHITE);
        Dados.setOpaque(false);
        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);
        Separador3 = new JLabel("---------------------------------------------------");
        Separador3.setForeground(Color.WHITE);

        CFMilitarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.ConstruirForcaMilitar();
            }
        });

        AvancarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.Passar();
            }
        });

        this.add(Dados);
        this.add(Separador);
        this.add(CFMilitarB);
        this.add(Separador2);
        this.add(AvancarB);
        this.add(Separador3);

        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(ob.getEstado() instanceof Estado_31);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

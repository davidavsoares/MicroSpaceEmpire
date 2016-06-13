package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.*;
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
public class Menu3Panel extends JPanel implements Constants, Observer {

    private ObservableGame ob;
    private JButton AvancarB;
    private JButton CFMilitarB;
    private JButton DTechB;

    private JLabel Separador;
    private JLabel Separador2;
    private JLabel Separador3;
    private JLabel Separador4;

    public Menu3Panel(ObservableGame ob) {
        this.ob = ob;
        this.ob.addObserver(this);
        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);
        String CF = "Construir Força Militar";

        AvancarB = new JButton("Avancar");
        AvancarB.setForeground(Color.BLACK);

        CFMilitarB = new JButton(CF);
        CFMilitarB.setForeground(Color.BLACK);

        DTechB = new JButton("Descobrir Tecnologia");
        DTechB.setForeground(Color.BLACK);

        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);
        Separador3 = new JLabel("---------------------------------------------------");
        Separador3.setForeground(Color.WHITE);
        Separador4 = new JLabel("---------------------------------------------------");
        Separador4.setForeground(Color.WHITE);

        CFMilitarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                ob.ConstruirForcaMilitar();
            }
        });

        DTechB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                ob.DescobrirTecnologia();
            }
        });

        AvancarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                setVisible(false);
                ob.Passar();
            }
        });

        this.add(Separador);
        this.add(CFMilitarB);
        this.add(Separador2);
        this.add(DTechB);
        this.add(Separador3);
        this.add(AvancarB);
        this.add(Separador4);

        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(ob.getEstado() instanceof Estado_3 && !(ob.getEstado() instanceof Estado_32)&& !(ob.getEstado() instanceof Estado_31));
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

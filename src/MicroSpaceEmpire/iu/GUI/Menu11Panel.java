package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_11;
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
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
public class Menu11Panel extends JPanel implements Constants, Observer {

    private ObservableGame ob;

    private JButton Retornar;

    private JLabel Separador;
    private JLabel Separador2;

    private JTextArea Dados;

    public Menu11Panel(ObservableGame ob) {
        this.ob = ob;
        this.ob.addObserver(this);
        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);

        String x = "\n---------------------------------------------------\n Escolha um sistema que\n esteja nos unaligned systems\n no canto superior direito\n ou pode retornar\n premindo Retornar ";

        Retornar = new JButton("Retornar");
        Retornar.setForeground(Color.BLACK);

        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);

        Dados = new JTextArea(x);
        Dados.setForeground(Color.WHITE);
        Dados.setOpaque(false);

        Retornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.VoltarMenuAnterior();
            }
        });

        this.add(Dados);
        this.add(Separador);
        this.add(Retornar);
        this.add(Separador2);

        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(ob.getEstado() instanceof Estado_11);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}

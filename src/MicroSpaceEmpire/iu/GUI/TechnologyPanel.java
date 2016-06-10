package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_32;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author kalin
 */
public class TechnologyPanel extends JPanel implements Constants, Observer {

    private ObservableGame ob;

    private JButton CShipsB;
    private JButton FStarbasesB;
    private JButton HTelevisionB;
    private JButton ICommerceB;
    private JButton IBankingB;
    private JButton IDiplomacyB;
    private JButton PDefensesB;
    private JButton RWorkersB;

    private JButton Retornar;
    private JLabel Separador;
    private JLabel Separador2;

    private JLabel InfL;

    public TechnologyPanel(ObservableGame ob) {
        this.ob = ob;
        this.setLayout(new GridLayout(0, 1));
        this.setOpaque(false);

        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);
        Retornar = new JButton("Retornar");
        Retornar.setMargin(new Insets(0, 0, 0, 0));
        Retornar.setPreferredSize(new Dimension(50, 30));
        Retornar.setMaximumSize(new Dimension(50, 30));
        Retornar.setForeground(Color.BLACK);

        InfL = new JLabel("    Cost - Technologies");
        InfL.setForeground(Color.WHITE);

        CShipsB = new JButton("       [3] - Capital Ships");
        CShipsB.setMargin(new Insets(0, 0, 0, 0));
        CShipsB.setHorizontalAlignment(SwingConstants.LEFT);
        CShipsB.setForeground(Color.BLACK);
        FStarbasesB = new JButton("       [4] - Forward Starbases");
        FStarbasesB.setMargin(new Insets(0, 0, 0, 0));
        FStarbasesB.setHorizontalAlignment(SwingConstants.LEFT);
        FStarbasesB.setForeground(Color.BLACK);

        RWorkersB = new JButton("       [2] - Robot Workers");
        RWorkersB.setMargin(new Insets(0, 0, 0, 0));
        RWorkersB.setHorizontalAlignment(SwingConstants.LEFT);
        RWorkersB.setForeground(Color.BLACK);
        PDefensesB = new JButton("       [4] - Planetary Defenses");
        PDefensesB.setMargin(new Insets(0, 0, 0, 0));
        PDefensesB.setHorizontalAlignment(SwingConstants.LEFT);
        PDefensesB.setForeground(Color.BLACK);

        HTelevisionB = new JButton("       [3] - Hyper Television");
        HTelevisionB.setMargin(new Insets(0, 0, 0, 0));
        HTelevisionB.setHorizontalAlignment(SwingConstants.LEFT);
        HTelevisionB.setForeground(Color.BLACK);
        IDiplomacyB = new JButton("       [5] - Interstellar Diplomacy");
        IDiplomacyB.setMargin(new Insets(0, 0, 0, 0));
        IDiplomacyB.setHorizontalAlignment(SwingConstants.LEFT);
        IDiplomacyB.setForeground(Color.BLACK);

        ICommerceB = new JButton("       [2] - Interspecies Commerce");
        ICommerceB.setMargin(new Insets(0, 0, 0, 0));
        ICommerceB.setHorizontalAlignment(SwingConstants.LEFT);
        ICommerceB.setForeground(Color.BLACK);
        IBankingB = new JButton("       [3] - Interstellar Banking");
        IBankingB.setMargin(new Insets(0, 0, 0, 0));
        IBankingB.setHorizontalAlignment(SwingConstants.LEFT);
        IBankingB.setForeground(Color.BLACK);

        //listeners
        Retornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().VoltarMenuAnterior();
            }
        });

        CShipsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Capital Ships");
            }
        });

        FStarbasesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Forward Starbases");
            }
        });

        RWorkersB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Robot Workers");
            }
        });

        PDefensesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Planetary Defenses");
            }
        });

        HTelevisionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Hyper Television");
            }
        });

        IDiplomacyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Interstellar Diplomacy");
            }
        });

        ICommerceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Interspecies Commerce");
            }
        });

        IBankingB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.getMaquinaDeEstados().DescobrirTecnologia("Interstellar Banking");
            }
        });

        this.add(InfL);
        this.add(CShipsB);
        this.add(RWorkersB);
        this.add(HTelevisionB);
        this.add(ICommerceB);
        this.add(Separador);
        this.add(FStarbasesB);
        this.add(PDefensesB);
        this.add(IDiplomacyB);
        this.add(IBankingB);
        this.add(Separador);
        this.add(Retornar);
        this.add(Separador2);

        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(ob.getMaquinaDeEstados().getEstado() instanceof Estado_32);
    }

}

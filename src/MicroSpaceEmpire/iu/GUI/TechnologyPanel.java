package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.CapitalShips;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.ForwardStarbases;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.HyperTelevision;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.InterspeciesCommerce;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.InterstellarBanking;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.InterstellarDiplomacy;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.PlanetaryDefenses;
import MicroSpaceEmpire.modelo.Tecnologias.Technologies.RobotWorkers;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;
import MicroSpaceEmpire.modelo.logica.Estado_32;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
        this.ob.addObserver(this);
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
                ob.VoltarMenuAnterior();
            }
        });

        CShipsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Capital Ships");
            }
        });
        CShipsB.setToolTipText("Tecnologia de 1ª geração : Permite força militar até um maximo de 5");
        

        FStarbasesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Forward Starbases");
            }
        });
        FStarbasesB.setToolTipText("Tecnologia de 2ª geração : Necessária para explorar sistemas distantes");
        RWorkersB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Robot Workers");
            }
        });
        RWorkersB.setToolTipText("Tecnologia de 1ª geração : Recebe metade da produção durante uma greve");

        PDefensesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Planetary Defenses");
            }
        });
        PDefensesB.setToolTipText("Tecnologia de 2ª geração : Adiciona 1 unidade de resistencia durante uma invasao");
        HTelevisionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Hyper Television");
            }
        });
        HTelevisionB.setToolTipText("Tecnologia de 1ª geração : Adiciona 1 unidade de resistencia durante uma revolta");
        IDiplomacyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Interstellar Diplomacy");
            }
        });
        IDiplomacyB.setToolTipText("Tecnologia de 2ª geração : Proxima conquista é garantida");
        ICommerceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Interspecies Commerce");
            }
        });
        ICommerceB.setToolTipText("Tecnologia de 1ª geração : Permite trocar 2 unidades de 1 recurso por 1 unidade de outro");
        IBankingB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                ob.DescobrirTecnologia("Interstellar Banking");
            }
        });
        IBankingB.setToolTipText("Tecnologia de 2ª geração : Permite armazenamento de recursos até um maximo de 5");

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
        setVisible(ob.getEstado() instanceof Estado_32);

        ArrayList<Technology_SuperClasse> Techs = ob.getTechnologyDiscovered();

        for (Technology_SuperClasse tech : Techs) {
            if (tech instanceof CapitalShips) {
                CShipsB.setEnabled(false);
            }
            if (tech instanceof ForwardStarbases) {
                FStarbasesB.setEnabled(false);
            }
            if (tech instanceof HyperTelevision) {
                HTelevisionB.setEnabled(false);
            }
            if (tech instanceof InterspeciesCommerce) {
                ICommerceB.setEnabled(false);
            }
            if (tech instanceof InterstellarBanking) {
                IBankingB.setEnabled(false);
            }
            if (tech instanceof InterstellarDiplomacy) {
                IDiplomacyB.setEnabled(false);
            }
            if (tech instanceof PlanetaryDefenses) {
                PDefensesB.setEnabled(false);
            }
            if (tech instanceof RobotWorkers) {
                RWorkersB.setEnabled(false);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

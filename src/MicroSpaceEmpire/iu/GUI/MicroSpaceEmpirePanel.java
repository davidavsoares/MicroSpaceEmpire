package MicroSpaceEmpire.iu.GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class MicroSpaceEmpirePanel extends JPanel implements Observer, Constants {

    static private BufferedImage //EVENTOS
            AsteroidImage = null, DerelictShipImage = null, LargeInvasionForceImage = null,
            PeaceQuietImage = null, RevoltImage = null, Revolt2Image = null, SmallInvasionForceImage = null,
            StrikeImage = null, EventBackImage = null,
            //SISTEMAS
            HomeWorldImage = null, SystemBackImage = null,
            //SISTEMAS PROXIMOS
            CygnusImage = null, EpsilonEridaniImage = null, ProcyonImage = null, ProximaImage = null, SiriusImage = null, TauCetiImage = null, Wolf359Image = null,
            //SISTEMAS DISTANTES
            CanopusImage = null, GalaxysEdgeImage = null, PolarisImage = null;

    public static BufferedImage getAsteroidImage() {
        return AsteroidImage;
    }

    public static BufferedImage getDerelictShipImage() {
        return DerelictShipImage;
    }

    public static BufferedImage getLargeInvasionForceImage() {
        return LargeInvasionForceImage;
    }

    public static BufferedImage getPeaceQuietImage() {
        return PeaceQuietImage;
    }

    public static BufferedImage getRevoltImage() {
        return RevoltImage;
    }

    public static BufferedImage getRevolt2Image() {
        return Revolt2Image;
    }

    public static BufferedImage getSmallInvasionForceImage() {
        return SmallInvasionForceImage;
    }

    public static BufferedImage getStrikeImage() {
        return StrikeImage;
    }

    public static BufferedImage getEventBackImage() {
        return EventBackImage;
    }

    public static BufferedImage getHomeWorldImage() {
        return HomeWorldImage;
    }

    public static BufferedImage getSystemBackImage() {
        return SystemBackImage;
    }

    public static BufferedImage getCygnusImage() {
        return CygnusImage;
    }

    public static BufferedImage getEpsilonEridaniImage() {
        return EpsilonEridaniImage;
    }

    public static BufferedImage getProcyonImage() {
        return ProcyonImage;
    }

    public static BufferedImage getProximaImage() {
        return ProximaImage;
    }

    public static BufferedImage getSiriusImage() {
        return SiriusImage;
    }

    public static BufferedImage getTauCetiImage() {
        return TauCetiImage;
    }

    public static BufferedImage getWolf359Image() {
        return Wolf359Image;
    }

    public static BufferedImage getCanopusImage() {
        return CanopusImage;
    }

    public static BufferedImage getGalaxysEdgeImage() {
        return GalaxysEdgeImage;
    }

    public static BufferedImage getPolarisImage() {
        return PolarisImage;
    }

    static {
        try {
            //CARREGA IMAGENS DE EVENTOS
            AsteroidImage = ImageIO.read(Resources.getResourceFile("images/Event/Asteroid.jpg"));
            DerelictShipImage = ImageIO.read(Resources.getResourceFile("images/Event/DerelictShip.jpg"));
            LargeInvasionForceImage = ImageIO.read(Resources.getResourceFile("images/Event/LargeInvasionForce.jpg"));
            PeaceQuietImage = ImageIO.read(Resources.getResourceFile("images/Event/PeaceQuiet.jpg"));
            RevoltImage = ImageIO.read(Resources.getResourceFile("images/Event/Revolt.jpg"));
            Revolt2Image = ImageIO.read(Resources.getResourceFile("images/Event/Revolt2.jpg"));
            SmallInvasionForceImage = ImageIO.read(Resources.getResourceFile("images/Event/SmallInvasionForce.jpg"));
            StrikeImage = ImageIO.read(Resources.getResourceFile("images/Event/Strike.jpg"));
            EventBackImage = ImageIO.read(Resources.getResourceFile("images/Event/EventBack.jpg"));
            //CARREGA IMAGENS DE SISTEMAS
            HomeWorldImage = ImageIO.read(Resources.getResourceFile("images/System/HomeWorld.jpg"));
            SystemBackImage = ImageIO.read(Resources.getResourceFile("images/System/SystemBack.jpg"));
            //CARREGA IMAGENS DE SISTEMAS PROXIMOS
            CygnusImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Cygnus.jpg"));
            EpsilonEridaniImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/EpsilonEridani.jpg"));
            ProcyonImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Procyon.jpg"));
            ProximaImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Proxima.jpg"));
            SiriusImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Sirius.jpg"));
            TauCetiImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/TauCeti.jpg"));
            Wolf359Image = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Wolf359.jpg"));
            //CARREGA IMAGENS DE SISTEMAS DISTANTES
            CanopusImage = ImageIO.read(Resources.getResourceFile("images/System/Distant System/Canopus.jpg"));
            GalaxysEdgeImage = ImageIO.read(Resources.getResourceFile("images/System/Distant System/GalaxysEdge.jpg"));
            PolarisImage = ImageIO.read(Resources.getResourceFile("images/System/Distant System/Polaris.jpg"));

        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }

    private ObservableGame observableGame;
    private NearSystemDeckPanel NSDPanel;
    private DistantSystemDeckPanel DSDPanel;

//    private ScorePanel scorePanel;
//    private RemovedBallsPanel removedBallsPanel;
//
//    private GameOverPanel gameOverPanel;
//    private AwaitBeginningPanel awaitBeginningPanel;
//    private AwaitBetPanel awaitBetPanel;
//    private AwaitOptionSelectionPanel awaitOptionSelectionPanel;
    private JLabel NSDLabel;//Label para o Near System Deck;
    private JLabel DSDLabel;//Label para o Distant System Deck;
    //private JLabel removedBallsLabel;

    public MicroSpaceEmpirePanel(ObservableGame jogo) {

        this.observableGame = jogo;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
//
//        update(jogo, null);
    }

    private void setupComponents() {
        NSDPanel = new NearSystemDeckPanel(observableGame);
        NSDLabel = new JLabel("Near System Deck");
        NSDLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        NSDLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        DSDPanel = new DistantSystemDeckPanel(observableGame);
        DSDLabel = new JLabel("Distant System DEck");
        DSDLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        DSDLabel.setFont(new Font("Arial", Font.BOLD, 12));
//
//        scorePanel = new ScorePanel(observableGame);
//
//        removedBallsLabel = new JLabel("Balls removed from game");
//        removedBallsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        removedBallsLabel.setFont(new Font("Arial", Font.ITALIC, 12));
//
//        removedBallsPanel = new RemovedBallsPanel(observableGame);
//
//        awaitBeginningPanel = new AwaitBeginningPanel(observableGame);
//        awaitBetPanel = new AwaitBetPanel(observableGame);
//
//        awaitOptionSelectionPanel = new AwaitOptionSelectionPanel(observableGame);
//        gameOverPanel = new GameOverPanel(observableGame);
//
    }

    private void setupLayout() {

        Box LeftBox = Box.createVerticalBox();

        LeftBox.add(Box.createVerticalGlue());
        LeftBox.add(NSDLabel);
        LeftBox.add(NSDPanel);
        LeftBox.add(Box.createVerticalGlue());

        Box rightBox = Box.createVerticalBox();
        rightBox.add(Box.createVerticalGlue());
        rightBox.add(DSDLabel);
        rightBox.add(DSDPanel);
        rightBox.add(Box.createVerticalGlue());
//        rightBox.add(removedBallsLabel);
//        rightBox.add(removedBallsPanel);
        rightBox.add(Box.createVerticalGlue());
//
        Box center = Box.createHorizontalBox();
        center.setBorder(new LineBorder(Color.DARK_GRAY));
//        
        center.add(Box.createHorizontalGlue());
        center.add(LeftBox);
        center.add(Box.createHorizontalGlue());
        center.add(rightBox);
        center.add(Box.createHorizontalGlue());
//
//        JPanel south = new JPanel();
//        south.setMinimumSize(new Dimension(DIM_X_FRAME, DIM_Y_SCORE));
//        south.setPreferredSize(new Dimension(DIM_X_SOUTH_PANEL, DIM_Y_SOUTH_PANEL));
//        south.setOpaque(false);
//
//        south.add(awaitBeginningPanel);
//        south.add(awaitBetPanel);
//        south.add(awaitOptionSelectionPanel);
//        south.add(gameOverPanel);
//        south.setBorder(new LineBorder(Color.DARK_GRAY));
//
        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
//        add(south, BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable t, Object o) {

//        List<Ball> a = observableGame.getBag();
//        int nb = observableGame.getNWhiteBallsInBag();
//        int np = observableGame.getNBlackBallsInBag();
//
//        bagLabel.setText("White balls: " + nb + "   Black balls: " + np);
//        scoreLabel.setText("Score: " + observableGame.getScore());
    }

}

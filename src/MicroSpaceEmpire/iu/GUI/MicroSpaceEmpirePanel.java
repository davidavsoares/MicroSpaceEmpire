package MicroSpaceEmpire.iu.GUI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;
import MicroSpaceEmpire.modelo.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Graphics;

public class MicroSpaceEmpirePanel extends JPanel implements Observer, Constants {

    private ObservableGame ob;
    private NearSystemDeckPanel NSDPanel;
    private DistantSystemDeckPanel DSDPanel;
    private InfoPanel RSPanel;
    private EmpirePanel EPPanel;
    private UnalignedSystemPanel USPanel;
    private CurrentEventPanel CEPanel;

    static private BufferedImage EventBackImage = null,
            //SISTEMAS
            HomeWorldImage = null, NearSystemBackImage = null, DistantSystemBackImage = null,
            //SISTEMAS PROXIMOS
            CygnusImage = null, EpsilonEridaniImage = null, ProcyonImage = null, ProximaImage = null, SiriusImage = null, TauCetiImage = null, Wolf359Image = null,
            //SISTEMAS DISTANTES
            CanopusImage = null, GalaxysEdgeImage = null, PolarisImage = null,
            //RECURSOS
            MetalStorage[] = new BufferedImage[MetalStorageImage.length],
            MetalProduction[] = new BufferedImage[MetalProductionImage.length],
            WealthStorage[] = new BufferedImage[WealthStorageImage.length],
            WealthProduction[] = new BufferedImage[WealthProductionImage.length],
            MilitaryStrength[] = new BufferedImage[MilitaryStrengthImage.length],
            //DADO
            Dice[] = new BufferedImage[DiceImage.length],
            BackgroundImage = null;

    public static BufferedImage getEventBackImage() {
        return EventBackImage;
    }

    public static BufferedImage getHomeWorldImage() {
        return HomeWorldImage;
    }

    public static BufferedImage getNearSystemBackImage() {
        return NearSystemBackImage;
    }

    public static BufferedImage getDistantSystemBackImage() {
        return DistantSystemBackImage;
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

    public ObservableGame getOb() {
        return ob;
    }

    public NearSystemDeckPanel getNSDPanel() {
        return NSDPanel;
    }

    public DistantSystemDeckPanel getDSDPanel() {
        return DSDPanel;
    }

    public static BufferedImage getMetalStorage(int index) {
        return MetalStorage[index];//ob.getMetalStorage()
    }

    public static BufferedImage getMetalProduction(int index) {
        return MetalProduction[index];//ob.getMetalProduction() - 1
    }

    public static BufferedImage getWealthStorage(int index) {
        return WealthStorage[index];//ob.getWealthStorage()
    }

    public static BufferedImage getWealthProduction(int index) {
        return WealthProduction[index];//ob.getWealthProduction() - 1
    }

    public static BufferedImage getMilitaryStrength(int index) {
        return MilitaryStrength[index];//ob.getMilitaryStrength()
    }

    public static BufferedImage getDice(int index) {
        return Dice[index];
    }

    static {
        try {
            //CARREGA IMAGENS DE SISTEMAS
            HomeWorldImage = ImageIO.read(Resources.getResourceFile("images/System/HomeWorld.jpg"));
            NearSystemBackImage = ImageIO.read(Resources.getResourceFile("images/System/NearSystemBack.jpg"));
            DistantSystemBackImage = ImageIO.read(Resources.getResourceFile("images/System/DistantSystemBack.jpg"));

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

            BackgroundImage = ImageIO.read(Resources.getResourceFile(BackGroundImage));

            //CARREGA IMAGENS DE RECURSOS E DADO
            for (int i = 0; i < 6; i++) {

                Dice[i] = ImageIO.read(Resources.getResourceFile(DiceImage[i]));

                MetalStorage[i] = ImageIO.read(Resources.getResourceFile(MetalStorageImage[i]));
                WealthStorage[i] = ImageIO.read(Resources.getResourceFile(WealthStorageImage[i]));
                MilitaryStrength[i] = ImageIO.read(Resources.getResourceFile(MilitaryStrengthImage[i]));
                MetalProduction[i] = ImageIO.read(Resources.getResourceFile(MetalProductionImage[i]));
                WealthProduction[i] = ImageIO.read(Resources.getResourceFile(WealthProductionImage[i]));

            }
        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }

    public MicroSpaceEmpirePanel(ObservableGame ob) {

        this.ob = ob;
        this.ob.addObserver(this);

        setupComponents();
        setupLayout();

//        update(jogo, null);
    }

    private void setupComponents() {

//        NSDLabel = new JLabel("Near System Deck");
//        NSDLabel.setFont(new Font("Arial", Font.ITALIC, 12));
//        NSDLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        DSDLabel = new JLabel("Distant System DEck");
//        DSDLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        DSDLabel.setFont(new Font("Arial", Font.BOLD, 12));
        NSDPanel = new NearSystemDeckPanel(ob);

        DSDPanel = new DistantSystemDeckPanel(ob);

        RSPanel = new InfoPanel(ob);

        EPPanel = new EmpirePanel(ob);

        USPanel = new UnalignedSystemPanel(ob);

        CEPanel = new CurrentEventPanel(ob);

    }

    private void setupLayout() {

        setLayout(new BorderLayout());

        JPanel Oeste = new JPanel(new BorderLayout());
        JPanel Este = new JPanel(new BorderLayout());
        JPanel TopBox = new JPanel(new BorderLayout());

        TopBox.add(NSDPanel, BorderLayout.WEST);
        TopBox.add(DSDPanel, BorderLayout.EAST);

        Oeste.add(TopBox, BorderLayout.NORTH);
        Oeste.add(RSPanel, BorderLayout.CENTER);

        Este.setOpaque(false);
        Oeste.setOpaque(false);

        Este.add(USPanel, BorderLayout.NORTH);
        Este.add(CEPanel, BorderLayout.SOUTH);

        this.add(EPPanel, BorderLayout.CENTER);
        this.add(Este, BorderLayout.EAST);
        this.add(Oeste, BorderLayout.WEST);

        validate();
    }

    @Override
    public void update(Observable ob, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(BackgroundImage, 0, 0, null);
    }

}

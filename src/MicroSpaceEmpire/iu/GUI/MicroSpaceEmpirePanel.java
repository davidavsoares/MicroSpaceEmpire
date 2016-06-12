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
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
public class MicroSpaceEmpirePanel extends JPanel implements Observer, Constants {

    private ObservableGame ob;
    private NearSystemDeckPanel NSDPanel;
    private DistantSystemDeckPanel DSDPanel;
    private InfoPanel RSPanel;
    private EmpirePanel EPPanel;
    private UnalignedSystemPanel USPanel;
    private CurrentEventPanel CEPanel;

    static private Image BackgroundImage = null, EventBackImage = null,
            //SISTEMAS
            HomeWorldImage = null, NearSystemBackImage = null, DistantSystemBackImage = null,
            //SISTEMAS PROXIMOS
            CygnusImage = null, EpsilonEridaniImage = null, ProcyonImage = null, ProximaImage = null, SiriusImage = null, TauCetiImage = null, Wolf359Image = null,
            //SISTEMAS DISTANTES
            CanopusImage = null, GalaxysEdgeImage = null, PolarisImage = null;

    static private BufferedImage //RECURSOS
            MetalStorage[] = new BufferedImage[MetalStorageImage.length],
            MetalProduction[] = new BufferedImage[MetalProductionImage.length],
            WealthStorage[] = new BufferedImage[WealthStorageImage.length],
            WealthProduction[] = new BufferedImage[WealthProductionImage.length],
            MilitaryStrength[] = new BufferedImage[MilitaryStrengthImage.length],
            //DADO
            Dice[] = new BufferedImage[DiceImage.length];

    static {
        try {
            //CARREGA IMAGENS DE SISTEMAS
            HomeWorldImage = ImageIO.read(Resources.getResourceFile("images/System/HomeWorld.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            NearSystemBackImage = ImageIO.read(Resources.getResourceFile("images/System/NearSystemBack.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            DistantSystemBackImage = ImageIO.read(Resources.getResourceFile("images/System/DistantSystemBack.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);

            //CARREGA IMAGENS DE SISTEMAS PROXIMOS
            CygnusImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Cygnus.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            EpsilonEridaniImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/EpsilonEridani.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            ProcyonImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Procyon.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            ProximaImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Proxima.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            SiriusImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Sirius.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            TauCetiImage = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/TauCeti.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            Wolf359Image = ImageIO.read(Resources.getResourceFile("images/System/Near Systems/Wolf359.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);

            //CARREGA IMAGENS DE SISTEMAS DISTANTES
            CanopusImage = ImageIO.read(Resources.getResourceFile("images/System/Distant System/Canopus.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            GalaxysEdgeImage = ImageIO.read(Resources.getResourceFile("images/System/Distant System/GalaxysEdge.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);
            PolarisImage = ImageIO.read(Resources.getResourceFile("images/System/Distant System/Polaris.jpg")).getScaledInstance(CARD_X, CARD_Y, SCALE_SMOOTH);

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

        update(ob, null);
        validate();
    }

    private void setupComponents() {

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

        //validate();
    }

    @Override
    public void update(Observable ob, Object arg) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(BackgroundImage, 0, 0, null);
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

    public InfoPanel getRSPanel() {
        return RSPanel;
    }

    public EmpirePanel getEPPanel() {
        return EPPanel;
    }

    public UnalignedSystemPanel getUSPanel() {
        return USPanel;
    }

    public CurrentEventPanel getCEPanel() {
        return CEPanel;
    }

    public static Image getBackgroundImage() {
        return BackgroundImage;
    }

    public static Image getEventBackImage() {
        return EventBackImage;
    }

    public static Image getHomeWorldImage() {
        return HomeWorldImage;
    }

    public static Image getNearSystemBackImage() {
        return NearSystemBackImage;
    }

    public static Image getDistantSystemBackImage() {
        return DistantSystemBackImage;
    }

    public static Image getCygnusImage() {
        return CygnusImage;
    }

    public static Image getEpsilonEridaniImage() {
        return EpsilonEridaniImage;
    }

    public static Image getProcyonImage() {
        return ProcyonImage;
    }

    public static Image getProximaImage() {
        return ProximaImage;
    }

    public static Image getSiriusImage() {
        return SiriusImage;
    }

    public static Image getTauCetiImage() {
        return TauCetiImage;
    }

    public static Image getWolf359Image() {
        return Wolf359Image;
    }

    public static Image getCanopusImage() {
        return CanopusImage;
    }

    public static Image getGalaxysEdgeImage() {
        return GalaxysEdgeImage;
    }

    public static Image getPolarisImage() {
        return PolarisImage;
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

}

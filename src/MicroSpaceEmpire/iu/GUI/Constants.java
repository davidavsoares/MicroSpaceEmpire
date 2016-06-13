package MicroSpaceEmpire.iu.GUI;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public interface Constants {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();//Obtem a resolucao do ecra

    //Resolução pc David Soares: 1366x768
    static final int DIM_X_FRAME = gd.getDisplayMode().getWidth();//1366;
    static final int DIM_Y_FRAME = gd.getDisplayMode().getHeight();//768;

    //Micro Space Empire
    static final int CARD_X = (int) (DIM_X_FRAME * 0.12);       //para 1366 * 768 permite ter 8 cartas na horizontal
    static final int CARD_Y = (int) (DIM_Y_FRAME * 0.28);

    static final int RESOURCES_Y = (int) (CARD_Y * 0.25);
    static final int RESOURCES_X = RESOURCES_Y;

    static final int DICE_X = RESOURCES_Y;
    static final int DICE_Y = RESOURCES_Y;

    //Relacoes de tamanho entre paineis, considerando 2% de altura em cima e 1% de largura
    static final int BETWEEN_PANELS_X = (int) ((DIM_X_FRAME * 0.06) / 7);
    static final int BETWEEN_PANELS_Y = (int) (DIM_Y_FRAME * 0.03);

    static final int SUPERIOR_BORDERS = (int) (0.02 * DIM_Y_FRAME);         //
    static final int INFERIOR_BORDERS = (int) (0.01 * DIM_Y_FRAME);

    //Tamanho do painel de recursos
    static final int RESOURCES_PANEL_X = 2 * CARD_X + BETWEEN_PANELS_X;
    static final int RESOURCES_PANEL_Y = 2 * CARD_Y + BETWEEN_PANELS_Y;

    static final String DiceImage[] = {
        "images/Dice/Dice1.png", "images/Dice/Dice2.png", "images/Dice/Dice3.png",
        "images/Dice/Dice4.png", "images/Dice/Dice5.png", "images/Dice/Dice6.png"};

    static final String MetalStorageImage[] = {
        "images/Resources/MetalStorage0.png", "images/Resources/MetalStorage1.png",
        "images/Resources/MetalStorage2.png", "images/Resources/MetalStorage3.png",
        "images/Resources/MetalStorage4.png", "images/Resources/MetalStorage5.png"};

    static final String MetalProductionImage[] = {
        "images/Resources/MetalProduction+0.png", "images/Resources/MetalProduction+1.png",
        "images/Resources/MetalProduction+2.png", "images/Resources/MetalProduction+3.png",
        "images/Resources/MetalProduction+4.png", "images/Resources/MetalProduction+5.png"};

    static final String WealthStorageImage[] = {
        "images/Resources/WealthStorage0.png", "images/Resources/WealthStorage1.png",
        "images/Resources/WealthStorage2.png", "images/Resources/WealthStorage3.png",
        "images/Resources/WealthStorage4.png", "images/Resources/WealthStorage5.png"};

    static final String WealthProductionImage[] = {
        "images/Resources/WealthProduction+0.png", "images/Resources/WealthProduction+1.png",
        "images/Resources/WealthProduction+2.png", "images/Resources/WealthProduction+3.png",
        "images/Resources/WealthProduction+4.png", "images/Resources/WealthProduction+5.png"};

    static final String MilitaryStrengthImage[] = {
        "images/Resources/MilitaryStrength0.png", "images/Resources/MilitaryStrength1.png",
        "images/Resources/MilitaryStrength2.png", "images/Resources/MilitaryStrength3.png",
        "images/Resources/MilitaryStrength4.png", "images/Resources/MilitaryStrength5.png"};

    static final String BackGroundImage = "images/space.jpg";

}

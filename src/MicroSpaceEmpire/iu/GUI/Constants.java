package MicroSpaceEmpire.iu.GUI;

public interface Constants {

    static final int DIM_X_BALL = 20;
    static final int DIM_Y_BALL = 20;

    static final int BORDER_X = 10;
    static final int BORDER_Y = 10;

    static final int GAP_X_BALLS = 10;
    static final int GAP_Y_BALLS = 10;

    static final int DIM_X_BAG = 200, DIM_Y_BAG = 200;
    static final int DIM_X_SCORE = 6 * (DIM_X_BALL) + 5 * GAP_X_BALLS + 2 * BORDER_X;
    static final int DIM_Y_SCORE = 2 * (DIM_Y_BALL) + GAP_Y_BALLS + 2 * BORDER_Y;

    static final int REMOVED_BALLS_X = 10 * (DIM_X_BALL) + 9 * GAP_X_BALLS + 2 * BORDER_X;
    static final int REMOVED_BALLS_Y = 2 * (DIM_Y_BALL) + 1 * GAP_Y_BALLS + 2 * BORDER_Y;

    static final int SCORE_BOX_X = DIM_X_SCORE + 2 * BORDER_X;
    static final int SCORE_BOX_Y = DIM_Y_SCORE + 2 * BORDER_Y;

    //Resolução pc David Soares: 1366x768
    static final int DIM_X_FRAME = 1366;
    static final int DIM_Y_FRAME = 768;

    static final int DIM_X_SOUTH_PANEL = DIM_X_FRAME;
    static final int DIM_Y_SOUTH_PANEL = 65;

    //Micro Space Empire
    static final int CARD_X = (int)(DIM_X_FRAME * 0.12);
    static final int CARD_Y = (int)(DIM_Y_FRAME * 0.3);
    
}

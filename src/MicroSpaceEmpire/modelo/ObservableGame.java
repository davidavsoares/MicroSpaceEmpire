package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Sistema;
import java.util.ArrayList;
import java.util.Observable;
//import model.data.Ball;
//import model.data.DataGame;
//import model.data.WhiteBall;
//import model.states.IStates;

public class ObservableGame extends Observable
{
    MaquinaDeEstados ME;
    
    public ObservableGame()
    {
        ME = new MaquinaDeEstados();
    }
    
    public Dados getDataGame()
    {
        return ME.getGameInfo();
    }

//    public void setDataGame(DataGame dataGame)
//    {
//        gModel.setDataGame(dataGame);
//        
//        setChanged();
//        notifyObservers();
//    }
    
    public void setMaquinaDeEstados(MaquinaDeEstados ME)
    {
        this.ME = ME;
        
        setChanged();
        notifyObservers();
    }

//    public IEstado getState() {
//        return ME.getState();
//    }
//
////    public void setState(IStates state) {
////        gModel.setState(state);
////        
////        setChanged();
////        notifyObservers();
////    }    
//    
//    //------------------------------ Methods that enable accessing the data/status of the game ----------------------------
//    
    public ArrayList<Sistema> getEmpire() 
    {
        return ME.getEmpire();
    }
//   
//    public List<WhiteBall> getCollectedWhiteBalls() 
//    {
//        return gModel.getCollectedWhiteBalls();
//    }
//    
//    public int getScore()
//    {
//        return gModel.getScore();
//    }
//    
//    public int getBettedValue()
//    {
//        return gModel.getBettedValue();
//    }
//    
//    public int getNWhiteBallsInBag(){
//        return gModel.getNWhiteBallsInBag();
//    }
//    
//    public int getNBlackBallsInBag(){
//        return gModel.getNBlackBallsInBag();
//    }
//            
//    public int getNWhiteBallsRemovedFromGame(){
//        return gModel.getNWhiteBallsRemovedFromGame();
//    }
//    
//    public int getNBlackBallsRemovedFromGame(){
//        return gModel.getNBlackBallsRemovedFromGame();
//    }
//
//    @Override
//    public String toString()
//    {   
//        return gModel.toString();
//    }
//    
//    //--------------------- Methods that trigger events/actions in the finite state machine  -----------------------
//    
//    public void start()
//    {
//        gModel.start();
//        
//        setChanged();
//        notifyObservers();
//    }
//    
//    public void finish()
//    {
//        gModel.finish();
//        
//        setChanged();
//        notifyObservers();
//    }
//    
//    public void bet(int nBalls)
//    {
//        gModel.bet(nBalls);
//        
//        setChanged();
//        notifyObservers();
//    }
//    
//    public void removeOneBallFromCollectedWhiteBalls()
//    {
//        gModel.removeOneBallFromCollectedWhiteBalls();
//        
//        setChanged();
//        notifyObservers();
//    }
//    
//    public void getTwoBallsFromBag()
//    {
//        gModel.getTwoBallsFromBag();
//        
//        setChanged();
//        notifyObservers();
//    }
}

package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.Cartas.Event;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import java.util.ArrayList;
import java.util.Observable;

public class ObservableGame extends Observable {

    MaquinaDeEstados ME;

    public ObservableGame() {
        ME = new MaquinaDeEstados();
    }

    public Dados getDataGame() {
        return ME.getGameInfo();
    }

//    public void setDataGame(DataGame dataGame)
//    {
//        gModel.setDataGame(dataGame);
//        
//        setChanged();
//        notifyObservers();
//    }
    public void setMaquinaDeEstados(MaquinaDeEstados ME) {
        this.ME = ME;

        setChanged();
        notifyObservers();
    }

    public MaquinaDeEstados getMaquinaDeEstados() {
        return ME;
    }

    public int getDice() {
        return ME.getDice();
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
    public ArrayList<Sistema> getEmpire() {
        return ME.getEmpire();
    }

    public ArrayList<Sistema> getUnalignedSystems() {
        return ME.getUnalignedSystems();
    }

    public ArrayList<Event> getEventDeck() {
        return ME.getEventDeck();
    }

    public Event getCurrentEvent() {
        return ME.getCurrentEvent();
    }
    
    
    public int getMetalProduction() {
        return ME.getMetalProduction();
    }

    public int getWealthProduction() {
        return ME.getWealthProduction();
    }

    public int getMetalStorage() {
        return ME.getMetalStorage();
    }

    public int getWealthStorage() {
        return ME.getWealthStorage();
    }

    public int getMilitaryStrength() {
        return ME.getMilitaryStrength();
    }
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

    public void Sair() {
        ME.Sair();

        setChanged();
        notifyObservers();
    }
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

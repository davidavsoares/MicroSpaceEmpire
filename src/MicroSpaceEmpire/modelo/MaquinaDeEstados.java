package MicroSpaceEmpire.modelo;

import MicroSpaceEmpire.modelo.logica.IEstado;
import MicroSpaceEmpire.modelo.logica.MenuInicial;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import MicroSpaceEmpire.modelo.Cartas.*;
import MicroSpaceEmpire.modelo.Tecnologias.Technology_SuperClasse;
import java.io.Serializable;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class MaquinaDeEstados implements Serializable {

    private static final long serialVersionUID = 42L;
    private IEstado estado;

    private Dados GameInfo;

    public Dados getGameInfo() {
        return GameInfo;
    }

    public void setGameInfo(Dados GameInfo) {
        this.GameInfo = GameInfo;
    }

    @Override
    public String toString() {
        return GameInfo.toString();
    }

    public MaquinaDeEstados() {
        GameInfo = new Dados();
        estado = new MenuInicial(GameInfo);
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }

// -------------------------- MENU INICIAL ---------------------------------- //
    public void NovoJogo() {
        setEstado(estado.NovoJogo());
    }

    public IEstado CarregarJogo() {
        try {
            FileInputStream fileIn = new FileInputStream("Save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.GameInfo = ((Dados) in.readObject());
            this.estado = (IEstado) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();

        }
        return estado.CarregarJogo();
    }

// -------------------------- ETAPA 1 --------------------------------------- //
    public void ConquistarSistema() {
        setEstado(estado.ConquistarSistema());
    }

    public void ExplorarNearSystem() {
        setEstado(estado.ExplorarNearSystem());
    }

    public void ExplorarDistantSystem() {
        setEstado(estado.ExplorarDistantSystem());
    }

    public void VoltarMenuAnterior() {
        setEstado(estado.VoltarMenuAnterior());
    }

// -------------------------- ETAPA 2 --------------------------------------- //
    public void RecolherMR() {
        setEstado(estado.DecMetalIncRiqueza());
    }

    public void DescobrirTecnologia(String tech) {
        setEstado(estado.DescobrirTecnologia(tech));
    }

    public void DescobrirTecnologia() {
        setEstado(estado.DescobrirTecnologia());
    }

    public void ConstruirForcaMilitar() {
        setEstado(estado.ConstruirForcaMilitar());
    }

// -------------------------- ETAPA 3 --------------------------------------- //
    public void DecMetalIncRiqueza() {
        setEstado(estado.DecMetalIncRiqueza());
    }

    public void DecRiquezaIncMetal() {
        setEstado(estado.DecRiquezaIncMetal());
    }
//// -------------------------- ETAPA 4 --------------------------------------- //
//
//    public void VerificaFim() {
//        setEstado(estado.VerificaFim());
//    }

// ---------------------------- TODOS --------------------------------------- //
    public void Batalha(int index) {
        setEstado(estado.ConquistaUnaligned(index));
    }

    public void Sair() {
        setEstado(getEstado().Sair());
    }

    public void GuardarJogo() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(GameInfo);
            out.writeObject(estado);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();

        }
    }

    public void Passar() {
        setEstado(estado.Passar());
    }

    public ArrayList<Sistema> getEmpire() {

//        ArrayList<System> ola = new ArrayList<>();
//                ola = getGameInfo().getEmpire();
        return getGameInfo().getEmpire();
    }

    public ArrayList<Sistema> getUnalignedSystems() {
        return getGameInfo().getUnalignedSystems();
    }

    public ArrayList<Technology_SuperClasse> getTechnologyDiscovered() {
        return getGameInfo().getTechnologyDiscovered();
    }

    public ArrayList<Event> getEventDeck() {
        return GameInfo.getEventDeck();
    }

    public Event getCurrentEvent() {
        return GameInfo.getCurrentEvent();
    }

    public int getDice() {
        return GameInfo.getDice();
    }

    public int getMetalProduction() {
        return GameInfo.getMetalProduction();
    }

    public int getWealthProduction() {
        return GameInfo.getWealthProduction();
    }

    public int getMetalStorage() {
        return GameInfo.getMetalStorage();
    }

    public int getWealthStorage() {
        return GameInfo.getWealthStorage();
    }

    public int getMilitaryStrength() {
        return GameInfo.getMilitaryStrength();
    }
}

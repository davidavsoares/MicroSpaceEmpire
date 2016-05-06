package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author David
 */
public class MenuInicial extends Estado_0 {

    public MenuInicial(Dados GameInfo) {
        super(GameInfo);
    }

    public IEstado CarregarJogo(Dados GameInfo) {
        IEstado aux = null;
        try {
            FileInputStream fileIn = new FileInputStream("Save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            GameInfo = ((Dados) in.readObject());
            aux = (IEstado) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return aux;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return aux;
        }
        return aux;
    }

    @Override
    public IEstado NovoJogo() {
        return new Estado_1(getGameInfo());
    }
}

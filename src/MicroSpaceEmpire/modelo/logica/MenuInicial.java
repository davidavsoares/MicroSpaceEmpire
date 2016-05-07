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

    public IEstado CarregarJogo() {
        return this;
    }

    @Override
    public IEstado NovoJogo() {
        return new Estado_1(getGameInfo());
    }
}

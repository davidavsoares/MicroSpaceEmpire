package MicroSpaceEmpire.modelo.logica;

import MicroSpaceEmpire.modelo.Dados;
import MicroSpaceEmpire.modelo.StringException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Estado_32 extends Estado_3 {

    boolean Repeticao;

    public Estado_32(Dados GameInfo, boolean Repeticao) {
        super(GameInfo);
        this.Repeticao = Repeticao;

    }

    @Override
    public IEstado DescobrirTecnologia(String tech) {
        try {
            if (getGameInfo().getTechnology(tech) != null) {
                if (getGameInfo().getTechnology(tech).CompraTecnologia()) {
                    if (Repeticao) {
                        return new Estado_31(getGameInfo());
                    } else {
                        //return new Fase_4(getGameInfo());
                        return super.Fase_4();
                    }
                } else {
                    return this;
                }
            }
        } catch (StringException ex) {
            Logger.getLogger(Estado_32.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Repeticao) {
            return new Estado_31(getGameInfo());
        } else {
            return super.Fase_4();
        }
    }

    @Override
    public IEstado VoltarMenuAnterior() {
        return new Estado_3(getGameInfo(), Repeticao);
    }
}

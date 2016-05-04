
package MicroSpaceEmpire.modelo.estados;

import MicroSpaceEmpire.modelo.dados.JogoDados;


/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class AguardaInicio extends EstadoAdapter
{
    
    public AguardaInicio(JogoDados jogoDados)
    {
        super(jogoDados);
    }
    
    @Override
    public IEstado iniciar()
    { 
        getJogoDados().iniciar();
        return new AguardaAposta(getJogoDados()); 
    }
}
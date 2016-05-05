
package MicroSpaceEmpire.modelo.estados;

import MicroSpaceEmpire.modelo.dados.Bola;
import MicroSpaceEmpire.modelo.dados.JogoDados;
import MicroSpaceEmpire.modelo.dados.EmptyException;


/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class AguardaOpcao extends CorreJogo
{
    
    public AguardaOpcao(JogoDados dataGame)
    {
        super(dataGame);
    }
    
    @Override
    public IEstado removerBolaBrancaDePontuacao()
    {                      
        try {
            getJogoDados().retiraBolaBrancaPontuacao();
        } catch (EmptyException e) {
            return this;
        }
        
         if(getJogoDados().isSacoVazio()){ //Should not happen if this method was appropriately called...
            return new Sair(getJogoDados());    
        }
         
        return new AguardaAposta(getJogoDados()); 
    }
    
    @Override
    public IEstado retirarDuasBolasDoSaco()
    { 
        Bola bola1 = null;
        Bola bola2 = null;
        
        try{
            bola1 = getJogoDados().retiraBolaDoSaco();
            bola2 = getJogoDados().retiraBolaDoSaco();
        }catch(EmptyException e){
            return new Sair(getJogoDados());    
        }
        
        if(bola1 != null){
            // if bola1 instaceof BolaBranca ... else ...
            bola1.serReveladaDoSacoAposOpcao();
        }
        
        if(bola2 != null){
            bola2.serReveladaDoSacoAposOpcao();
        }
        
        if(getJogoDados().isSacoVazio()){
            return new Sair(getJogoDados());    
        }
        
        return new AguardaAposta(getJogoDados()); 
    }
    
}

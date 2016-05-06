package MicroSpaceEmpire.modelo.Tecnologias;

import MicroSpaceEmpire.modelo.Tecnologias.Technologies.ForwardStarbases;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 */
public class Technology {

    private String nome;

    public Technology(String n) {
        nome = n;
    }

    public void IntegrarDescobertas() //Função polimorfica para fazer um planeta integrar o imperio
    {
//        getGameInfo().getEmpire().add(this);
    }

    public boolean equals(Object obj) {
        boolean sameSame = false;

        if (obj != null && obj instanceof ForwardStarbases) {
            sameSame = this.nome == ((ForwardStarbases) obj).getNome();
        }

        return sameSame;
    }

    public String getNome() {
        return nome;
    }
    
}

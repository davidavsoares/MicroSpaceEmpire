/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MicroSpaceEmpire.iu.GUI;

import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kalin
 */
public class Menu2Panel extends JPanel implements Constants {
    private ObservableGame ob;
    private JButton AvancarB;
    private JButton TMRB;
    private JButton TRMB;
    
    private JLabel Separador;
    private JLabel Separador2;
    private JLabel Separador3;
    private JLabel Separador4;
    
    public Menu2Panel(ObservableGame ob)
    {
        this.ob = ob;
        this.setLayout(new GridLayout(0,1));
        this.setOpaque(false);
        String TMR = "Trocar Metal por Riqueza";
        String TRM = "Trocar Riqueza por Metal";
        
        AvancarB = new JButton("Avancar");
        AvancarB.setForeground(Color.BLACK);
        
        TMRB = new JButton(TMR);
        TMRB.setForeground(Color.BLACK);
        
        TRMB = new JButton(TRM);
        TRMB.setForeground(Color.BLACK);
        
        Separador = new JLabel("---------------------------------------------------");
        Separador.setForeground(Color.WHITE);
        Separador2 = new JLabel("---------------------------------------------------");
        Separador2.setForeground(Color.WHITE);
        Separador3 = new JLabel("---------------------------------------------------");
        Separador3.setForeground(Color.WHITE);
        Separador4 = new JLabel("---------------------------------------------------");
        Separador4.setForeground(Color.WHITE);
        
        
        
        TMRB.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ob.getMaquinaDeEstados().DecMetalIncRiqueza();
            }
        });
        
        TRMB.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ob.getMaquinaDeEstados().DecRiquezaIncMetal();
            }
        });
        
        AvancarB.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ob.getMaquinaDeEstados().Passar();
            }
        });
        
        this.add(Separador);
        this.add(TMRB);
        this.add(Separador2);
        this.add(TRMB);
        this.add(Separador3);
        this.add(AvancarB);
        this.add(Separador4);
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        setVisible(ob.getMaquinaDeEstados().getEstado() instanceof Estado_2);
    }
    
}
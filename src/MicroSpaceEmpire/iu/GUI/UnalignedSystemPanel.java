package MicroSpaceEmpire.iu.GUI;

import static MicroSpaceEmpire.iu.GUI.Constants.CARD_X;
import static MicroSpaceEmpire.iu.GUI.Constants.CARD_Y;
import MicroSpaceEmpire.modelo.Cartas.Carta;
import MicroSpaceEmpire.modelo.Cartas.Sistema;
import MicroSpaceEmpire.modelo.Cartas.Systems.DistantSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.NearSystems.*;
import MicroSpaceEmpire.modelo.Cartas.Systems.StartingSystems.HomeWorld;
import MicroSpaceEmpire.modelo.ObservableGame;
import MicroSpaceEmpire.modelo.logica.Estado_11;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UnalignedSystemPanel extends JPanel implements Constants, Observer{

    private ObservableGame ob;
    private JButton HW;
    private JButton NSC;
    private JButton NSEE;
    private JButton NSP;
    private JButton NSPr;
    private JButton NSS;
    private JButton NSTC;
    private JButton NSW;
     
    private JButton DSC;
    private JButton DSG;
    private JButton DSP;
    
    private JPanel BoxEsq;
    private JPanel BoxDir;

    public UnalignedSystemPanel(ObservableGame observableGame) {

        this.ob = observableGame;
        ob.addObserver(this);
        
        this.setLayout(new GridLayout(1,1));
        setOpaque(false);
        //setMaximumSize(new Dimension(CARD_X, CARD_Y));
        setPreferredSize(new Dimension(CARD_X*2, CARD_Y*2));
        setMinimumSize(new Dimension(CARD_X, CARD_Y));
        
        BoxEsq = new JPanel();
        BoxEsq.setLayout(new BoxLayout(BoxEsq, BoxLayout.Y_AXIS));
        BoxEsq.setOpaque(false);
        
        BoxDir = new JPanel();
        BoxDir.setLayout(new BoxLayout(BoxDir, BoxLayout.Y_AXIS));
        BoxDir.setOpaque(false);
        
        ImageIcon CardImg;
        Image img;
        
        img = MicroSpaceEmpirePanel.getHomeWorldImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        HW = new JButton("", CardImg);
        HW.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        HW.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof HomeWorld)
                    {
                        HW.setEnabled(false);
                        HW.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        
        img = MicroSpaceEmpirePanel.getCygnusImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSC = new JButton("", CardImg);
        NSC.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSC.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Cygnus)
                    {
                        NSC.setEnabled(false);
                        NSC.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getEpsilonEridaniImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSEE = new JButton("", CardImg);
        NSEE.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSEE.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof EpsilonEridani)
                    {
                        NSEE.setEnabled(false);
                        NSEE.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getProcyonImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSP = new JButton("", CardImg);
        NSP.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSP.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Procyon)
                    {
                        NSP.setEnabled(false);
                        NSP.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getProximaImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSPr = new JButton("", CardImg);
        NSPr.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSPr.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Proxima)
                    {
                        NSPr.setEnabled(false);
                        NSPr.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getSiriusImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSS = new JButton("", CardImg);
        NSS.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSS.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Sirius)
                    {
                        NSS.setEnabled(false);
                        NSS.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getTauCetiImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSTC = new JButton("", CardImg);
        NSTC.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSTC.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof TauCeti)
                    {
                        NSTC.setEnabled(false);
                        NSTC.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getWolf359Image();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        NSW = new JButton("", CardImg);
        NSW.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        NSW.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Wolf359)
                    {
                        NSW.setEnabled(false);
                        NSW.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getCanopusImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        DSC = new JButton("", CardImg);
        DSC.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        DSC.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Canopus)
                    {
                        DSC.setEnabled(false);
                        DSC.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        img = MicroSpaceEmpirePanel.getGalaxysEdgeImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        DSG = new JButton("", CardImg);
        DSG.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        DSG.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof GalaxysEdge)
                    {
                        DSG.setEnabled(false);
                        DSG.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
      
        img = MicroSpaceEmpirePanel.getPolarisImage();
        CardImg = new ImageIcon(img.getScaledInstance(CARD_X, CARD_Y, java.awt.Image.SCALE_SMOOTH));
        DSP = new JButton("", CardImg);
        DSP.setPreferredSize(new Dimension(CARD_X, CARD_Y));
        DSP.addActionListener(new ActionListener(){        
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                ArrayList<Sistema> US;
                US = ob.getUnalignedSystems();
                for (int i = 0; i < US.size(); i++)
                {
                    if (US.get(i) instanceof Polaris)
                    {
                        DSP.setEnabled(false);
                        DSP.setVisible(false);
                        ob.Batalha(i);
                    }
                }
            }
        });
        
        BoxEsq.add(HW);
        BoxEsq.add(NSC);
        BoxEsq.add(NSEE);
        BoxEsq.add(NSP);
        BoxEsq.add(NSPr);
        BoxEsq.add(NSS);
        
        BoxDir.add(NSTC);
        BoxDir.add(NSW);
        BoxDir.add(DSC);
        BoxDir.add(DSG);
        BoxDir.add(DSP);
        
        this.add(BoxEsq);
        this.add(BoxDir);
        
        HW.setEnabled(false);
        HW.setVisible(false);
        
        NSC.setEnabled(false);
        NSC.setVisible(false);
        
        NSEE.setEnabled(false);
        NSEE.setVisible(false);
        
        NSP.setEnabled(false);
        NSP.setVisible(false);
        
        NSPr.setEnabled(false);
        NSPr.setVisible(false);
        
        NSS.setEnabled(false);
        NSS.setVisible(false);
        
        NSTC.setEnabled(false);
        NSTC.setVisible(false);
        
        NSW.setEnabled(false);
        NSW.setVisible(false);
        
        DSC.setEnabled(false);
        DSC.setVisible(false);
        
        DSG.setEnabled(false);
        DSG.setVisible(false);
        
        DSP.setEnabled(false);
        DSP.setVisible(false);
        
        update(ob, null);
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        setEnabled(ob.getEstado() instanceof Estado_11);
        ArrayList<Sistema> USystems;
        USystems = ob.getUnalignedSystems();
        
        for (Carta sistema : USystems) 
        {
            if (sistema instanceof HomeWorld) {
                HW.setVisible(true);
                HW.setEnabled(true);
            } else if (sistema instanceof Cygnus) {
                NSC.setVisible(true);
                NSC.setEnabled(true);
            } else if (sistema instanceof EpsilonEridani) {
                NSEE.setVisible(true);
                NSEE.setEnabled(true);
            } else if (sistema instanceof Procyon) {
                NSP.setVisible(true);
                NSP.setEnabled(true);
            } else if (sistema instanceof Proxima) {
                NSPr.setVisible(true);
                NSPr.setEnabled(true);
            } else if (sistema instanceof Sirius) {
                NSS.setVisible(true);
                NSS.setEnabled(true);
            } else if (sistema instanceof TauCeti) {
                NSTC.setVisible(true);
                NSTC.setEnabled(true);
            } else if (sistema instanceof Wolf359) {
                NSW.setVisible(true);
                NSW.setEnabled(true);
            } else if (sistema instanceof Canopus) {
                DSC.setVisible(true);
                DSC.setEnabled(true);
            } else if (sistema instanceof GalaxysEdge) {
                DSG.setVisible(true);
                DSG.setEnabled(true);
            } else if (sistema instanceof Polaris) {
                DSP.setVisible(true);
                DSP.setEnabled(true);
            }
        }
        
    }

}

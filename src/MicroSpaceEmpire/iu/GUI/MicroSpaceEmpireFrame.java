package MicroSpaceEmpire.iu.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import MicroSpaceEmpire.modelo.ObservableGame;
import static MicroSpaceEmpire.iu.GUI.Constants.*;
import MicroSpaceEmpire.modelo.MaquinaDeEstados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import MicroSpaceEmpire.files.FileUtility;

/**
 * I.S.E.C.
 *
 * @author DavidSoares [21220084] && JorgeNogueira [21200794]
 * @param args
 */
public class MicroSpaceEmpireFrame extends JFrame implements Observer, Constants {

    private ObservableGame ob;
    private MicroSpaceEmpirePanel MSEPanel;

    public MicroSpaceEmpireFrame(ObservableGame j) {
        this(j, 200, 100, DIM_X_FRAME, DIM_Y_FRAME);
    }

    public MicroSpaceEmpireFrame(ObservableGame j, int x, int y) {
        this(j, x, y, DIM_X_FRAME, DIM_Y_FRAME);
    }

    public MicroSpaceEmpireFrame(ObservableGame j, int x, int y, int width, int height) {

        super("Micro Space Empire");

        ob = j;
        j.addObserver(this);

        Container cp = getContentPane();
        menus();
        MSEPanel = new MicroSpaceEmpirePanel(ob);
        cp.add(MSEPanel, BorderLayout.CENTER);

        setLocation(x, y);
        setSize(width, height);
        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        validate();

    }

    class NewObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            ob.Sair();
            ob.NovoJogo();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    class SaveObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showSaveDialog(MicroSpaceEmpireFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                try {
                    FileUtility.saveGameToFile(file, ob.getMaquinaDeEstados());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this, "Operation failed: \r\n\r\n" + e);
                }
            } else {
                System.out.println("Operation canceled");
            }
        }
    }

    class LoadObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showOpenDialog(MicroSpaceEmpireFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                try {
                    MaquinaDeEstados ME = (MaquinaDeEstados) FileUtility.retrieveGameFromFile(file); //game.setGameModel((GameModel)FileUtility.retrieveGameFromFile(file));
                    if (ME != null) {
                        ob.setMaquinaDeEstados(ME);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this, "Operation failed: \r\n\r\n" + e);
                }
            } else {
                System.out.println("Operation canceled");
            }
        }
    }

    class HelpContentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,
                    "Deve carregar numa carta ... Falta implementação",
                    "Help Contents", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class AboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(MicroSpaceEmpireFrame.this,
                    "Micro Space Empire\nISEC\nDavid Soares\nJorge Nogueira\nMaria Correia\nJosé Marinho",
                    "About", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void menus() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // game menu
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);

        JMenuItem newObjJMI = new JMenuItem("Novo Jogo");
        newObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem loadObjJMI = new JMenuItem("Load");
        loadObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        JMenuItem saveObjJMI = new JMenuItem("Save");
        saveObjJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem exitJMI = new JMenuItem("Exit");
        exitJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        gameMenu.add(newObjJMI);
        gameMenu.add(saveObjJMI);
        gameMenu.add(loadObjJMI);
        gameMenu.addSeparator();
        gameMenu.add(exitJMI);

        menuBar.add(gameMenu);

        newObjJMI.addActionListener(new NewObjMenuBarListener());
        loadObjJMI.addActionListener(new LoadObjMenuBarListener());
        saveObjJMI.addActionListener(new SaveObjMenuBarListener());
        exitJMI.addActionListener(new ExitListener());

        //help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        JMenuItem helpContentJMI = new JMenuItem("Help Contents");
        helpContentJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

        JMenuItem aboutJMI = new JMenuItem("About");
        aboutJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        helpMenu.add(helpContentJMI);
        helpMenu.add(aboutJMI);
        menuBar.add(helpMenu);

        helpContentJMI.addActionListener(new HelpContentListener());
        aboutJMI.addActionListener(new AboutListener());
    }

}

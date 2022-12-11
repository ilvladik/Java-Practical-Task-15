package exercise_3;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private JMenuBar menu = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenu menuEdit = new JMenu("Edit");
    private JMenu menuHelp = new JMenu("Help");

    public AppFrame() {
        super("AppFrame");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        menu.add(menuFile);
        menu.add(menuEdit);
        menu.add(menuHelp);

        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        menuFile.add(save);
        menuFile.add(exit);

        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem paste = new JMenuItem("Paste");
        menuEdit.add(copy);
        menuEdit.add(cut);
        menuEdit.add(paste);

        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JTextArea("This is the area you can write text"));

        setJMenuBar(menu);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppFrame();
    }
}

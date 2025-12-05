package edu.loyola.cs485.model.view;

import javax.swing.*;

public class MainFrame extends JFrame{
    public MainFrame() {
        super("Group Project - Fighting Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        createMenuBar();
    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");

        JMenuItem mniClient = new JMenuItem("Stage CRUD");
        mniClient.addActionListener(e -> {
            createStageCrudDialog();
        });
        mnuFile.add(mniClient);
        mnuFile.addSeparator();

        JMenuItem mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(e ->{
            System.exit(0);
        });
        mnuFile.add(mniExit);

        menuBar.add(mnuFile);
        this.setJMenuBar(menuBar);
    }

    public void createStageCrudDialog(){
        StageCrudDialog dialog = new StageCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
    }
}

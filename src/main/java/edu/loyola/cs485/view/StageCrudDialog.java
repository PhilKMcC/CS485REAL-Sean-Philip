package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.StageService;
import edu.loyola.cs485.model.entity.Stage;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class StageCrudDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton deleteButton;
    private JButton updateButton;
    private JList stageListUI;
    private JList StageUI;

    public StageCrudDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNew();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDelete();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUpdate();
            }
        });
    }

    private void onNew() {
        StageInfoDialog dialog = new StageInfoDialog();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onDelete() {
        try{
            StageService service = new StageService();
            Stage s = (Stage) stageListUI.getSelectedValue();
            if (s != null) {
                service.deleteStage(s.getID());
                stageListUI.clearSelection();

                // Repopulate the JList to get new data
                populateUI(); // fetch everything again from the DB
            }

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void populateUI() {
        try {
            StageService service = new StageService();
            List<Stage> lstdata = service.getAllStages();

            stageListUI.setListData( lstdata.toArray() );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void updateClick() {
        try{
            StageService service = new StageService();
            // Use setters
            Stage s = (Stage) stageListUI.getSelectedValue();

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StageCrudDialog dialog = new StageCrudDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

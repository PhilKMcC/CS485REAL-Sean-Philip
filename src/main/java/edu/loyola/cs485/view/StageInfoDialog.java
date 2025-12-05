package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.StageService;
import edu.loyola.cs485.model.entity.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StageInfoDialog extends JDialog {


    private JPanel ContentPane;
    private JPasswordField txtID;
    private JTextField txtName;
    private JTextField txtSize;
    private JTextField txtLayout;
    private JButton enterButton;
    private JButton cancelButton;




    public StageInfoDialog() {
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public void onEnter(){

        StageService service = new StageService();
        String name = txtName.getText();
        String size = txtSize.getText();
        String layout = txtLayout.getText();

        try {
            service.createStage(name,size,layout);
            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void onCancel() {
        dispose(); // dispose method from the superclass JDialog, closes the current dialog
    }

    public static void main(String[] args) {
        StageInfoDialog dialog = new StageInfoDialog();
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }

}

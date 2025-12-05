package edu.loyola.cs485.view;

import edu.loyola.cs485.controller.StageService;
import edu.loyola.cs485.model.entity.Stage;

import javax.swing.*;
import java.awt.event.*;

public class StageEditDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameField;
    private JTextField sizeField;
    private JTextField layoutField;
    private JTextField idField;

    public StageEditDialog(Stage s) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        idField.setText(String.valueOf(s.getID()));
        nameField.setText(s.getName());
        sizeField.setText(s.getSize());
        layoutField.setText(s.getLayout());

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
    }

    private void onOK() {
        StageService service = new StageService();
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String size = sizeField.getText();
        String layout = layoutField.getText();

        try {
            service.updateStage(id,name,size,layout);
            dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        //StageEditDialog dialog = new StageEditDialog();
        //dialog.pack();
        //dialog.setVisible(true);
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class newPlayerForm extends JPanel {
    private JTextField field = new JTextField(10);
    private JButton okButton = new JButton("OK");

    public newPlayerForm() {
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButtonAction();
            }
        });

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                okButtonAction();
            }
        });

        add(field);
        add(okButton);
    }

    // to allow outside classes to get the text held by the JTextField
    public String getFieldText() {
        return field.getText();
    }

    // This button's action is simply to dispose of the JDialog.
    private void okButtonAction() {
        // win is here the JDialog that holds this JPanel, but it could be a JFrame or
        // any other top-level container that is holding this JPanel
        Window win = SwingUtilities.getWindowAncestor(this);
        if (win != null) {
            win.dispose();
        }
    }
}
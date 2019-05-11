package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PanelMain extends GeneralPanel {

    private JButton buttonSignIn;

    public PanelMain() {
        initComponents();
    }

    private void initComponents() {
        JButton buttonSignUp = new JButton("Sign Up");
        buttonSignIn = new JButton("Sign In");

// -----------------------
// Label
// -----------------------
        labelAccess.setText("Sign In | Sign Up");

// -----------------------
// Sign In
// -----------------------
        Font buttonFont = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
        Color buttonColor = new Color(65280);
        Color buttonBackgroundColor = new Color(205);
        buttonSignIn.setFont(buttonFont);
        buttonSignIn.setForeground(buttonColor);
        buttonSignIn.setBackground(buttonBackgroundColor);
        buttonSignIn.addActionListener(this);

        c.gridwidth = 1;
        c.ipadx = 32;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;

        gridBagLayout.setConstraints(buttonSignIn, c);
        this.add(buttonSignIn);

// -----------------------
// Sign Up
// -----------------------
        buttonSignUp.setFont(buttonFont);
        buttonSignUp.setForeground(buttonColor);
        buttonSignUp.setBackground(buttonBackgroundColor);
        buttonSignUp.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;

        gridBagLayout.setConstraints(buttonSignUp, c);
        this.add(buttonSignUp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSignIn) {
            cardLayout.show(clMain, "SignIn");
        } else {
            cardLayout.show(clMain, "SignUp");
        }
    }
}

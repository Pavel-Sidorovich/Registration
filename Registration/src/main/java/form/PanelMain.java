package form;

import javax.swing.*;
import java.awt.*;

class PanelMain {
    void createPanel(JPanel SignIn, JButton buttonSignIn, JButton buttonSignUp) {

        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();
        SignIn.setLayout(gridBagLayout);

// -----------------------
// Label
// -----------------------
        JLabel jLabel = new JLabel("Sign In | Sign Up", SwingConstants.CENTER);
        c.gridwidth = 2;

        c.insets = new Insets(10, 10, 10, 10);
        jLabel.setBackground(new Color(-12508404));
        Font panelMainFont = new Font("Algerian", Font.BOLD | Font.ITALIC, 30);
        jLabel.setFont(panelMainFont);
        jLabel.setForeground(new Color(-12032069));
        SignIn.add(jLabel, c);

// -----------------------
// Sign In
// -----------------------
        Font buttonFont = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
        Color buttonColor = new Color(65280);
        Color buttonBackgroundColor = new Color(205);
        buttonSignIn.setFont(buttonFont);
        buttonSignIn.setForeground(buttonColor);
        buttonSignIn.setBackground(buttonBackgroundColor);

        c.gridwidth = 1;
        c.ipadx = 32;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;

        gridBagLayout.setConstraints(buttonSignIn, c);
        SignIn.add(buttonSignIn);

// -----------------------
// Sign Up
// -----------------------
        buttonSignUp.setFont(buttonFont);
        buttonSignUp.setForeground(buttonColor);
        buttonSignUp.setBackground(buttonBackgroundColor);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;

        gridBagLayout.setConstraints(buttonSignUp, c);
        SignIn.add(buttonSignUp);
    }

}

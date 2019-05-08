package form;

import javax.swing.*;
import java.awt.*;

class PanelSignIn {
    private JTextField SignInName;
    private JPasswordField SignInPassword;

    JTextField getSignInName() {
        return SignInName;
    }

    JPasswordField getSignInPassword() {
        return SignInPassword;
    }

    void createPanel(JPanel SignIn, JButton signInToUp, JButton buttonEnter) {

        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();
        SignIn.setLayout(gridBagLayout);

// -----------------------
// Label
// -----------------------
        JLabel jLabel = new JLabel("Sign In", SwingConstants.CENTER);
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        Font fontSIn = new Font("Algerian", Font.BOLD | Font.ITALIC, 30);
        jLabel.setFont(fontSIn);
        jLabel.setForeground(new Color(-12032069));
        SignIn.add(jLabel, c);
// -----------------------
// First name
// -----------------------
        Font fontSignIn = new Font("Arial", Font.BOLD | Font.ITALIC, 24);

        SignInName = new JTextField(15);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        gridBagLayout.setConstraints(SignInName, c);
        SignIn.add(SignInName);
        JLabel SignInLabelName = new JLabel("Username");

        c.gridx = 1;
        c.gridy = 1;
        SignInLabelName.setFont(fontSignIn);

        gridBagLayout.setConstraints(SignInLabelName, c);
        SignIn.add(SignInLabelName);

// -----------------------
// OK
// -----------------------
        c.ipadx = 32;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;

        Font buttonFont = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
        Color buttonColor = new Color(16711935);
        Color buttonBackgroundColor = new Color(3050327);
        signInToUp.setFont(buttonFont);
        signInToUp.setForeground(buttonColor);
        signInToUp.setBackground(buttonBackgroundColor);

        gridBagLayout.setConstraints(signInToUp, c);
        SignIn.add(signInToUp);

// -----------------------
// Middle name
// -----------------------
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        SignInPassword = new JPasswordField(15);

        gridBagLayout.setConstraints(SignInPassword, c);
        SignIn.add(SignInPassword);

        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel SignInLabelPassword = new JLabel("Password");
        SignInLabelPassword.setFont(fontSignIn);

        gridBagLayout.setConstraints(SignInLabelPassword, c);
        SignIn.add(SignInLabelPassword);

// -----------------------
// Cancel
// -----------------------
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;

        buttonEnter.setFont(buttonFont);
        buttonEnter.setForeground(buttonColor);
        buttonEnter.setBackground(buttonBackgroundColor);

        gridBagLayout.setConstraints(buttonEnter, c);
        SignIn.add(buttonEnter);
    }
}

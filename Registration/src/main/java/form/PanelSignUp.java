package form;

import javax.swing.*;
import java.awt.*;

class PanelSignUp {
    private JTextField signUpName;
    private JPasswordField signUpPassword;

    JTextField getSignUpName() {
        return signUpName;
    }

    JPasswordField getSignUpPassword() {
        return signUpPassword;
    }

    void createPanel(JPanel signUp, JButton signUpToIn, JButton buttonAddUser) {

        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();
        signUp.setLayout(gridBagLayout);

// -----------------------
// Label
// -----------------------

        JLabel jLabel = new JLabel("Sign Up", SwingConstants.CENTER);
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        Font label1Font = new Font("Algerian", Font.BOLD | Font.ITALIC, 30);
        jLabel.setFont(label1Font);
        jLabel.setForeground(new Color(-12032069));
        signUp.add(jLabel, c);
// -----------------------
// First name
// -----------------------
        Font fontSignUp = new Font("Arial", Font.BOLD | Font.ITALIC, 24);

        signUpName = new JTextField(15);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;

        gridBagLayout.setConstraints(signUpName, c);
        signUp.add(signUpName);
        JLabel signUpLabelName = new JLabel("Email");

        c.gridx = 1;
        c.gridy = 1;
        signUpLabelName.setFont(fontSignUp);

        gridBagLayout.setConstraints(signUpLabelName, c);
        signUp.add(signUpLabelName);

// -----------------------
// OK
// -----------------------
        c.ipadx = 32;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;

        Font buttonFont = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
        Color buttonColor = new Color(9109504);
        Color buttonBackgroundColor = new Color(65535);
        signUpToIn.setFont(buttonFont);
        signUpToIn.setBackground(buttonBackgroundColor);
        signUpToIn.setForeground(buttonColor);
        gridBagLayout.setConstraints(signUpToIn, c);
        signUp.add(signUpToIn);

// -----------------------
// "Password"
// -----------------------
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        signUpPassword = new JPasswordField(15);

        gridBagLayout.setConstraints(signUpPassword, c);
        signUp.add(signUpPassword);

        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel signUpLabelPassword = new JLabel("Password");
        signUpLabelPassword.setFont(fontSignUp);

        gridBagLayout.setConstraints(signUpLabelPassword, c);
        signUp.add(signUpLabelPassword);

// -----------------------
// Cancel
// -----------------------
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        buttonAddUser.setFont(buttonFont);
        buttonAddUser.setForeground(buttonColor);
        buttonAddUser.setBackground(buttonBackgroundColor);
        gridBagLayout.setConstraints(buttonAddUser, c);
        signUp.add(buttonAddUser);

    }
}

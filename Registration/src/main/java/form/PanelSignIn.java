package form;

import detection.DetectionSpecialChar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PanelSignIn extends GeneralPanel {
    private JTextField signInName;
    private JPasswordField signInPassword;
    private JButton buttonEnter;

    public PanelSignIn() {
        initComponents();
    }

    void initComponents() {
        JButton signInToUp = new JButton("Sign Up");
        buttonEnter = new JButton("Enter to access");

// -----------------------
// Label
// -----------------------
        labelAccess.setText("Sign In");
// -----------------------
// First name
// -----------------------
        Font fontSignIn = new Font("Arial", Font.BOLD | Font.ITALIC, 24);

        signInName = new JTextField(15);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        gridBagLayout.setConstraints(signInName, c);
        this.add(signInName);
        JLabel SignInLabelName = new JLabel("Email");

        c.gridx = 1;
        c.gridy = 1;
        SignInLabelName.setFont(fontSignIn);

        gridBagLayout.setConstraints(SignInLabelName, c);
        this.add(SignInLabelName);

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
        signInToUp.addActionListener(this::actionPerformed);

        gridBagLayout.setConstraints(signInToUp, c);
        this.add(signInToUp);

// -----------------------
// Middle name
// -----------------------
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        signInPassword = new JPasswordField(15);

        gridBagLayout.setConstraints(signInPassword, c);
        this.add(signInPassword);

        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel SignInLabelPassword = new JLabel("Password");
        SignInLabelPassword.setFont(fontSignIn);

        gridBagLayout.setConstraints(SignInLabelPassword, c);
        this.add(SignInLabelPassword);

// -----------------------
// Cancel
// -----------------------
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;

        buttonEnter.setFont(buttonFont);
        buttonEnter.setForeground(buttonColor);
        buttonEnter.setBackground(buttonBackgroundColor);

        buttonEnter.addActionListener(this::actionPerformed);
        gridBagLayout.setConstraints(buttonEnter, c);
        this.add(buttonEnter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonEnter){
            getAccess();
            //cardLayout.show(clMain, "SignIn");
        } else {
            cardLayout.show(clMain, "SignUp");
        }
    }

    private void getAccess() {
        DetectionSpecialChar detectionSpecialChar = new DetectionSpecialChar();
        String tempName = signInName.getText();
        String tempPassword = new String(signInPassword.getPassword());
        if (detectionSpecialChar.isMail(tempName) || detectionSpecialChar.isPassword(tempPassword)) {
            try {
                if (my.isUser(tempName)) {
                    String pass = null;
                    pass = my.getUser(tempName);
                    if (pass.equals(tempPassword)) {
                        cardLayout.show(clMain, "Access");
                    } else {
                        JOptionPane.showMessageDialog(clMain, "Нет такого");
                    }
                } else {
                    JOptionPane.showMessageDialog(clMain, "Нет такого");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(clMain, "Repeat get");
        }
    }
}

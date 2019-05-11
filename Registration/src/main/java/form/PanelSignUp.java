package form;

import detection.DetectionSpecialChar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class PanelSignUp extends GeneralPanel {

    private JTextField signUpName;
    private JPasswordField signUpPassword;
    private JButton buttonAddUser;

    public PanelSignUp(){
        initComponents();
    }

    private void initComponents() {
        JButton signUpToIn = new JButton("Sign In");
        buttonAddUser = new JButton("Add User");

// -----------------------
// Label
// -----------------------
        labelAccess.setText("Sign Up");
// -----------------------
// First name
// -----------------------
        Font fontSignUp = new Font("Arial", Font.BOLD | Font.ITALIC, 24);

        signUpName = new JTextField(15);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;

        gridBagLayout.setConstraints(signUpName, c);
        this.add(signUpName);
        JLabel signUpLabelName = new JLabel("Email");

        c.gridx = 1;
        c.gridy = 1;
        signUpLabelName.setFont(fontSignUp);

        gridBagLayout.setConstraints(signUpLabelName, c);
        this.add(signUpLabelName);

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
        signUpToIn.addActionListener(this::actionPerformed);
        this.add(signUpToIn);

// -----------------------
// "Password"
// -----------------------
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        signUpPassword = new JPasswordField(15);

        gridBagLayout.setConstraints(signUpPassword, c);
        this.add(signUpPassword);

        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel signUpLabelPassword = new JLabel("Password");
        signUpLabelPassword.setFont(fontSignUp);

        gridBagLayout.setConstraints(signUpLabelPassword, c);
        this.add(signUpLabelPassword);

// -----------------------
// Cancel
// -----------------------
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        buttonAddUser.setFont(buttonFont);
        buttonAddUser.setForeground(buttonColor);
        buttonAddUser.setBackground(buttonBackgroundColor);
        buttonAddUser.addActionListener(this::actionPerformed);
        gridBagLayout.setConstraints(buttonAddUser, c);
        this.add(buttonAddUser);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAddUser){
            System.out.println("1");
            addFunction();
            //cardLayout.show(clMain, "SignIn");
        } else {
            System.out.println("2");
            cardLayout.show(clMain, "SignIn");
        }
    }

    private void addFunction() {
        DetectionSpecialChar detectionSpecialChar = new DetectionSpecialChar();
        try {
            String tempName = signUpName.getText();
            String tempPassword = new String(signUpPassword.getPassword());
            if (detectionSpecialChar.isMail(tempName) && detectionSpecialChar.isPassword(tempPassword) && !my.isUser(tempName)) {
                my.addUser(tempName, tempPassword);
                cardLayout.show(clMain, "SignIn");
            } else {
                JOptionPane.showMessageDialog(clMain, "Repeat add");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelSQL extends GeneralPanel {
    private JPasswordField sqlPassword;
    private JButton sign;

    PanelSQL(){
        initComponents();
    }

    private void initComponents() {

// -----------------------
// Label
// -----------------------
        labelAccess.setText("Password freesqldatabase");

// -----------------------
// "Password"
// -----------------------
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        sqlPassword = new JPasswordField(15);

        gridBagLayout.setConstraints(sqlPassword, c);
        this.add(sqlPassword);


// -----------------------
// Sign In
// -----------------------
        sign = new JButton("Sign In");
        Font buttonFont = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
        Color buttonColor = new Color(65280);
        Color buttonBackgroundColor = new Color(205);
        sign.setFont(buttonFont);
        sign.setForeground(buttonColor);
        sign.addActionListener(this);
        sign.setBackground(buttonBackgroundColor);


        c.ipadx = 32;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;

        gridBagLayout.setConstraints(sign, c);
        this.add(sign);

        sign.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        my.setUserPassword(new String(sqlPassword.getPassword()));
        System.out.println(sqlPassword.getPassword());
        cardLayout.show(clMain, "Form");
    }
}

package form;

import javax.swing.*;
import java.awt.*;

public class PanelSQL {
    private JPasswordField sqlPassword;

    void createPanel(JPanel SqlPanel, JButton buttonSignIn) {

        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();
        SqlPanel.setLayout(gridBagLayout);

// -----------------------
// Label
// -----------------------
        JLabel jLabel = new JLabel("Password freesqldatabase", SwingConstants.CENTER);
        //c.gridwidth = 2;

        c.insets = new Insets(10, 10, 10, 10);
        jLabel.setBackground(new Color(-12508404));
        Font panelMainFont = new Font("Algerian", Font.BOLD | Font.ITALIC, 30);
        jLabel.setFont(panelMainFont);
        jLabel.setForeground(new Color(-12032069));
        SqlPanel.add(jLabel, c);

        // -----------------------
// "Password"
// -----------------------
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        sqlPassword = new JPasswordField(15);

        gridBagLayout.setConstraints(sqlPassword, c);
        SqlPanel.add(sqlPassword);


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
        SqlPanel.add(buttonSignIn);

    }

    public JPasswordField getSqlPassword() {
        return sqlPassword;
    }
}

package form;

import javax.swing.*;
import java.awt.*;

class PanelAccess {
    void createPanel(JPanel access) {

        GridBagConstraints c = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();
        access.setLayout(gridBagLayout);

        JLabel labelAccess = new JLabel("Access is given!!! Congratulations!!!", SwingConstants.CENTER);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        Font labelAccessFont = new Font("Arial", Font.BOLD | Font.ITALIC, 26);
        if (labelAccessFont != null)
            labelAccess.setFont(labelAccessFont);
        labelAccess.setForeground(new Color(-12032069));

        gridBagLayout.setConstraints(labelAccess, c);
        access.add(labelAccess);
    }
}

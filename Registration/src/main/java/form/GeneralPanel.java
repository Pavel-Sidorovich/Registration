package form;

import jdbc.mySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GeneralPanel extends JPanel implements ActionListener {
    static JPanel clMain;
    static mySQL my;
    final JFrame jFrame = new JFrame("Application");
    static CardLayout cardLayout;
    GridBagConstraints c;
    GridBagLayout gridBagLayout;
    JLabel labelAccess;

    GeneralPanel(){
        initComponents();
    }

    private void initComponents(){
        cardLayout = new CardLayout();
        clMain = new JPanel();
        my = new mySQL();

        labelAccess = new JLabel("", SwingConstants.CENTER);

        c = new GridBagConstraints();
        gridBagLayout = new GridBagLayout();

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        Font labelAccessFont = new Font("Arial", Font.BOLD | Font.ITALIC, 26);
        labelAccess.setFont(labelAccessFont);
        labelAccess.setForeground(new Color(-12032069));

        gridBagLayout.setConstraints(labelAccess, c);
        this.add(labelAccess);


        this.setLayout(gridBagLayout);


        this.setBackground(Color.ORANGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package form;

import jdbc.mySQL;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private JPanel clMain = new JPanel();
    private JPanel panelMain;
    private JButton buttonSignIn;
    private JButton buttonSignUp;
    private JButton signInToUp;
    private JTextField signUpName;
    private JPasswordField signUpPassword;
    private JButton buttonAddUser;
    private JPanel signUp;
    private JPanel signIn;
    private JButton signUpToIn;
    private JTextField signInName;
    private JPasswordField signInPassword;
    private JButton buttonEnter;
    private JPanel access;

    private JFrame jFrame = new JFrame("Application");

    private CardLayout cardLayout = new CardLayout();

    private  Form() {
        clMain.setLayout(new CardLayout(0, 0));

        createSignUp();
        createSignIn();
        createMain();
        createAccess();

        mySQL my = new mySQL();


        clMain.setLayout(cardLayout);

        clMain.add(signUp, "SignUp");
        clMain.add(signIn, "SignIn");
        clMain.add(panelMain, "Form");
        clMain.add(access, "Access");

        cardLayout.show(clMain, "Form");


        jFrame.add(clMain);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        buttonSignIn.addActionListener(e ->
                cardLayout.show(clMain, "SignIn"));

        buttonSignUp.addActionListener(e ->
                cardLayout.show(clMain, "SignUp"));

        signUpToIn.addActionListener(e ->
                cardLayout.show(clMain, "SignIn"));

        signInToUp.addActionListener(e ->
                cardLayout.show(clMain, "SignUp"));

        buttonAddUser.addActionListener(e -> {
            try {
                if (signUpName.getText().equals("") || new String(signUpPassword.getPassword()).equals("") || my.isUser(signUpName.getText())) {
                    JOptionPane.showMessageDialog(clMain, "Repeat");
                } else {
                    //my.addUser(signUpName.getText(), new String(signUpPassword.getPassword()));

                    cardLayout.show(clMain, "SignIn");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        buttonEnter.addActionListener(e -> {
            if (signInName.getText().equals("") || new String(signInPassword.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(clMain, "Repeat");
            } else {
                try {
                    if (!my.isUser(signInName.getText())) {
                        JOptionPane.showMessageDialog(clMain, "Нет такого");
                    } else {
                        String pass = null;
                        pass = my.getUser(signInName.getText());
                        if (pass.equals(new String(signInPassword.getPassword()))) {
                            cardLayout.show(clMain, "Access");
                        } else {
                            JOptionPane.showMessageDialog(panelMain, "Нет такого");
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void createSignUp() {
        signUp = new JPanel();
        signUp.setBackground(Color.ORANGE);

        signUpToIn = new JButton("Sign In");
        buttonAddUser = new JButton("Add User");

        GridBagLayout gridBagLayout = new GridBagLayout();
        signUp.setLayout(gridBagLayout);
        PanelSignUp panelSignUp = new PanelSignUp();
        panelSignUp.createPanel(signUp, signUpToIn, buttonAddUser);

        signUpName = panelSignUp.getSignUpName();
        signUpPassword = panelSignUp.getSignUpPassword();
    }

    private void createSignIn() {
        signIn = new JPanel();
        signIn.setBackground(Color.ORANGE);

        signInToUp = new JButton("Sign Up");
        buttonEnter = new JButton("Enter to access");

        GridBagLayout gridBagLayout = new GridBagLayout();
        signIn.setLayout(gridBagLayout);
        PanelSignIn panelSignIn = new PanelSignIn();
        panelSignIn.createPanel(signIn, signInToUp, buttonEnter);

        signInName = panelSignIn.getSignInName();
        signInPassword = panelSignIn.getSignInPassword();
    }

    private void createMain() {
        panelMain = new JPanel();
        panelMain.setBackground(Color.ORANGE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        panelMain.setLayout(gridBagLayout);

        buttonSignUp = new JButton("Sign Up");
        buttonSignIn = new JButton("Sign In");

        new PanelMain().createPanel(panelMain, buttonSignIn, buttonSignUp);
    }

    private void createAccess() {
        access = new JPanel();
        access.setBackground(Color.ORANGE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        access.setLayout(gridBagLayout);

        new PanelAccess().createPanel(access);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Form());
    }
}
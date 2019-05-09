package form;

import detection.DetectionSpecialChar;
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

    private Form() {
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

        buttonAddUser.addActionListener(e ->
                addFunction(my));

        buttonEnter.addActionListener(e ->
                getAccess(my));
    }

    DetectionSpecialChar detectionSpecialChar = new DetectionSpecialChar();

    private void getAccess(mySQL my) {
        String tempName = signInName.getText();
        String tempPassword = new String(signInPassword.getPassword());
        if (detectionSpecialChar.isMail(tempName) || detectionSpecialChar.isPassword(tempPassword)) {
            JOptionPane.showMessageDialog(clMain, "Repeat");
        } else {
            try {
                if (!my.isUser(tempName)) {
                    JOptionPane.showMessageDialog(clMain, "Нет такого");
                } else {
                    String pass = null;
                    pass = my.getUser(tempName);
                    if (pass.equals(tempPassword)) {
                        cardLayout.show(clMain, "Access");
                    } else {
                        JOptionPane.showMessageDialog(panelMain, "Нет такого");
                    }
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addFunction(mySQL my) {
        try {
            String tempName = signUpName.getText();
            String tempPassword = new String(signUpPassword.getPassword());
            if (detectionSpecialChar.isMail(tempName) || detectionSpecialChar.isPassword(tempPassword) || my.isUser(tempName)) {
                JOptionPane.showMessageDialog(clMain, "Repeat");
            } else {
                my.addUser(tempName, tempPassword);
                cardLayout.show(clMain, "SignIn");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
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
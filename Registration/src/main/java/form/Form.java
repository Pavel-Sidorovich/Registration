package form;

import javax.swing.*;


public class Form extends GeneralPanel {


    private void createForm() {

        JPanel panelSQL = new PanelSQL();
        JPanel panelMain = new PanelMain();
        JPanel signUp = new PanelSignUp();
        JPanel signIn = new PanelSignIn();
        JPanel access = new PanelAccess();

        clMain.setLayout(cardLayout);


        clMain.add(signUp, "SignUp");
        clMain.add(signIn, "SignIn");
        clMain.add(panelMain, "Form");
        clMain.add(access, "Access");
        clMain.add(panelSQL, "SQL");

        cardLayout.show(clMain, "SQL");


        jFrame.add(clMain);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Form().createForm());
    }
}
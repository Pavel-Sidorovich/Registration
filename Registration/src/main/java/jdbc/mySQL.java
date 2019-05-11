package jdbc;

import java.sql.*;

public class mySQL {
    private String userName;// = "root"; //"1"
    private static String userPassword;//= "1111";
    private String connectionURL;// = "jdbc:mysql://localhost:3306/mymap?useUnicode=true&serverTimezone=UTC";//Важно юзать то, что после ?. Иначе будет ошибка.

    public mySQL() {
//        this.userName = "root";
//        this.userPassword = "1111";
//        this.connectionURL = "jdbc:mysql://localhost:3306/mymap?useUnicode=true&serverTimezone=UTC";
        userName = "sql7291253";
        userPassword = "";
        connectionURL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7291253";
    }

//    public mySQL(String userPassword) {
//        this.userName = "sql7291253";
//        this.userPassword = userPassword;
//        this.connectionURL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7291253";
//    }

    public void addUser(String email, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()) {
            //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
            statement.executeUpdate("INSERT into mapdb values ('" + email + "','" + password + "');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUser(String email) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()) {
            //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
            //System.out.println("Подключил");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mapdb WHERE email='" + email + "';");
            while (resultSet.next()) {
                return resultSet.getString(2);
            }
        } catch (SQLException e) {
            //System.out.println("Облом");
            e.printStackTrace();
        }
        return "Error";
    }

    public Boolean isUser(String email) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()) {
            //System.out.println("Ok");
            //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mapdb WHERE email='" + email + "';");
            return resultSet.next();
        } catch (SQLException e) {
            //System.out.println("Bad");
            e.printStackTrace();
        }
        return false;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}

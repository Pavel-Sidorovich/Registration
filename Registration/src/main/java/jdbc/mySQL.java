package jdbc;

import java.sql.*;

public class mySQL {
    private String userName;// = "root"; //"1"
    private String userPassword;//= "1111";
    private String connectionURL;// = "jdbc:mysql://localhost:3306/mymap?useUnicode=true&serverTimezone=UTC";//Важно юзать то, что после ?. Иначе будет ошибка.

    public mySQL() {
        this.userName = "root";
        this.userPassword = "1111";
        this.connectionURL = "jdbc:mysql://localhost:3306/mymap?useUnicode=true&serverTimezone=UTC";
    }

    public mySQL(String userName, String userPassword, String connectionURL) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.connectionURL = connectionURL;
    }

    public void  addUser (String email, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()){
            //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
            statement.executeUpdate("INSERT into mapDB values ('" + email + "','" + password + "');");
            System.out.println("We're connected");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUser(String email) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()){
            //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mapDB WHERE email='"+ email + "';");
            while (resultSet.next()){
                return resultSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Error";
    }

    public Boolean isUser(String email) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, userPassword);
             Statement statement = connection.createStatement()){
            //statement.executeUpdate(" create table mapDB (email varchar(50) NOT NULL,password varchar(15) NOT NULL,PRIMARY KEY (email));");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mapDB WHERE email='"+ email + "';");
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

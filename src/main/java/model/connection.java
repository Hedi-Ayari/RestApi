package model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_produit";

    public static connection getConnection() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            return (connection) DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_produit";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public CategorieDAO() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void createCategorie(categorie categorie) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO categories (lib) VALUES (?)")) {
            statement.setString(1, categorie.getLib());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<categorie> getAllCategories() {
        List<categorie> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM categories")) {
            while (resultSet.next()) {
                categorie categorie = new categorie();
                categorie.setCode(resultSet.getInt("id"));
                categorie.setLib(resultSet.getString("lib"));
                categories.add(categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public categorie getCategorieById(int id) {
        // Implement code to retrieve a category by ID
        return null;
    }

    public void updateCategorie(categorie categorie) {
        // Implement code to update a category
    }

    public void deleteCategorie(int id) {
        // Implement code to delete a category by ID
    }
}


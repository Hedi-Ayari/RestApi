package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_produit";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public ProductDAO() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Classpath: " + System.getProperty("java.class.path"));

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void createProduit(produit produit) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO produit (lib, prix, quantite, fkcategorie) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, produit.getLib());
            statement.setDouble(2, produit.getPrix());
            statement.setInt(3, produit.getQuantite());
            statement.setInt(4, produit.getFkcategorie());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<produit> getAllProduits() {
        List<produit> produits = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM produit")) {
            while (resultSet.next()) {
                produit produit = new produit();
                produit.setCode(resultSet.getInt("code"));
                produit.setLib(resultSet.getString("lib"));
                produit.setPrix(resultSet.getDouble("prix"));
                produit.setQuantite(resultSet.getInt("quantite"));
                produit.setFkcategorie(resultSet.getInt("fkcategorie"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public produit getProduitById(int id) {
        produit product = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit WHERE code = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = new produit();
                    product.setCode(resultSet.getInt("code"));
                    product.setLib(resultSet.getString("lib"));
                    product.setPrix(resultSet.getDouble("prix"));
                    product.setQuantite(resultSet.getInt("quantite"));
                    product.setFkcategorie(resultSet.getInt("fkcategorie"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void updateProduit(produit produit) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE produit SET lib = ?, prix = ?, quantite = ?, fkcategorie = ? WHERE code = ?")) {
            statement.setString(1, produit.getLib());
            statement.setDouble(2, produit.getPrix());
            statement.setInt(3, produit.getQuantite());
            statement.setInt(4, produit.getFkcategorie());
            statement.setInt(5, produit.getCode()); 
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduit(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM produit WHERE code = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

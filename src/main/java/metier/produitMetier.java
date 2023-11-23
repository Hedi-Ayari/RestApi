package metier;
import java.util.List;

import model.ProductDAO;
import model.produit; 
public class produitMetier {
    private ProductDAO productDAO;

    public produitMetier() {
        productDAO = new ProductDAO();
    }

    public void createProduit(produit produit) {
        productDAO.createProduit(produit);
    }

    public List<produit> getAllProduits() {
        return productDAO.getAllProduits();
    }

    public produit getProduitById(int id) {
        return productDAO.getProduitById(id);
    }

    public void updateProduit(produit produit) {
        productDAO.updateProduit(produit);
    }

    public void deleteProduit(int id) {
        productDAO.deleteProduit(id);
    }
}

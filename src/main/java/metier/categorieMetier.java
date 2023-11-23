package metier;
import java.util.List;

import model.CategorieDAO;
import model.categorie;

public class categorieMetier {
    private CategorieDAO categorieDAO;

    public categorieMetier() {
        categorieDAO = new CategorieDAO();
    }

    public void createCategorie(categorie categorie) {
        categorieDAO.createCategorie(categorie);
    }
    public List<categorie> getAllCategories() {
        return categorieDAO.getAllCategories();
    }

    public categorie getCategorieById(int id) {
        return categorieDAO.getCategorieById(id);
    }

    public void updateCategorie(categorie categorie) {
        categorieDAO.updateCategorie(categorie);
    }

    public void deleteCategorie(int id) {
        categorieDAO.deleteCategorie(id);
    }
}

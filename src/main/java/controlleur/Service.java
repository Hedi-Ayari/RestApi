package controlleur;

import metier.categorieMetier;
import metier.produitMetier;
import model.categorie;
import model.produit;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Service {
    private produitMetier produitMetier;
    private categorieMetier categorieMetier;

    public Service() {
        produitMetier = new produitMetier();
        categorieMetier = new categorieMetier();
    }

    @POST
    @Path("/createProduit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduit(produit produit) {
        produitMetier.createProduit(produit);
    }

    @GET
    @Path("/getAllProduits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<produit> getAllProduits() {
    	
        return produitMetier.getAllProduits();
    }

    @GET
    @Path("/getProduitById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public produit getProduitById(@PathParam("id") int id) {
        return produitMetier.getProduitById(id);
    }

    @PUT
    @Path("/updateProduit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduit(produit produit) {
        produitMetier.updateProduit(produit);
    }

    @DELETE
    @Path("/deleteProduit/{id}")
    public void deleteProduit(@PathParam("id") int id) {
        produitMetier.deleteProduit(id);
    }

    @POST
    @Path("/createCategorie")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCategorie(categorie categorie) {
        categorieMetier.createCategorie(categorie);
    }

    @GET
    @Path("/getAllCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<categorie> getAllCategories() {
        return categorieMetier.getAllCategories();
    }

    @GET
    @Path("/getCategorieById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public categorie getCategorieById(@PathParam("id") int id) {
        return categorieMetier.getCategorieById(id);
    }

    @PUT
    @Path("/updateCategorie")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCategorie(categorie categorie) {
        categorieMetier.updateCategorie(categorie);
    }

    @DELETE
    @Path("/deleteCategorie/{id}")
    public void deleteCategorie(@PathParam("id") int id) {
        categorieMetier.deleteCategorie(id);
    }
}

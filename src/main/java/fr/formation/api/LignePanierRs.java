package fr.formation.api;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.formation.bean.LignePanier;
import fr.formation.bean.Panier;
import fr.formation.bll.LignePanierManager;
import fr.formation.bll.PanierManager;


@Path("/lignepaniers")
@Singleton
public class LignePanierRs {
	
	private LignePanierManager LignePanierManager;
	
	public LignePanierRs() {
		LignePanierManager = new LignePanierManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<LignePanier> getLignePaniers(){
		return LignePanierManager.listeLignePaniers();
	}
	

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public LignePanier getLignePanier(@PathParam("id") int id) {
		try {
			LignePanier f = LignePanierManager.trouverLignePanier(id);
			if (f != null)
				return f;
			else
				throw new WebApplicationException(Response.Status.CONFLICT);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postLignePanier(LignePanier f) {
		try {
			LignePanierManager.ajoutLignePanier(f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removeLignePanier(@PathParam("id") int id) {
		try {
			LignePanierManager.supprimerLignePanier(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putLignePanier(LignePanier f, @PathParam("id") int id) {
		try {
			f.setId(id);
			LignePanierManager.modifierLignePanier(f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
}

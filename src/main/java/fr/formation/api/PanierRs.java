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

import fr.formation.bean.Panier;
import fr.formation.bll.PanierManager;


@Path("/paniers")
@Singleton
public class PanierRs {
	
	private PanierManager PanierManager;
	
	public PanierRs() {
		PanierManager = new PanierManager();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Panier> getPaniers(){
		return PanierManager.listePaniers();
	}
	

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Panier getPanier(@PathParam("id") int id) {
		try {
			Panier f = PanierManager.trouverPanier(id);
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
	public void postPanier(Panier f) {
		try {
			PanierManager.ajoutPanier(f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removePanier(@PathParam("id") int id) {
		try {
			PanierManager.supprimerPanier(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putPanier(Panier f, @PathParam("id") int id) {
		try {
			f.setId(id);
			PanierManager.modifierPanier(f);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
}

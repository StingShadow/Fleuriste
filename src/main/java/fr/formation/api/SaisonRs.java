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

import fr.formation.bean.Saison;
import fr.formation.bean.Style;
import fr.formation.bll.SaisonManager;
import fr.formation.bll.StyleManager;

@Path("/saisons")
@Singleton
public class SaisonRs {
	
	private SaisonManager saisonmanager;
	
	public SaisonRs() {
		saisonmanager = new SaisonManager();
	}
	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Saison> getSaison(){
		return saisonmanager.listeSaisons();
	}
	
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postSaison(Saison s) {
		try {
			System.out.println("Ajout de " + s);
			saisonmanager.ajoutSaison(s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	

	@DELETE
	@Path("/{id}")
	public void removeSaison(@PathParam("id") int id) {
		try {
			saisonmanager.supprimerSaison(id);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putSasion(Saison s, @PathParam("id") int id) {
		try {
			s.setId(id);
			saisonmanager.modifierSaison(s);
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}
}

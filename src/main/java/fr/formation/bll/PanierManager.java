package fr.formation.bll;

import java.util.List;

import fr.formation.bean.Panier;
import fr.formation.bean.Plante;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.PanierDAO;
import fr.formation.dal.PlanteDAO;

public class PanierManager {

	PanierDAO dao;
	
	public PanierManager(){
		dao = DaoFactory.getPanierDAO();
	}
	
	public List<Panier> listePaniers(){
		return dao.findAll();
	}
	
	public Panier trouverPanier(int id){
		return dao.findById(id);
	}
	
	
	public void ajoutPanier(Panier f) throws Exception{
		if (f == null)
			throw new Exception("Plante inconnu");
		dao.add(f);
	}
	
	public void modifierPanier(Panier f) throws Exception{

		if (f == null )
			throw new Exception("Film pas correct");
		dao.update(f);
	}
	
	public void supprimerPanier(Panier f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerPanier(int id) throws Exception{
		dao.delete(trouverPanier(id));
	}

	public List<Panier> trier(String par) {
		List<Panier> liste = null;
		
		switch (par) {
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}

package fr.formation.bll;

import java.util.List;

import fr.formation.bean.LignePanier;
import fr.formation.bean.Panier;
import fr.formation.bean.Plante;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.LignePanierDAO;
import fr.formation.dal.PanierDAO;
import fr.formation.dal.PlanteDAO;

public class ArticleManager {

	LignePanierDAO dao;
	
	public ArticleManager(){
		dao = DaoFactory.getLignePanierDAO();
	}
	
	public List<LignePanier> listeLignePaniers(){
		return dao.findAll();
	}
	
	public LignePanier trouverLignePanier(int id){
		return dao.findById(id);
	}
	
	
	public void ajoutLignePanier(LignePanier f) throws Exception{
		if (f == null)
			throw new Exception("Ligne inconnu");
		dao.add(f);
	}
	
	public void modifierLignePanier(LignePanier f) throws Exception{

		if (f == null )
			throw new Exception("Ligne pas correct");
		dao.update(f);
	}
	
	public void supprimerLignePanier(LignePanier f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerLignePanier(int id) throws Exception{
		dao.delete(trouverLignePanier(id));
	}

	public List<LignePanier> trier(String par) {
		List<LignePanier> liste = null;
		
		switch (par) {
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}

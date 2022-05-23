package fr.formation.bll;

import java.util.List;




import fr.formation.bean.Plante;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.PlanteDAO;

public class PlanteManager {

	PlanteDAO dao;
	
	public PlanteManager(){
		dao = DaoFactory.getPlanteDAO();
	}
	
	public List<Plante> listePlantes(){
		return dao.findAll();
	}
	
	public Plante trouverPlante(int id){
		return dao.findById(id);
	}
	
	
	public void ajoutPlante(Plante f) throws Exception{
		if (f == null || f.getNom() == null || f.getNom().isBlank())
			throw new Exception("Plante inconnu");
		dao.add(f);
	}
	
	public void modifierPlante(Plante f) throws Exception{

		if (f == null || f.getNom() == null || f.getNom().isBlank())
			throw new Exception("Film pas correct");
		dao.update(f);
	}
	
	public void supprimerPlante(Plante f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerPlante(int id) throws Exception{
		dao.delete(trouverPlante(id));
	}

	public List<Plante> trier(String par) {
		List<Plante> liste = null;
		
		switch (par) {
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}

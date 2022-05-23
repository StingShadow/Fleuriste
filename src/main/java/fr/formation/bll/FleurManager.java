package fr.formation.bll;

import java.util.List;



import fr.formation.bean.Fleur;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.FleurDAO;

public class FleurManager {

	FleurDAO dao;
	
	public FleurManager(){
		dao = DaoFactory.getFleurDAO();
	}
	
	public List<Fleur> listeFleurs(){
		return dao.findAll();
	}
	
	public Fleur trouverFleur(int id){
		return dao.findById(id);
	}
	
	
	public void ajoutFleur(Fleur f) throws Exception{
		if (f == null || f.getNom() == null || f.getNom().isBlank())
			throw new Exception("Fleur inconnu");
		dao.add(f);
	}
	
	public void modifierFleur(Fleur f) throws Exception{

		if (f == null || f.getNom() == null || f.getNom().isBlank())
			throw new Exception("Fleur inconnu");
		dao.update(f);
	}
	
	public void supprimerFleur(Fleur f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerFleur(int id) throws Exception{
		dao.delete(trouverFleur(id));
	}

	public List<Fleur> trier(String par) {
		List<Fleur> liste = null;
		
		switch (par) {
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}

package fr.formation.bll;

import java.util.List;




import fr.formation.bean.Saison;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.SaisonDAO;
import fr.formation.exception.BeanException;


public class SaisonManager {

	private SaisonDAO dao;
	
	public SaisonManager(){
		dao = DaoFactory.getSaisonDAO();
	}
	
	public List<Saison> listeSaisons(){
		return dao.findAll();
	}
	
	
	public Saison trouverSaison(int id){
		return dao.findById(id);
	}

	public void ajoutSaison(Saison s) throws Exception{
		
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.add(s);
		else
			throw new BeanException("Le style doit posséder un libellé");
	}
	
	public void modifierSaison(Saison s) throws Exception{
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.update(s);
		else
			throw new BeanException("Le style doit posséder un libellé");
	}
	
	public void supprimerSaison(Saison s) throws Exception{
		dao.delete(s);
	}
	
	public void supprimerSaison(int id) throws Exception{
		Saison s = dao.findById(id);
		dao.delete(s);
	}
	
	public List<Saison> trier(String type){
		List<Saison> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}

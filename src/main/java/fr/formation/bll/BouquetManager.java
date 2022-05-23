package fr.formation.bll;

import java.util.List;


import fr.formation.bean.Bouquet;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.BouquetDAO;

public class BouquetManager {

	BouquetDAO dao;
	
	public BouquetManager(){
		dao = DaoFactory.getBouquetDAO();
	}
	
	public List<Bouquet> listeBouquets(){
		return dao.findAll();
	}
	
	public Bouquet trouverBouquet(int id){
		return dao.findById(id);
	}
	
	
	public void ajoutBouquet(Bouquet f) throws Exception{
		if (f == null || f.getNom() == null || f.getNom().isBlank() || f.getCouleur() == null || f.getInformations() == null || f.getQuantite() <= 0)
			throw new Exception("Bouquet inconnu");
		System.out.println(f);
		dao.add(f);
	}
	
	public void modifierBouquet(Bouquet f) throws Exception{

		if (f == null || f.getNom() == null || f.getNom().isBlank() || f.getCouleur() == null || f.getInformations() == null || f.getQuantite() <= 0)
			throw new Exception("Bouquet pas correct");
		dao.update(f);
	}
	
	public void supprimerBouquet(Bouquet f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerBouquet(int id) throws Exception{
		dao.delete(trouverBouquet(id));
	}

	public List<Bouquet> trier(String par) {
		List<Bouquet> liste = null;
		
		switch (par) {
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}

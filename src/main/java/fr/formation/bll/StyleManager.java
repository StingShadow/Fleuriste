package fr.formation.bll;

import java.util.List;



import fr.formation.bean.Style;
import fr.formation.dal.DaoFactory;
import fr.formation.dal.StyleDAO;
import fr.formation.exception.BeanException;


public class StyleManager {

	private StyleDAO dao;
	
	public StyleManager(){
		dao = DaoFactory.getStyleDAO();
	}
	
	public List<Style> listeStyles(){
		return dao.findAll();
	}
	
	
	public Style trouverStyle(int id){
		return dao.findById(id);
	}

	public void ajoutStyle(Style s) throws Exception{
		
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.add(s);
		else
			throw new BeanException("Le style doit posséder un libellé");
	}
	
	public void modifierStyle(Style s) throws Exception{
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.update(s);
		else
			throw new BeanException("Le style doit posséder un libellé");
	}
	
	public void supprimerStyle(Style s) throws Exception{
		dao.delete(s);
	}
	
	public void supprimerStyle(int id) throws Exception{
		Style s = dao.findById(id);
		dao.delete(s);
	}
	
	public List<Style> trier(String type){
		List<Style> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}

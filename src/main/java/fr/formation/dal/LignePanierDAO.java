package fr.formation.dal;

import java.util.List;


import fr.formation.bean.Bouquet;
import fr.formation.bean.LignePanier;
import fr.formation.bean.Panier;

public interface LignePanierDAO {

	public void add(LignePanier s) throws Exception;
	public void delete(LignePanier s) throws Exception;
	public  void update(LignePanier s) throws Exception;
	public LignePanier findById(int id);
	public  List<LignePanier> findAll();
}

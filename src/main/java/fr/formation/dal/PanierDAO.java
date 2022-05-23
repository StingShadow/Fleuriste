package fr.formation.dal;

import java.util.List;


import fr.formation.bean.Bouquet;
import fr.formation.bean.Panier;

public interface PanierDAO {

	public void add(Panier s) throws Exception;
	public void delete(Panier s) throws Exception;
	public  void update(Panier s) throws Exception;
	public Panier findById(int id);
	public  List<Panier> findAll();
}

package fr.formation.dal;

import java.util.List;


import fr.formation.bean.Bouquet;

public interface BouquetDAO {

	public void add(Bouquet s) throws Exception;
	public void delete(Bouquet s) throws Exception;
	public  void update(Bouquet s) throws Exception;
	public Bouquet findById(int id);
	public  List<Bouquet> findAll();
}

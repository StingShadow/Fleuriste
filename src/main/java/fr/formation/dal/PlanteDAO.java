package fr.formation.dal;

import java.util.List;


import fr.formation.bean.Plante;

public interface PlanteDAO {

	public void add(Plante s) throws Exception;
	public void delete(Plante s) throws Exception;
	public  void update(Plante s) throws Exception;
	public Plante findById(int id);
	public  List<Plante> findAll();
}

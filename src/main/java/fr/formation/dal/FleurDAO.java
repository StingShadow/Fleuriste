package fr.formation.dal;

import java.util.List;

import fr.formation.bean.Fleur;

public interface FleurDAO {

	public void add(Fleur s) throws Exception;
	public void delete(Fleur s) throws Exception;
	public  void update(Fleur s) throws Exception;
	public Fleur findById(int id);
	public  List<Fleur> findAll();
}

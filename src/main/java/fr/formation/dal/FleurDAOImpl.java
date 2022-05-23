package fr.formation.dal;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.bean.Fleur;

public class FleurDAOImpl implements FleurDAO {
	@Override
	public void add(Fleur s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	@Override
	public void delete(Fleur s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(Fleur.class, s.getId());
		et.begin();
		try {
			em.remove(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	@Override
	public  void update(Fleur s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}
	


	@Override
	public Fleur findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Fleur s = em.find(Fleur.class, id);
		em.close();
		return s;
	}
	
	@Override
	public  List<Fleur> findAll(){
		String req = "select Object(s) from Fleur s";
		EntityManager em = DAOUtil.getEntityManager();
		List<Fleur> liste = em
				.createQuery(req, Fleur.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}

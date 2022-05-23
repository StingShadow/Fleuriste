package fr.formation.dal;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.bean.Plante;

public class PlanteDAOImpl implements PlanteDAO {
	@Override
	public void add(Plante s) throws Exception{
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
	public void delete(Plante s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(Plante.class, s.getId());
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
	public  void update(Plante s) throws Exception{
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
	public Plante findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Plante s = em.find(Plante.class, id);
		em.close();
		return s;
	}
	
	@Override
	public  List<Plante> findAll(){
		String req = "select Object(p) from Plante p";
		EntityManager em = DAOUtil.getEntityManager();
		List<Plante> liste = em
				.createQuery(req, Plante.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}

package fr.formation.dal;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.bean.Bouquet;

public class BouquetDAOImpl implements BouquetDAO {
	@Override
	public void add(Bouquet s) throws Exception{
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
	public void delete(Bouquet s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(Bouquet.class, s.getId());
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
	public  void update(Bouquet s) throws Exception{
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
	public Bouquet findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Bouquet s = em.find(Bouquet.class, id);
		em.close();
		return s;
	}
	
	@Override
	public  List<Bouquet> findAll(){
		String req = "select Object(s) from Bouquet s";
		EntityManager em = DAOUtil.getEntityManager();
		List<Bouquet> liste = em
				.createQuery(req, Bouquet.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}

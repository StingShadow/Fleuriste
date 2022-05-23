package fr.formation.dal;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.bean.Bouquet;
import fr.formation.bean.Panier;

public class PanierDAOImpl implements PanierDAO {
	@Override
	public void add(Panier s) throws Exception{
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
	public void delete(Panier s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(Panier.class, s.getId());
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
	public  void update(Panier s) throws Exception{
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
	public Panier findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Panier s = em.find(Panier.class, id);
		em.close();
		return s;
	}
	
	@Override
	public  List<Panier> findAll(){
		String req = "select Object(s) from Panier s";
		EntityManager em = DAOUtil.getEntityManager();
		List<Panier> liste = em
				.createQuery(req, Panier.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}

package fr.formation.dal;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.formation.bean.Bouquet;
import fr.formation.bean.LignePanier;
import fr.formation.bean.Panier;

public class LignePanierDAOImpl implements LignePanierDAO {
	@Override
	public void add(LignePanier s) throws Exception{
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
	public void delete(LignePanier s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(LignePanier.class, s.getId());
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
	public  void update(LignePanier s) throws Exception{
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
	public LignePanier findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		LignePanier s = em.find(LignePanier.class, id);
		em.close();
		return s;
	}
	
	@Override
	public  List<LignePanier> findAll(){
		String req = "select Object(s) from LignePanier s";
		EntityManager em = DAOUtil.getEntityManager();
		List<LignePanier> liste = em
				.createQuery(req, LignePanier.class)
				.getResultList();
		em.close();
		
		return liste;
	}
}

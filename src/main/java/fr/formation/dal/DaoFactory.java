package fr.formation.dal;



public class DaoFactory {

	public static StyleDAO getStyleDAO(){
		return new StyleDAOImpl();
	}
	
	public static SaisonDAO getSaisonDAO() {
		return new SaisonDAOImpl(); 
	}
	
	public static BouquetDAO getBouquetDAO() {
		return new BouquetDAOImpl();
	}
	
	public static FleurDAO getFleurDAO() {
		return new FleurDAOImpl();
	}
	
	public static PlanteDAO getPlanteDAO() {
		return new PlanteDAOImpl();
	}
	
}

package fr.formation.bean;

import javax.persistence.Entity;

@Entity
public class Plante extends Article{

	public Plante() {
		super();
	}

	public Plante(String nom, double tarif, int quantite, String informations, String url) {
		super(nom, tarif, quantite, informations, url);
	}

}

package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Fleur extends Article {

	private String couleur;
	
	@ManyToOne
	private Saison saison;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Saison getSaison() {
		return saison;
	}

	public void setSaison(Saison saison) {
		this.saison = saison;
	}

	@Override
	public String toString() {
		return "Fleur [couleur=" + couleur + ", saison=" + saison + ", toString()=" + super.toString() + "]";
	}

	public Fleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fleur(String nom, double tarif, int quantite, String informations, String url) {
		super(nom, tarif, quantite, informations, url);
		// TODO Auto-generated constructor stub
	}
	

	
}

package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.formation.bean.Style;

@Entity
public class Bouquet extends Article {

	private String couleur;
	
	@ManyToOne
	private Saison saison;
	
	@ManyToOne
	private Style style;
	
	public Bouquet() {
		super();
	}

	public Bouquet(String nom, double tarif, int quantite, String informations, String url) {
		super(nom, tarif, quantite, informations, url);
	}

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

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Bouquet [couleur=" + couleur + ", saison=" + saison + ", style=" + style + ", toString()="
				+ super.toString() + "]";
	}


	
	
}

package fr.formation.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double tarif;
	private int quantite;
	private String informations;
	private String url;
	
	
	public Article() {
	}
	
	public Article(String nom, double tarif, int quantite, String informations, String url) {
		this.nom = nom;
		this.tarif = tarif;
		this.quantite = quantite;
		this.informations = informations;
		this.url = url;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getInformations() {
		return informations;
	}
	public void setInformations(String informations) {
		this.informations = informations;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", tarif=" + tarif + ", quantite=" + quantite + ", informations="
				+ informations + ", url=" + url + "]";
	}

}

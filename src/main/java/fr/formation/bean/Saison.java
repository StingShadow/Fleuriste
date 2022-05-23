package fr.formation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saison {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String libelle;
		
		
		public Saison() {
		}
		public Saison(String libelle) {
			this.libelle = libelle;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		@Override
		public String toString() {
			return "Style [id=" + id + ", libelle=" + libelle + "]";
		}
		
		
	}



package personnages;

import personnages.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("Force invalide: " + force);
		}
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		if (force < 0) {
			throw new IllegalArgumentException("Force invalide: " + force);
		}
		int previousForce = force;
		force -= forceCoup;
		if (previousForce <= force) {
			throw new IllegalArgumentException(" la force d'un Romain a diminué: " 
					+ force);
		}
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
	}
	public static void main(String[] args) {
		Romain harry = new Romain("Harry", 12);
		harry.prendreParole();
		harry.parler("Je suis Potter !");
		harry.recevoirCoup(5);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
	}
}

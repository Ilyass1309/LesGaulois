package personnages;

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
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 : {
			System.out.println("Le soldat " + nom + " est déjà bien protégé!");
			break;
		}
		case 1:{
			if (equipement == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà " + equipement 
						+ " !");

			} else {
				equipe(equipement);
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
			}
			break;
		}
		case 0:{
			equipe(equipement);
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		}
	}
	private void equipe(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
	}
	
	public static void main(String[] args) {
		Romain harry = new Romain("Harry", 12);
		harry.prendreParole();
		harry.parler("Je suis Potter !");
		harry.recevoirCoup(5);
		harry.sEquiper(Equipement.CASQUE);
		harry.sEquiper(Equipement.CASQUE);
		harry.sEquiper(Equipement.BOUCLIER);
		harry.sEquiper(Equipement.CASQUE);
	}
}

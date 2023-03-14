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
	
//	public void recevoirCoup(int forceCoup) {
//		if (force < 0) {
//			throw new IllegalArgumentException("Force invalide: " + force);
//		}
//		int previousForce = force;
//		force -= forceCoup;
//		if (previousForce <= force) {
//			throw new IllegalArgumentException(" la force d'un Romain a diminué: " 
//					+ force);
//		}
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//	}
	
	public void sEquiper(Equipement equipement) {
		String soldat = "Le soldat ";
		switch (nbEquipement) {
		case 2 : {
			System.out.println(soldat + nom + " est déjà bien protégé!");
			break;
		}
		case 1:{
			if (equipement == equipements[0]) {
				System.out.println(soldat + nom + " possède déjà " + equipement 
						+ " !");

			} else {
				equipe(equipement);
				System.out.println(soldat + nom + " s'équipe avec un " + equipement + ".");
			}
			break;
		}
		case 0:{
			equipe(equipement);
			System.out.println(soldat + nom + " s'équipe avec un " + equipement + ".");
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// Precondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");	
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
					}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
		private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				} 
		}
			return equipementEjecte;
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

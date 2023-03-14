package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = effetPotion * forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion 
				+ " fois décuplée.");
	}
	
//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de" 
				+ romain.getNom());
		Equipement[] liste = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; liste != null && i < liste.length; i++,
		nbTrophees++) {
		this.trophees[nbTrophees] = liste[i];
		}
		}

	public static void main(String[] args) {
		Gaulois gertrude = new Gaulois("Gertrude", 8);
		System.out.println(gertrude.getNom());
		System.out.println(gertrude);
		gertrude.prendreParole();
		gertrude.parler("Je suis gertrude");
		Romain manu = new Romain("Manu", 10);
		gertrude.frapper(manu);
		gertrude.boirePotion(4);
	}
}

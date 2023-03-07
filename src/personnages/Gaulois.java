package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
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
	
	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = effetPotion * forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion 
				+ " fois décuplée.");
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
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

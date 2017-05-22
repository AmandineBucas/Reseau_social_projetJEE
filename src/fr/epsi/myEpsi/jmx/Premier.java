package fr.epsi.myEpsi.jmx;

public class Premier implements PremierMBean {

	private static String name = "PremierMBean";
	private int valeur = 100;
	
	/*** Getter et Setter ***/
	
	// Nom
	public String getName() {
		return name;
	}

	// Valeur
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	// Permet de rafraichir les données
	public void refresh() {
		
	}
}
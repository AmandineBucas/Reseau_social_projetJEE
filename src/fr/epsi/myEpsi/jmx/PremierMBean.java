package fr.epsi.myEpsi.jmx;

public interface PremierMBean {
	
	public String getName();
	public int getValeur();
	public void setValeur(int valeur);
	public void refresh();

}

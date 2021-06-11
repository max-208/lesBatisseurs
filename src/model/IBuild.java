package model;

/**
 * une interface qui représente les actions possible pour un build, y compris une machine
 */
public interface IBuild {

	/**
	 * retourne le nom du build
	 * @return le nom du build
	 */
	String getNom();

	/**
	 * retourne le gain en point de victoire de la machine
	 * @return le gain en point de victoire de la machine
	 */
	 int getGain();
	
	/**
	 * le build est il une machoine ?
	 * @return true si le build est une machine
	 */
	boolean getEstMachine();
	
	/**
	 * le build est il complet
	 * @return true si le build est complet
	 */
	boolean getEstComplet();
	
	/**
	 * retourne le cout en pierre du build
	 * @return le cout en pierre du build
	 */
	int getCoutPierre();
	
	/**
	 * retourne le cout en bois du build
	 * @return le cout en bois du build
	 */
	int getCoutBois();
	
	/**
	 * retourne le cout en savoir du build
	 * @return le cout en savoir du build
	 */
	int getCoutSavoir();
	
	/**
	 * retourne le cout en tuile du build
	 * @return le cout en tuile du build
	 */
	int getCoutTuile();
	
	/**
	 * retourne la quantite de pierre travaille sur le build
	 * @return la quantite de pierre travaille sur le build
	 */
	int getWorkedPierre();
	
	/**
	 * retourne la quantite de bois travaille sur le build
	 * @return la quantite de bois travaille sur le build
	 */
	int getWorkedBois();
	
	/**
	 * retourne la quantite de savoir travaille sur le build
	 * @return la quantite de savoir travaille sur le build
	 */
	int getWorkedSavoir();
	
	/**
	 * retourne la quantite de tuile travaille sur le build
	 * @return la quantite de tuile travaille sur le build
	 */
	int getWorkedTuile();

	/**
	 * ajoute un builder au chantier
	 * @param builder
	 */
	boolean addBuilder(IBuilder builder);

	/**
	 * verifie si le build est complet ou non
	 * @return true si le batiment est commplete
	 */
	boolean checkCompletion();

	/**
	 * enleve tout les builders du build
	 */
	void removeAllBuilders();

}
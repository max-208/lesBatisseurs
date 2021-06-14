package model;

/**
 * une interface qui représente les actions possible pour un builder, y compris une machine
 */
public interface IBuilder {

	/**
	 * le builder est il une machine ?
	 * @return true si le builder est une machine
	 */
	boolean getEstMachine();

	/**
	 * le builder est il occupé ?
	 * @return true si le builder est libre
	 */
	boolean getEstOccupe();

	/**
	 * retourne le prix en ecus pour envoyer le batisseur travailler
	 * @return le prix en ecus pour envoyer le batisseur travailler
	 */
	int getPrix();

	/**
	 * retourne la production en pierre du builder
	 * @return la production en pierre du builder
	 */
	int getProdPierre();

	/**
	 * retourne la production en bois du builder
	 * @return la production en bois du builder
	 */
	int getProdBois();

	/**
	 * retourne la production en savoir du builder
	 * @return la production en savoir du builder
	 */
	int getProdSavoir();

	/**
	 * retourne la production en tuile du builder
	 * @return la production en tuile du builder
	 */
	int getProdTuile();

	/**
	 * retourne le type du builder
	 * @return le type du builder
	 */
	BuilderType getType();

	/**
	 * definis si le builder est occupé ou non
	 * @param estOccupe le nouvel etat du builder
	 */
	void setEstOccupe(boolean estOccupe);

	/**
	 * recupere l'id unique de la carte
	 * @return l'id de la carte
	 */
	int getId();

}
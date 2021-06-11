package model;

import java.util.*;

/**
 * represente le joueur, ses cartes, ses ecus, point de victoires et point d'actions
 */
public class Player {

	/**
	 * les cartes du joueurs peuvent etre accédés a tout moment
	 */
	public Deck cards;
	/**
	 * le type du joueur, soit Human, Auto ou None
	 */
	private PlayerType type;
	/**
	 * le nombre d'ecus du joueur
	 */
	private int ecus;
	/**
	 * le nombre de point de victoire du joueur
	 */
	private int pointVictoire;
	/**
	 * le nombre d'actions restantes pour le joueur
	 */
	private int action;

	/**
	 * le constructeur de joueur, crées un nouveau joueur avec un deck vide, 10 ecus, 0 point de victoire, 0 point de mouvement
	 * @param type the type of the new player
	 */
	public Player(PlayerType type) {
		// TODO - implement Player.Player
		throw new UnsupportedOperationException();
	}

	/**
	 * retourne le nombre d'ecus du joueur
	 * @return le nombre d'ecus du joueur
	 */
	public int getEcus() {
		return this.ecus;
	}

	/**
	 * retourne le nombre de point de victoire du joueur
	 * @return le nombre de point de victoire du joueur
	 */
	public int getPointVictoire() {
		return this.pointVictoire;
	}

	/**
	 * retourne le nombre d'actions restante du joueur
	 * @return le nombre d'actions restante du joueur
	 */
	public int getAction() {
		return this.action;
	}

	/**
	 * retourne le type du joueur
	 * @return le type du joueur
	 */
	public PlayerType getType() {
		return this.type;
	}

	/**
	 * passes un tour et donne au joueur 3 actions
	 */
	public void nouveauTour() {
		// TODO - implement Player.nouveauTour
		throw new UnsupportedOperationException();
	}

	/**
	 * rends une arraylist contenant les batiments du joueur non en chantier, 4 batiments par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuild> afficherBatiment(int page) {
		// TODO - implement Player.afficherBatiment
		throw new UnsupportedOperationException();
	}

	/**
	 * rends une arraylist contenant les batiments du joueur en chantier et quels batiments sont complet ou non, 4 batiments par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuild> afficherchantiers(int page) {
		// TODO - implement Player.afficherchantiers
		throw new UnsupportedOperationException();
	}

	/**
	 * rends une arraylist contenant les ouvriers libres du joueur, 4 ouvriers par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuilder> afficherOuvriers(int page) {
		// TODO - implement Player.afficherOuvriers
		throw new UnsupportedOperationException();
	}

	/**
	 * ouvres un chantier dans un batiment
	 * @param build le batiment a transformer en chantier
	 * @return true si le chantier a pu etre construit, false si le batiment n'appartiens pas au joueur ou est deja un chantier ou est terminé
	 */
	public boolean ouvrirChantier(IBuild build) {
		// TODO - implement Player.ouvrirChantier
		throw new UnsupportedOperationException();
	}

	/**
	 * transforme les actions du joueur en ecus, 1 action = 1 ecus, 2 actions = 3 ecus, 3 actions = 6 ecus
	 * @param nbAction le nombre d'actions a dépenser
	 * @return true si la transaction a pu etre effectuee
	 */
	public boolean actionVersEcu(int nbAction) {
		// TODO - implement Player.actionVersEcu
		throw new UnsupportedOperationException();
	}

	/**
	 * transforme les ecus en actions, 5 ecus = 1 action
	 * @param nbAction nombre d'actions a acheter
	 * @return true si la transaction a pu etre effectuee
	 */
	public boolean ecuVersAction(int nbAction) {
		// TODO - implement Player.ecuVersAction
		throw new UnsupportedOperationException();
	}

	/**
	 * envoie un ouvrier travailler sur un chantier, coute 1 action au premier
	 * @param build le chantier
	 * @param builder l'ouvrier
	 * @return true si l'ouvrier a pu etre ajouté au chantier, false si le batiment n'est pas un chantier, l'ouvrier n'est pas libre ou bien pas assez d'actions
	 */
	public boolean envoyerTravailler(IBuild build, IBuilder builder) {
		// TODO - implement Player.envoyerTravailler
		throw new UnsupportedOperationException();
	}

}
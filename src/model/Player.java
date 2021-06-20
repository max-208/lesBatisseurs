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
		this.type = type;
		this.action = 0;
		this.ecus = 10;
		this.pointVictoire = 0;
		this.cards = new Deck();
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
		this.action = this.action + 3;
		this.cards.resetAllBuildPrices();
	}

	/**
	 * ouvres un chantier dans un batiment
	 * @param build le batiment a transformer en chantier
	 * @return true si le chantier a pu etre construit, false si le batiment n'appartiens pas au joueur ou est deja un chantier ou est terminé
	 */
	public boolean ouvrirChantier(IBuild build) {
		boolean ret = false;
		this.action = this.action - 1;
		if(this.cards.addBuild(build)){
			ret = build.demarrerChantier();
		}
		return ret;
	}

	/**
	 * ouvres un chantier dans un batiment
	 * @param build le batiment a transformer en chantier
	 * @return true si le chantier a pu etre construit, false si le batiment n'appartiens pas au joueur ou est deja un chantier ou est terminé
	 */
	public boolean recruterOuvrier(IBuilder builder) {
		this.action = this.action - 1;
		return this.cards.addBuilder(builder);
	}

	/**
	 * transforme les actions du joueur en ecus, 1 action = 1 ecus, 2 actions = 3 ecus, 3 actions = 6 ecus
	 * @param nbAction le nombre d'actions a dépenser
	 * @return true si la transaction a pu etre effectuee
	 */
	public boolean actionVersEcu(int nbAction) {
		boolean ret = false;
		if(nbAction == 1 && nbAction <= this.action){
			this.action = this.action -1;
			this.ecus = this.ecus + 1;
			ret = true;
		} else if(nbAction == 2 && nbAction <= this.action){
			this.action = this.action -2;
			this.ecus = this.ecus + 3;
			ret = true;
		} else if(nbAction == 3 && nbAction <= this.action){
			this.action = this.action -3;
			this.ecus = this.ecus + 6;
			ret = true;
		}
		return ret;
	}

	/**
	 * transforme les ecus en actions, 5 ecus = 1 action
	 * @param nbAction nombre d'actions a acheter
	 * @return true si la transaction a pu etre effectuee
	 */
	public boolean ecuVersAction(int nbAction) {
		boolean ret = false;
		if(nbAction * 5 <= this.ecus && nbAction>0){
			this.ecus = this.ecus - nbAction * 5;
			this.action = this.action + nbAction;
			ret = true;
		}
		return ret;
	}

	/**
	 * envoie un ouvrier travailler sur un chantier, coute 1 action au premier
	 * @param build le chantier
	 * @param builder l'ouvrier
	 * @return true si l'ouvrier a pu etre ajouté au chantier, false si le batiment n'est pas un chantier, l'ouvrier n'est pas libre ou bien pas assez d'actions
	 */
	public boolean envoyerTravailler(IBuild build, IBuilder builder) {
		boolean ret = false;
		if(build != null && builder != null){
			if(build.getCoutBatisseur()<= this.action && builder.getPrix() <= this.ecus){
				this.action = this.action - build.getCoutBatisseur();
				this.ecus = this.ecus - builder.getPrix();
				builder.setEstOccupe(true);
				ret = build.addBuilder(builder);
				if(build.getEstComplet()){
					this.pointVictoire = this.pointVictoire + build.getGain();
					this.ecus = this.ecus + build.getEcus();
					if(build.getEstMachine()){
						this.cards.addBuilder( (IBuilder) build);
					}
				}
			}
		}
		return ret;
	}

}
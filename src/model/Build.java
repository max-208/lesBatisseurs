package model;

import java.util.*;

/**
 * le build, peut etre construit et rapporte des points de victoire
 */
public class Build implements IBuild {

	/**
	 * la liste des builders en train de construire ce build
	 */
	private ArrayList<IBuilder> builders;
	/**
	 * le nom du build
	 */
	private String nom;
	/**
	 * le gain en point de victoire du build
	 */
	private int gain;
	/**
	 * le gain en ecus du build
	 */
	private int ecus;
	/**
	 * true si le build est une machine
	 */
	private boolean estMachine;
	/**
	 * true si le build est complet
	 */
	private boolean estComplet;
	/**
	 * true si le build est un chantier
	 */
	private boolean estChantier;
	/**
	 * le cout en pierre du build
	 */
	private int coutPierre;
	/**
	 * le cout en bois du build
	 */
	private int coutBois;
	/**
	 * le cout en savoir du build
	 */
	private int coutSavoir;
	/**
	 * le cout en tuile du build
	 */
	private int coutTuile;
	/**
	 * id de la carte
	 */
	private int id;
	/**
	 * le cout en point d'action pour ajouter un batisseur a ce chantier
	 */
	private int coutBatisseur;

	/**
	 * le constructeur de build, crées un nouveau build
	 * @param id l'id du build
	 * @param nom le nom du build
	 * @param ecus le gain en point de victoire du build
	 * @param gain le gain en point de victoire du build
	 * @param estMachine si le build est une machine
	 * @param coutPierre le cout en pierre du build
	 * @param coutBois le cout en bois du build
	 * @param coutSavoir le cout en savoir du build
	 * @param coutTuile le cout en tuile du build
	 */
	public Build(int id,String nom, int ecus, int gain, boolean estMachine, int coutPierre, int coutBois, int coutSavoir, int coutTuile) {
		this.id = id;
		this.nom = nom;
		this.ecus = ecus;
		this.gain = gain;
		this.estMachine = estMachine;
		this.estComplet = false;
		this.estChantier = false;
		this.coutBatisseur = 1;
		this.coutPierre = coutPierre;
		this.coutBois = coutBois;
		this.coutSavoir = coutSavoir;
		this.coutTuile = coutTuile;
		this.builders = new ArrayList<IBuilder>();
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getGain() {
		return this.gain;
	}

	@Override
	public boolean getEstMachine() {
		return this.estMachine;
	}

	@Override
	public boolean getEstComplet() {
		return this.estComplet;
	}

	@Override
	public boolean getEstChantier() {
		return this.estChantier;
	}

	@Override
	public boolean demarrerChantier() {
		boolean ret = false;
		if(this.estComplet == false && this.estChantier == false){
			this.estChantier = true;
			ret = true;
		}
		return ret;
	}

	@Override
	public int getCoutPierre() {
		return this.coutPierre;
	}

	@Override
	public int getCoutBois() {
		return this.coutBois;
	}

	@Override
	public int getCoutSavoir() {
		return this.coutSavoir;
	}

	@Override
	public int getCoutTuile() {
		return this.coutTuile;
	}

	@Override
	public int getWorkedPierre() {
		int ret = 0;
		for(IBuilder builder : this.builders){
			ret = ret + builder.getProdPierre();
		}
		return ret;
	}

	@Override
	public int getWorkedBois() {
		int ret = 0;
		for(IBuilder builder : this.builders){
			ret = ret + builder.getProdBois();
		}
		return ret;
	}

	@Override
	public int getWorkedSavoir() {
		int ret = 0;
		for(IBuilder builder : this.builders){
			ret = ret + builder.getProdSavoir();
		}
		return ret;
	}

	@Override
	public int getWorkedTuile() {
		int ret = 0;
		for(IBuilder builder : this.builders){
			ret = ret + builder.getProdTuile();
		}
		return ret;
	}

	@Override
	public boolean addBuilder(IBuilder builder) {
		boolean ret = false;
		if(this.estChantier = true){
			if(builder != null){
				this.builders.add(builder);
				this.coutBatisseur = this.coutBatisseur +1;
				ret = true;
			}
			if(this.checkCompletion()){
				this.removeAllBuilders();
				this.estComplet = true;
				this.estChantier = false;
			}
		}
		return ret;
	}

	@Override
	public boolean checkCompletion() {
		return (this.getWorkedBois() >= this.coutBois
		&& this.getWorkedPierre() >= this.coutPierre
		&& this.getWorkedSavoir() >= this.coutSavoir
		&& this.getWorkedTuile() >= this.coutTuile);
	}

	@Override
	public void removeAllBuilders() {
		for(IBuilder builder : this.builders){
			builder.setEstOccupe(false);
			System.out.println(builder +" - "+ builder.getEstOccupe());
		}
		this.builders = new ArrayList<IBuilder>();
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public int getCoutBatisseur() {
		return this.coutBatisseur;
	}

	@Override
	public void resetCoutBatisseur() {
		this.coutBatisseur = 1;
	}

	@Override
	public int getEcus() {
		return this.ecus;
	}

	@Override
	public ArrayList<IBuilder> getBuilders() {
		return this.builders;
	}

}
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
	 * true si le build est une machine
	 */
	private boolean estMachine;
	/**
	 * true si le build est complet
	 */
	private boolean estComplet;
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
	 * le constructeur de build, crées un nouveau build
	 * @param nom le nom du build
	 * @param gain le gain en point de victoire du build
	 * @param estMachine si le build est une machine
	 * @param coutPierre le cout en pierre du build
	 * @param coutBois le cout en bois du build
	 * @param coutSavoir le cout en savoir du build
	 * @param coutTuile le cout en tuile du build
	 */
	public Build(String nom, int gain, boolean estMachine, int coutPierre, int coutBois, int coutSavoir, int coutTuile) {
		this.nom = nom;
		this.gain = gain;
		this.estMachine = estMachine;
		this.estComplet = false;
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
		if(builder != null){
			this.builders.add(builder);
			ret = true;
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
		for (int i = 0; i < this.builders.size(); i++) {
			this.builders.remove(i);
		}
	}

}
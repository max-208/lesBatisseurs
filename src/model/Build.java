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
		// TODO - implement Build.Build
		throw new UnsupportedOperationException();
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGain() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getEstMachine() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEstComplet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCoutPierre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutBois() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutSavoir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutTuile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorkedPierre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorkedBois() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorkedSavoir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWorkedTuile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addBuilder(IBuilder builder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkCompletion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeAllBuilders() {
		// TODO Auto-generated method stub
		
	}

}
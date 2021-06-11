package model;

import java.util.*;

/**
 * le deck garde des cartes et permet de les recuperer
 */
public class Deck {

	/**
	 * la liste des builders
	 */
	ArrayList<Builder> builders;
	/**
	 * la liste des machines
	 */
	ArrayList<Machine> machines;
	/**
	 * la liste des builds
	 */
	ArrayList<Build> builds;

	/**
	 * le constructeur de deck, crées un nouveau deck vide
	 */
	public Deck() {
		// TODO - implement Deck.Deck
		throw new UnsupportedOperationException();
	}

	/**
	 * ajout d'un builder au deck
	 * @param builder le builder a ajouter
	 * @return true si le builder a pu etre ajouté
	 */
	public boolean addBuilder(IBuilder builder) {
		// TODO - implement Deck.addBuilder
		throw new UnsupportedOperationException();
	}

	/**
	 * recupere un builder du deck, sans le supprimer
	 * @param index l'index du builder dans le deck
	 * @return le builder
	 */
	public IBuilder getBuilder(int index) {
		// TODO - implement Deck.getBuilder
		throw new UnsupportedOperationException();
	}

	/**
	 * recupere un builder du deck, en le supprimant du deck
	 * @param index l'index du builder dans le deck
	 * @return le builder
	 */
	public IBuilder pickBuilder(int index) {
		// TODO - implement Deck.pickBuilder
		throw new UnsupportedOperationException();
	}

	/**
	 * ajout d'une machine au deck
	 * @param machine la machine a ajouter
	 * @return true si la machine a pu etre ajoutée
	 */
	public boolean addMachine(Machine machine) {
		// TODO - implement Deck.addMachine
		throw new UnsupportedOperationException();
	}

	/**
	 * recupere une machine du deck, sans la supprimer
	 * @param index l'index de la machine dans le deck
	 * @return la machine
	 */
	public Machine pickMachine(int index) {
		// TODO - implement Deck.pickMachine
		throw new UnsupportedOperationException();
	}

	/**
	 * recupere une machine du deck, en la supprimant
	 * @param index l'index de la machine dans le deck
	 * @return la machine
	 */
	public Machine getMachine(int index) {
		// TODO - implement Deck.getMachine
		throw new UnsupportedOperationException();
	}

	/**
	 * ajout d'un build au deck
	 * @param build le build a ajouter au deck
	 * @return true si le build a pu etre ajouté
	 */
	public boolean addBuild(IBuild build) {
		// TODO - implement Deck.addBuild
		throw new UnsupportedOperationException();
	}

	/**
	 * recupere un build du deck, sans le supprimer
	 * @param index l'index du build dans le deck
	 * @return le build
	 */
	public IBuild getBuild(int index) {
		// TODO - implement Deck.getBuild
		throw new UnsupportedOperationException();
	}

	/**
	 * recupere un build du deck, en le supprimant
	 * @param index l'index du build dans le deck
	 * @return le build
	 */
	public IBuild pickBuild(int index) {
		// TODO - implement Deck.pickBuild
		throw new UnsupportedOperationException();
	}

}
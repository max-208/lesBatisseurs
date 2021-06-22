package model;

import java.util.*;

/**
 * le deck garde des cartes et permet de les recuperer
 */
public class Deck {

	/**
	 * la liste des builders
	 */
	HashMap<Integer,IBuilder> builders;
	/**
	 * la liste des builds
	 */
	HashMap<Integer,IBuild> builds;

	/**
	 * le constructeur de deck, crées un nouveau deck vide
	 */
	public Deck() {
		this.builders = new HashMap<Integer,IBuilder>();
		this.builds = new HashMap<Integer,IBuild>();
	}

	/**
	 * ajout d'un builder au deck
	 * @param builder le builder a ajouter
	 * @return true si le builder a pu etre ajouté
	 */
	public boolean addBuilder(IBuilder builder) throws IllegalArgumentException {
		boolean ret = false;
		if(builder != null){
			this.builders.put(builder.getId(), builder);
			ret = true;
		} else {
			throw new IllegalArgumentException("le builder ne doit pas etre null");
		}
		return ret;
	}

	/**
	 * recupere un builder du deck, sans le supprimer
	 * @param index l'index du builder dans le deck
	 * @return le builder
	 */
	public IBuilder getBuilder(int index) {
		return this.builders.get(index);
	}

	/**
	 * recupere un builder du deck, en le supprimant du deck
	 * @param index l'index du builder dans le deck
	 * @return le builder
	 */
	public IBuilder pickBuilder(int index) {
		IBuilder ret = this.builders.get(index);
		this.builders.remove(index);
		return ret;
	}

	/**
	 * retourne un set des index des builder présents dans ce deck
	 * @return un set des index des builder présents dans ce deck
	 */
	public Set<Integer> getBuilderKeys(){
		return this.builders.keySet();
	}

	/**
	 * retourne un builder aléatoire du deck, en le retirant du deck
	 * @return un builder aléatoire du deck, en le retirant du deck
	 */
	public IBuilder pickRandomBuilder(){
		IBuilder ret = null;
		if(this.builders.size()>0){
			Object[] set = this.builders.keySet().toArray();
			Object key = set[new Random().nextInt(set.length)];
			ret = this.pickBuilder((Integer) key);
		}
		return ret;
	}

	/**
	 * ajout d'une machine au deck
	 * @param machine la machine a ajouter
	 * @return true si la machine a pu etre ajoutée
	 */
	public boolean addMachine(Machine machine) throws IllegalArgumentException {
		boolean ret = false;
		if(machine != null){
			//this.builders.put(machine.getId(), machine);
			this.builds.put(machine.getId(), machine);
			ret = true;
		} else {
			throw new IllegalArgumentException("la machine ne doit pas etre null");
		}
		return ret;
	}

	/**
	 * recupere une machine du deck, en la supprimant
	 * @param index l'index de la machine dans le deck
	 * @return la machine
	 */
	public Machine pickMachine(int index) {
		Machine ret = null;
		if(this.builds.get(index) != null){
			boolean estMachine = this.builds.get(index).getEstMachine();
			if(estMachine){
				ret = (Machine) this.builds.get(index);
				//this.builders.remove(index);
				this.builds.remove(index);
			}
		}
		return ret;
	}

	/**
	 * recupere une machine du deck, sans la supprimer
	 * @param index l'index de la machine dans le deck
	 * @return la machine
	 */
	public Machine getMachine(int index) {
		Machine ret = null;
		if(this.builds.get(index) != null){
			boolean estMachine = this.builds.get(index).getEstMachine();
			if(estMachine){
				ret = (Machine) this.builds.get(index);
			}
		}
		return ret;
	}

	/**
	 * ajout d'un build au deck
	 * @param build le build a ajouter au deck
	 * @return true si le build a pu etre ajouté
	 */
	public boolean addBuild(IBuild build) throws IllegalArgumentException {
		boolean ret = false;
		if(build != null){
			if(build.getEstMachine()){
				ret = this.addMachine((Machine) build);
			} else{
				this.builds.put(build.getId(), build);
				ret = true;
			}
		} else {
			throw new IllegalArgumentException("le build ne doit pas etre null");
		}
		return ret;
	}

	/**
	 * recupere un build du deck, sans le supprimer
	 * @param index l'index du build dans le deck
	 * @return le build
	 */
	public IBuild getBuild(int index) {
		return this.builds.get(index);
	}

	/**
	 * recupere un build du deck, en le supprimant
	 * @param index l'index du build dans le deck
	 * @return le build
	 */
	public IBuild pickBuild(int index) {
		IBuild ret = this.builds.get(index);
		if(ret != null && ret.getEstMachine()){
			this.pickMachine(index);
		} else {
			this.builds.remove(index);
		}
		return ret;
	}

	/**
	 * retourne un set des build du deck
	 * @return un set des build du deck
	 */
	public Set<Integer> getBuildKeys(){
		return this.builds.keySet();
	}

	/**
	 * retourne un build aléatoire, en le retirant du deck
	 * @return un build aléatoire, en le retirant du deck
	 */
	public IBuild pickRandomBuild(){
		IBuild ret = null;
		if(this.builders.size()>0){
			Object[] set = this.builds.keySet().toArray();
			Object key = set[new Random().nextInt(set.length)];
			ret = this.pickBuild((Integer) key);
		}
		return ret;
	}
	/**
	 * retourne le nombre de build du deck
	 * @return le nombre de build du deck
	 */
	public int getNbBuilds(){
		return this.builds.size();
	}

	/**
	 * retourne le nombre de builder du deck
	 * @return le nombre de builder du deck
	 */
	public int getNbBuilders(){
		return this.builders.size();
	}

	/**
	 * rends une arraylist contenant les batiments du deck, 4 batiments par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuild> afficherBatiment(int page) {
		ArrayList<IBuild> ret = new ArrayList<IBuild>();
		Set<Integer> set = this.getBuildKeys();
		Iterator<Integer> it = set.iterator();
		int seen = 0;
		while (it.hasNext() && ret.size() < 6) {
			int current = it.next();
			if(this.getBuild(current) != null){
				if(seen >= page * 6 && seen < page * 6 + 6){
					ret.add(this.getBuild(current));
				}
				seen++;
			}
		}
		return ret;
	}

	/**
	 * rends une arraylist contenant les batiments du deck non complets, 4 batiments par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuild> afficherBatimentChantier(int page) {
		ArrayList<IBuild> ret = new ArrayList<IBuild>();
		Set<Integer> set = this.getBuildKeys();
		Iterator<Integer> it = set.iterator();
		int seen = 0;
		while (it.hasNext() && ret.size() < 6) {
			int current = it.next();
			if(this.getBuild(current) != null && this.getBuild(current).getEstChantier()){
				if(seen >= page * 6 && seen < page * 6 + 6){
					ret.add(this.getBuild(current));
				}
				seen++;
			}
		}
		return ret;
	}


	/**
	 * rends une arraylist contenant les ouvriers du deck, 4 ouvriers par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuilder> afficherOuvriers(int page) {
		ArrayList<IBuilder> ret = new ArrayList<IBuilder>();
		Set<Integer> set = this.getBuilderKeys();
		Iterator<Integer> it = set.iterator();
		int seen = 0;
		while (it.hasNext() && ret.size() < 6) {
			int current = it.next();
			if(this.getBuilder(current) != null){
				if(seen >= page * 6 && seen < page * 6 + 6){
					ret.add(this.getBuilder(current));
				}
				seen++;
			}
		}
		return ret;
	}

	/**
	 * rends une arraylist contenant les ouvriers libres du deck, 4 ouvriers par page
	 * @param page la page a afficher
	 * @return une arraylist contenant les cartes a afficher
	 */
	public ArrayList<IBuilder> afficherOuvriersLibres(int page) {
		ArrayList<IBuilder> ret = new ArrayList<IBuilder>();
		Set<Integer> set = this.getBuilderKeys();
		Iterator<Integer> it = set.iterator();
		int seen = 0;
		while (it.hasNext() && ret.size() < 6) {
			int current = it.next();
			if(this.getBuilder(current) != null && !this.getBuilder(current).getEstOccupe()){
				if(seen >= page * 6 && seen < page * 6 + 6){
					ret.add(this.getBuilder(current));
				}
				seen++;
			}
		}
		return ret;
	}

	/**
	 * reinitialise le prix en action de chaque build du deck
	 */
	public void resetAllBuildPrices() {
		for(Integer i : this.getBuildKeys()){
			this.getBuild(i).resetCoutBatisseur();
		}
	}
}
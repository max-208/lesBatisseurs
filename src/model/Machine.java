package model;

import java.util.ArrayList;

/**
 * une machine est une carte qui agit a la fois comme un build et un builder
 */
public class Machine implements IBuilder, IBuild {
	/**
	 * le builder associe a la machine
	 */
	Builder builder;
	/**
	 * le build associe a la machine
	 */
	Build build;

	/**
	 * constructeur de machine, crées une nouvelle machine ainsi qu'un build et un builder associé
	 * @param id l'id de la machine
	 * @param nom le nom de la machine
	 * @param point le nombre de point de victoire que la machine rapportera
	 * @param prodPierre la production en pierre de la machine
	 * @param prodBois la production en bois de la machine
	 * @param prodSavoir la production en savoir de la machine
	 * @param prodTuile la production en tuile de la machine
	 * @param coutPierre le cout en pierre de la machine
	 * @param coutBois le cout en bois de la machine
	 * @param coutSavoir le cout en savoir de la machine
	 * @param coutTuile le cout en tuile de la machine
	 */
	public Machine(int id,String nom, int point, int prodPierre, int prodBois, int prodSavoir, int prodTuile, int coutPierre, int coutBois, int coutSavoir, int coutTuile) {
		this.builder = new Builder(id,0, BuilderType.Machine, prodPierre, prodBois, prodSavoir, prodTuile);
		this.build = new Build(id,nom, 0,0, true, coutPierre, coutBois, coutSavoir, coutTuile);
	}

	/**
	 * retourne le builder de la machine
	 * @return le builder de la machine
	 */
	public Builder getBuilder() {
		return this.builder;
	}

	/**
	 * retourne le build de la machine
	 * @return le build de la machine
	 */
	public Build getBuild() {
		return this.build;
	}

	@Override
	public String getNom() {
		return this.build.getNom();
	}

	@Override
	public int getGain() {
		return this.build.getGain();
	}

	@Override
	public boolean getEstComplet() {
		return this.build.getEstComplet();
	}

	@Override
	public boolean getEstChantier() {
		return this.build.getEstChantier();
	}

	@Override
	public boolean demarrerChantier() {
		return this.build.demarrerChantier();
	}

	@Override
	public int getCoutPierre() {
		return this.build.getCoutPierre();
	}

	@Override
	public int getCoutBois() {
		return this.build.getCoutBois();
	}

	@Override
	public int getCoutSavoir() {
		return this.build.getCoutSavoir();
	}

	@Override
	public int getCoutTuile() {
		return this.build.getCoutTuile();
	}

	@Override
	public int getWorkedPierre() {
		return this.build.getWorkedPierre();
	}

	@Override
	public int getWorkedBois() {
		return this.build.getWorkedBois();
	}

	@Override
	public int getWorkedSavoir() {
		return this.build.getWorkedSavoir();
	}

	@Override
	public int getWorkedTuile() {
		return this.build.getWorkedTuile();
	}

	@Override
	public boolean addBuilder(IBuilder builder) {
		return this.build.addBuilder(builder);
	}

	@Override
	public boolean checkCompletion() {
		return this.build.checkCompletion();
	}

	@Override
	public void removeAllBuilders() {
		this.build.removeAllBuilders();
		
	}

	@Override
	public boolean getEstMachine() {
		return true;
	}

	@Override
	public boolean getEstOccupe() {
		return this.builder.getEstOccupe();
	}

	@Override
	public int getPrix() {
		return this.builder.getPrix();
	}

	@Override
	public int getProdPierre() {
		return this.builder.getProdPierre();
	}

	@Override
	public int getProdBois() {
		return this.builder.getProdBois();
	}

	@Override
	public int getProdSavoir() {
		return this.builder.getProdSavoir();
	}

	@Override
	public int getProdTuile() {
		return this.builder.getProdTuile();
	}

	@Override
	public BuilderType getType() {
		return this.builder.getType();
	}

	@Override
	public void setEstOccupe(boolean estOccupe) {
		this.builder.setEstOccupe(estOccupe);
	}

	@Override
	public int getId() {
		return this.build.getId();
	}

	@Override
	public int getCoutBatisseur() {
		return this.build.getCoutBatisseur();
	}

	@Override
	public void resetCoutBatisseur() {
		this.build.resetCoutBatisseur();
	}

	@Override
	public int getEcus() {
		return this.build.getEcus();
	}

	@Override
	public ArrayList<IBuilder> getBuilders() {
		return this.build.getBuilders();
	}

}
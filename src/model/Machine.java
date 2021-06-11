package model;
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
	public Machine(String nom, int point, int prodPierre, int prodBois, int prodSavoir, int prodTuile, int coutPierre, int coutBois, int coutSavoir, int coutTuile) {
		// TODO - implement Machine.Machine
		throw new UnsupportedOperationException();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGain() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public boolean getEstMachine() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEstOccupe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPrix() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProdPierre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProdBois() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProdSavoir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProdTuile() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BuilderType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstOccupe(boolean estOccupe) {
		// TODO Auto-generated method stub
		
	}

}
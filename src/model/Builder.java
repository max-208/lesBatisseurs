package model;

/**
 * le Builder possede ses statistique pour construire un batiment
 */
public class Builder implements IBuilder {

	/**
	 * le type du builder
	 */
	private BuilderType type;
	/**
	 * le prix a payer pour envoyer ce builder travailler
	 */
	private int prix;
	/**
	 * true si le builder est occupe
	 */
	private boolean estOccupe;
	/**
	 * production en pierre du builder
	 */
	private int prodPierre;
	/**
	 * production en bois du builder
	 */
	private int prodBois;
	/**
	 * production en savoir du builder
	 */
	private int prodSavoir;
	/**
	 * production en tuile du builder
	 */
	private int prodTuile;

	/**
	 * le constructeur de builder
	 * @param prix le prix pour envoyer ce builder travailler
	 * @param type le type du builder
	 * @param prodPierre la production en pierre du builder
	 * @param prodBois la production en bois du builder
	 * @param prodSavoir la production en savoir du builder
	 * @param prodTuille la production en tuile du builder
	 */
	public Builder(int prix, BuilderType type, int prodPierre, int prodBois, int prodSavoir, int prodTuille) {
		// TODO - implement Builder.Builder
		throw new UnsupportedOperationException();
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
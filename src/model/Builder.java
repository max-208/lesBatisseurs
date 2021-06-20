package model;

/**
 * le Builder possede ses statistique et peut construire un batiment
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
	 * id de la carte
	 */
	private int id;

	/**
	 * le constructeur de builder
	 * @param id l'id du builder
	 * @param prix le prix pour envoyer ce builder travailler
	 * @param type le type du builder
	 * @param prodPierre la production en pierre du builder
	 * @param prodBois la production en bois du builder
	 * @param prodSavoir la production en savoir du builder
	 * @param prodTuille la production en tuile du builder
	 */
	public Builder(int id,int prix, BuilderType type, int prodPierre, int prodBois, int prodSavoir, int prodTuile) {
		this.id = id;
		this.prix = prix;
		this.type = type;
		this.prodPierre = prodPierre;
		this.prodBois = prodBois;
		this.prodSavoir = prodSavoir;
		this.prodTuile = prodTuile;
		this.estOccupe = false;
	}

	@Override
	public boolean getEstMachine() {
		return (this.type == BuilderType.Machine);
	}

	@Override
	public boolean getEstOccupe() {
		return this.estOccupe;
	}

	@Override
	public int getPrix() {
		return this.prix;
	}

	@Override
	public int getProdPierre() {
		return this.prodPierre;
	}

	@Override
	public int getProdBois() {
		return this.prodBois;
	}

	@Override
	public int getProdSavoir() {
		return this.prodSavoir;
	}

	@Override
	public int getProdTuile() {
		return this.prodTuile;
	}

	@Override
	public BuilderType getType() {
		return this.type;
	}

	@Override
	public void setEstOccupe(boolean estOccupe) {
		this.estOccupe = estOccupe;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
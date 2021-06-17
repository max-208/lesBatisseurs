package controller;

import java.util.*;
import model.*;
import view.*;

public class Game implements IGame {

	private ArrayList<Player> players;
	private Deck pile;
	private Deck currentCards;
	private Player current;
	private int currentId;
	private VisualInterface visualInterface;
	private boolean isTerminal;
	private String currentAction;
	private int currentActionParam;
	private IBuild currentActionBuild;
	private IBuilder currentActionBuilder;
	private Scanner sc;

	public Game(ArrayList<Player> players,Deck pile,Deck currentCards,VisualInterface visualInterface, boolean isTerminal, int currentId, Scanner sc){
		this.players = players;
		this.pile = pile;
		this.currentCards= currentCards;
		this.visualInterface = visualInterface;
		this.currentId = currentId;
		this.current = this.players.get(this.currentId);
		this.isTerminal = isTerminal;
		this.sc = sc;

		this.currentAction = "";
		this.currentActionParam = 0;
		this.currentActionBuild = null;
		this.currentActionBuilder = null;
	}

	public void changeCurrentPlayer() {
		this.currentId++;
		if(this.currentId>=4){
			this.currentId = 0;
		}
		this.current = this.players.get(this.currentId);
		if(this.current.getType() == PlayerType.None){
			
		}
	}

	public void play() {
		// TODO - implement Game.play
		throw new UnsupportedOperationException();
	}

	@Override
	public void start() {
		if(this.isTerminal){
			boolean finPartie = false;
			this.currentAction = "";
			this.visualInterface.updateTopBar(this.currentId);
			this.visualInterface.empty();
			ArrayList<String> t = new ArrayList<String>();
			while(!finPartie){
				boolean finTour = false;
				t.clear();
				t.add("nouveau tour, vous pouvez lancer les commandes en tappant les valeurs entre crochet");
				this.visualInterface.textReplyPrompt(t);
				this.current.nouveauTour();
				while(!finTour){
					System.out.print(">");
					String text = "";
					text = sc.nextLine().toUpperCase();
					if(text.equals("H")){
						if(this.current.getAction() == 0){
							finTour = true;
						} else {
							t.clear();
							t.add("il vous reste des actions,");
							t.add("vous ne pourrez finir votre tour qu'apres avoir fait toute vos actions");
							this.visualInterface.infoPrompt(t);
						}
					} else {
						this.makeAction(text);
					}
				}
				
				if(current.getPointVictoire() >= 17){
					finPartie = true;
				}
				this.changeCurrentPlayer();
			}
		}else {
			//TODO interface graphique
		}
	}

	public void makeAction(String input){
		ArrayList<String> t = new ArrayList<String>();
		if(input != null){
			switch (input) {
				case "A":
					this.currentActionParam =0;
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherOuvriers(current.cards.afficherOuvriers(currentActionParam));
					t.clear();
					t.add("Pour afficher plus de carte entrez L ou R");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "A";
					break;
	
				case "B":
					this.currentActionParam =0;
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherBatiment(current.cards.afficherBatiment(currentActionParam));
					t.clear();
					t.add("Pour afficher plus de carte entrez L ou R");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "B";
					break;
	
				case "C":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherBatiment(this.currentCards.afficherBatiment(0));
					t.clear();
					t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "C";
					this.currentActionParam = 0;
					break;
	
				case "D":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherOuvriers(this.currentCards.afficherOuvriers(0));
					t.clear();
					t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "D";
					this.currentActionParam = 0;
					break;
	
				case "E":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherBatiment(this.current.cards.afficherBatiment(0));
					t.clear();
					t.add("Veuillez selectionner le chantier qui doit etre lancé");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "E";
					this.currentActionParam = 0;
					break;
	
				case "F":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.empty();
					t.clear();
					t.add("veuillez donner une quantité d'action a depenser");
					this.visualInterface.textReplyPrompt(t);
					this.currentAction = "F";
					break;
	
				case "G":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.empty();
					t.clear();
					t.add("veuillez donner une quantité d'action a acheter");
					this.visualInterface.textReplyPrompt(t);
					this.currentAction = "G";
					break;
	
				case "L":
					this.currentActionParam--;
					switch(this.currentAction){
						case "A":
							this.currentActionParam =0;
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(current.cards.afficherOuvriers(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte entrez L ou R");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "A";
							break;

						case "B":
							this.currentActionParam =0;
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(current.cards.afficherBatiment(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte entrez L ou R");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "B";
							break;
						case "C":
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(this.currentCards.afficherBatiment(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "C";
							break;

						case "D":
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(this.currentCards.afficherOuvriers(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "D";
							break;

						case "E":
							if(this.currentActionBuild == null){
								t.clear();
								t.add("Veuillez selectionner le chantier qui doit etre lancé");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherBatiment(this.current.cards.afficherBatiment(currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentAction = "E";
							} else {
								t.clear();
								t.add("Veuillez selectionner le batisseur qui doit etre envoyé au chantier");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherOuvriers(this.current.cards.afficherOuvriers(this.currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentActionParam = 0;

							}
							
							break;

						default:
							t.clear();
							t.add("Cette valeur n'est pas correcte, veuillez réésayer");
							this.visualInterface.infoPrompt(t);
							break;
						}
					break;
	
				case "R":
					this.currentActionParam++;
					switch(this.currentAction){
						case "A":
							this.currentActionParam =0;
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(current.cards.afficherOuvriers(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte entrez L ou R");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "A";
							break;
							
						case "B":
							this.currentActionParam =0;
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(current.cards.afficherBatiment(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte entrez L ou R");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "B";
							break;
						case "C":
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(this.currentCards.afficherBatiment(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "C";
							break;

						case "D":
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(this.currentCards.afficherOuvriers(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "D";
							break;

						case "E":
							if(this.currentActionBuild == null){
								t.clear();
								t.add("Veuillez selectionner le chantier qui doit etre lancé");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherBatiment(this.current.cards.afficherBatiment(currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentAction = "E";
							} else {
								t.clear();
								t.add("Veuillez selectionner le batisseur qui doit etre envoyé au chantier");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherOuvriers(this.current.cards.afficherOuvriers(this.currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentActionParam = 0;

							}
							
							break;

						default:
							t.clear();
							t.add("Cette valeur n'est pas correcte, veuillez réésayer");
							this.visualInterface.infoPrompt(t);
							break;
						}
					break;
			
				default:
					try {
						int num = Integer.parseInt(input);
						switch(this.currentAction){
							case "C":
								if(this.currentCards.getBuild(num) != null){
									if(current.getAction()>= 1){
										this.current.ouvrirChantier(this.currentCards.pickBuild(num));
										this.currentCards.addBuild(this.pile.pickRandomBuild());
										this.currentActionParam =0;
										this.visualInterface.updateTopBar(this.currentId);
										this.visualInterface.afficherBatiment(current.cards.afficherBatiment(currentActionParam));
										t.clear();
										t.add("Pour afficher plus de carte entrez L ou R");
										this.visualInterface.infoPrompt(t);
										this.currentAction = "B";
									} else {
										t.clear();
										t.add("vous n'avez pas assez d'actions pour effectuer cette operation");
										t.add("essayer d'en acheter avec l'action \"ecu -> action\"");
										this.visualInterface.infoPrompt(t);
									}
								} else {
									t.clear();
									t.add("Cette valeur n'est pas correcte, veuillez réésayer");
									this.visualInterface.infoPrompt(t);
								}
								break;
							
							case "D":
								if(this.currentCards.getBuilder(num) != null){
									if(current.getAction()>= 1){
										this.current.recruterOuvrier(this.currentCards.pickBuilder(num));
										this.currentCards.addBuilder(this.pile.pickRandomBuilder());
										this.currentAction ="";
										this.currentActionParam =0;
										this.visualInterface.updateTopBar(this.currentId);
										this.visualInterface.afficherOuvriers(current.cards.afficherOuvriers(currentActionParam));
										t.clear();
										t.add("Pour afficher plus de carte entrez L ou R");
										this.visualInterface.infoPrompt(t);
										this.currentAction = "A";
										break;
									} else {
										t.clear();
										t.add("vous n'avez pas assez d'actions pour effectuer cette operation");
										t.add("essayer d'en acheter avec l'action \"ecu -> action\"");
										this.visualInterface.infoPrompt(t);
									}
								} else {
									t.clear();
									t.add("Cette valeur n'est pas correcte, veuillez réésayer");
									this.visualInterface.infoPrompt(t);
								}
								break;

							case "E":
								if(this.currentActionBuild == null){
									this.currentActionBuild = this.current.cards.getBuild(num);
									if(this.currentActionBuild == null){
										t.clear();
										t.add("Cette valeur n'est pas correcte, veuillez réésayer");
										this.visualInterface.infoPrompt(t);
									} else {
										t.clear();
										t.add("Veuillez selectionner le batisseur qui doit etre envoyé au chantier");
										this.visualInterface.updateTopBar(this.currentId);
										this.visualInterface.afficherOuvriers(this.current.cards.afficherOuvriers(this.currentActionParam));
										this.visualInterface.infoPrompt(t);
										this.currentActionParam = 0;
									}
								} else {
									this.currentActionBuilder = this.current.cards.getBuilder(num);
									if(this.currentActionBuilder == null){
										t.clear();
										t.add("Cette valeur n'est pas correcte, veuillez réésayer");
										this.visualInterface.infoPrompt(t);
									} else {
										if(this.current.envoyerTravailler(this.currentActionBuild, this.currentActionBuilder)){
											this.visualInterface.updateTopBar(this.currentId);
											this.visualInterface.empty();
											this.currentAction = "";
										}
									}
								}
								break;

							case "F":
								if(num>0 && num <= this.current.getAction()){
									this.current.actionVersEcu(num);
									this.visualInterface.updateTopBar(this.currentId);
									this.visualInterface.empty();
									this.currentAction = "";
								} else {
									t.clear();
									t.add("Cette valeur n'est pas correcte, veuillez réésayer");
									this.visualInterface.textReplyPrompt(t);
								}
								break;

							case "G":
								if(this.current.ecuVersAction(num)){
									this.visualInterface.updateTopBar(this.currentId);
									this.visualInterface.empty();
									this.currentAction = "";
								} else {
									t.clear();
									t.add("Cette valeur n'est pas correcte, veuillez réésayer");
									this.visualInterface.textReplyPrompt(t);
								}
								break;

							default:
								t.clear();
								t.add("Cette valeur n'est pas correcte, veuillez réésayer");
								this.visualInterface.infoPrompt(t);
								break;

						}
					} catch (Exception e) {
						t.clear();
						t.add("Cette valeur n'est pas correcte, veuillez réésayer");
						this.visualInterface.infoPrompt(t);
					}
					break;
			}
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
package controller;

import java.util.*;
import model.*;
import view.*;
import java.io.*;

/**
 * le coeur de la logique du jeu : recuperer les actions du joueur, agis sur le modele et gere l'affichage
 */
public class Game {

	/**
	 * la liste des joueurs en jeu
	 */
	private ArrayList<Player> players;
	/**
	 * la pile de carte
	 */
	private Deck pile;
	/**
	 * les cartes actuellement affichées dans lequelles les joueurs peuvent piocher
	 */
	private Deck currentCards;
	/**
	 * le joueur actuel
	 */
	private Player current;
	/**
	 * l'id du joueur actuel (de 0 a 3)
	 */
	private int currentId;
	/**
	 * l'interface visuelle sur laquelle l'on doit agir
	 */
	private VisualInterface visualInterface;
	/**
	 * l'interface visuelle est est un terminal ?
	 */
	private boolean isTerminal;
	/**
	 * l'action en cours
	 */
	private String currentAction;
	/**
	 * le paramètre de l'action en cours (la page ouverte)
	 */
	private int currentActionParam;
	/**
	 * le batiment de l'action en court
	 */
	private IBuild currentActionBuild;
	/**
	 * le builder de l'action en cours
	 */
	private IBuilder currentActionBuilder;
	/**
	 * le scanner permettant de récuperer les actions du joueur
	 */
	private Scanner sc;
	/**
	 * l'index de la sauvegarde a faire
	 */
	private int savefile;

	/**
	 * le constructeur de game
	 * @param players la liste des joueurs en jeu
	 * @param pile la pile de carte
	 * @param currentCards les cartes actuellement affichées dans lequelles les joueurs peuvent piocher
	 * @param visualInterface l'interface visuelle sur laquelle l'on doit agir
	 * @param isTerminal l'interface visuelle est est un terminal ?
	 * @param currentId l'id du joueur actuel (de 0 a 3)
	 * @param sc le scanner permettant de récuperer les actions du joueur
	 * @param savefile l'index de la sauvegarde a faire
	 */
	public Game(ArrayList<Player> players,Deck pile,Deck currentCards,VisualInterface visualInterface, boolean isTerminal, int currentId, Scanner sc,int savefile){
		this.players = players;
		this.pile = pile;
		this.currentCards= currentCards;
		this.visualInterface = visualInterface;
		this.currentId = currentId;
		this.current = this.players.get(this.currentId);
		this.isTerminal = isTerminal;
		this.sc = sc;
		this.savefile = savefile;
		this.currentAction = "";
		this.currentActionParam = 0;
		this.currentActionBuild = null;
		this.currentActionBuilder = null;
	}

	/**
	 * change le joueur actuel, donne au nouveau joueur ses points de mouvement et lance l'ia si necessaire
	 */
	public void changeCurrentPlayer() {
		if(current.getPointVictoire() >= 17){
			this.stop();
		} else {
			this.currentId++;
			if(this.currentId>=4){
				this.currentId = 0;
			}
			this.current = this.players.get(this.currentId);
			if(this.current.getType() == PlayerType.None){
				this.changeCurrentPlayer();
			} else {
				this.saveState();
				this.current.nouveauTour();
				if(this.current.getType() == PlayerType.Auto){
					this.autoplay();
				}
			}
			this.visualInterface.updateTopBar(this.currentId);
			this.visualInterface.empty();
		}
	}

	/**
	 * lance les actions de l'ia
	 */
	public void autoplay() {
		//TODO implementer une meilleure ia
		Random r = new Random();
		int rng;
		//System.out.println("nb batiment chantier/total : " + this.current.cards.afficherBatimentChantier(0).size() + " / " +  this.current.cards.getNbBuilds() );
		//System.out.println("nb batisseurs libres/total : " + this.current.cards.afficherOuvriersLibres(0).size() + " / " +  this.current.cards.getNbBuilders() );
		try{
			//int[4] buildFocus = new int[4];
			while(this.current.getAction()>0){
				if(r.nextInt(2) == 0){
					if(this.currentCards.afficherBatiment(0).size() >0 && this.current.cards.afficherBatimentChantier(0).size() <3){
						this.makeAction("C");
						rng = r.nextInt(this.currentCards.afficherBatiment(0).size());
						this.makeAction(this.currentCards.afficherBatiment(0).get(rng).getId() + "");
					}
				} else {
					if(this.currentCards.afficherOuvriers(0).size() > 0 && this.current.cards.afficherOuvriersLibres(0).size() <3){
						this.makeAction("D");
						rng = r.nextInt(this.currentCards.afficherOuvriers(0).size());
						this.makeAction(this.currentCards.afficherOuvriers(0).get(rng).getId() + "");
					}
				}
				if(this.current.cards.afficherOuvriersLibres(0).size() > 0 && this.current.cards.afficherBatimentChantier(0).size() > 0){
					int rng1 = r.nextInt(this.current.cards.afficherBatimentChantier(0).size());
					int rng2 = r.nextInt(this.current.cards.afficherOuvriersLibres(0).size());
					//int rng1 = 0;
					//int rng2 = 0;
					if(this.current.getEcus() < this.current.cards.afficherOuvriersLibres(0).get(rng2).getPrix() || this.current.getAction() < this.current.cards.afficherBatimentChantier(0).get(rng1).getCoutBatisseur()){
						this.makeAction("F");
						this.makeAction("1");
					}
					this.makeAction("E");
					this.makeAction(this.current.cards.afficherBatimentChantier(0).get(rng1).getId() + "");
					this.makeAction(this.current.cards.afficherOuvriersLibres(0).get(rng2).getId() + "");
				}
				if(this.current.cards.afficherOuvriersLibres(0).size() == 0 && this.currentCards.afficherOuvriers(0).size() == 0){
					throw new Exception();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.makeAction("H");
	}

	/**
	 * lance la partie
	 */
	public void start() {
		this.saveState();
		if(this.isTerminal){
			boolean finPartie = false;
			ArrayList<String> t = new ArrayList<String>();
			this.current.nouveauTour();
			while(!finPartie){
				boolean finTour = false;
				t.clear();
				t.add("nouveau tour, vous pouvez lancer les commandes en utilisant les commandes ci-dessus");
				this.currentAction = "";
				this.visualInterface.updateTopBar(this.currentId);
				this.visualInterface.empty();
				this.visualInterface.infoPrompt(t);
				switch (this.current.getType()){
					case Auto:
						this.autoplay();
						break;
					case None:
						break;
					case Human:
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
				}
				
				if(current.getPointVictoire() >= 17){
					finPartie = true;
				}
				this.changeCurrentPlayer();
			}
			this.stop();
		}else {
			this.current.nouveauTour();
			ArrayList<String> t = new ArrayList<String>();
			t.clear();
			t.add("nouveau tour, vous pouvez lancer les commandes en utilisant les commandes ci-dessus");
			this.currentAction = "";
			this.visualInterface.updateTopBar(this.currentId);
			this.visualInterface.empty();
			this.visualInterface.infoPrompt(t);
			if(this.current.getType() == PlayerType.Auto){
				this.autoplay();
			}
		}
	}

	/**
	 * performe une action du joueur
	 * @param input l'action a effectuer
	 */
	public void makeAction(String input){
		//HashMap<String,String> hash = new HashMap<String,String>();
		//hash.put("A","afficher ouvriers ");
		//hash.put("B","afficher batiments");
		//hash.put("C","ouvrir chantier   ");
		//hash.put("D","recruter ouvrier  ");
		//hash.put("E","envoyer travailler");
		//hash.put("F","action -> ecu     ");
		//hash.put("G","ecu -> action     ");
		//hash.put("H","fin de tour       ");
		//System.out.println(input + " - " + hash.get(input));
		ArrayList<String> t = new ArrayList<String>();
		if(input != null){
			switch (input) {
				case "A":
					this.currentActionParam =0;
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherOuvriers(current.cards.afficherOuvriersLibres(currentActionParam));
					t.clear();
					t.add("Pour afficher plus de carte utilisez les fleches");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "A";
					break;
	
				case "B":
					this.currentActionParam =0;
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.afficherBatiment(current.cards.afficherBatimentChantier(currentActionParam));
					t.clear();
					t.add("Pour afficher plus de carte utilisez les fleches");
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
					this.visualInterface.afficherBatiment(this.current.cards.afficherBatimentChantier(0));
					t.clear();
					t.add("Veuillez selectionner le chantier qui doit etre lancé");
					this.visualInterface.infoPrompt(t);
					this.currentAction = "E";
					this.currentActionParam = 0;
					this.currentActionBuild = null;
					this.currentActionBuilder = null;
					break;
	
				case "F":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.empty();
					t.clear();
					t.add("veuillez donner une quantité d'action a depenser");
					this.visualInterface.textReplyPrompt(t,this.current.getAction());
					this.currentAction = "F";
					break;
	
				case "G":
					this.visualInterface.updateTopBar(this.currentId);
					this.visualInterface.empty();
					t.clear();
					t.add("veuillez donner une quantité d'action a acheter");
					this.visualInterface.textReplyPrompt(t,this.current.getEcus()/5);
					this.currentAction = "G";
					break;
	
				case "L":
					this.currentActionParam--;
					switch(this.currentAction){
						case "A":
							if(this.currentActionParam < 0){
								this.currentActionParam = current.cards.getNbBuilders()/6;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(current.cards.afficherOuvriersLibres(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte utilisez les fleches");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "A";
							break;

						case "B":
							if(this.currentActionParam < 0){
								this.currentActionParam = current.cards.getNbBuilds()/6;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(current.cards.afficherBatimentChantier(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte utilisez les fleches");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "B";
							break;
						case "C":
							if(this.currentActionParam < 0){
								this.currentActionParam = currentCards.getNbBuilds()/6;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(this.currentCards.afficherBatiment(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "C";
							break;

						case "D":
							if(this.currentActionParam < 0){
								this.currentActionParam = currentCards.getNbBuilders()/6;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(this.currentCards.afficherOuvriers(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "D";
							break;

						case "E":
							if(this.currentActionBuild == null){
								if(this.currentActionParam < 0){
									this.currentActionParam = currentCards.getNbBuilds()/6;
								}
								t.clear();
								t.add("Veuillez selectionner le chantier qui doit etre lancé");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherBatiment(this.current.cards.afficherBatimentChantier(currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentAction = "E";
							} else {
								if(this.currentActionParam < 0){
									this.currentActionParam = currentCards.getNbBuilders()/6;
								}
								t.clear();
								t.add("Veuillez selectionner le batisseur qui doit etre envoyé au chantier");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherOuvriers(this.current.cards.afficherOuvriersLibres(this.currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentAction = "E";
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
							if(this.currentActionParam > current.cards.getNbBuilders()/6){
								this.currentActionParam = 0;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(current.cards.afficherOuvriersLibres(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte utilisez les fleches");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "A";
							break;
							
						case "B":
							if(this.currentActionParam > current.cards.getNbBuilds()/6){
								this.currentActionParam = 0;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(current.cards.afficherBatimentChantier(currentActionParam));
							t.clear();
							t.add("Pour afficher plus de carte utilisez les fleches");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "B";
							break;
						case "C":
							if(this.currentActionParam > current.cards.getNbBuilds()/6){
								this.currentActionParam = 0;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherBatiment(this.currentCards.afficherBatiment(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "C";
							break;

						case "D":
							if(this.currentActionParam > current.cards.getNbBuilders()/6){
								this.currentActionParam = 0;
							}
							this.visualInterface.updateTopBar(this.currentId);
							this.visualInterface.afficherOuvriers(this.currentCards.afficherOuvriers(currentActionParam));
							t.clear();
							t.add("Veuillez selectionner la carte que vous shouaitez recuperer");
							this.visualInterface.infoPrompt(t);
							this.currentAction = "D";
							break;

						case "E":
							if(this.currentActionBuild == null){
								if(this.currentActionParam > current.cards.getNbBuilds()/6){
									this.currentActionParam = 0;
								}
								t.clear();
								t.add("Veuillez selectionner le chantier qui doit etre lancé");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherBatiment(this.current.cards.afficherBatimentChantier(currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentAction = "E";
							} else {
								if(this.currentActionParam > current.cards.getNbBuilders()/6){
									this.currentActionParam = 0;
								}
								t.clear();
								t.add("Veuillez selectionner le batisseur qui doit etre envoyé au chantier");
								this.visualInterface.updateTopBar(this.currentId);
								this.visualInterface.afficherOuvriers(this.current.cards.afficherOuvriersLibres(this.currentActionParam));
								this.visualInterface.infoPrompt(t);
								this.currentAction = "E";
							}
							
							break;

						default:
							t.clear();
							t.add("Cette valeur n'est pas correcte, veuillez réésayer");
							this.visualInterface.infoPrompt(t);
							break;
					}
					break;
			
				case "H":
					if(this.current.getAction() == 0){
						t.clear();
						t.add("nouveau tour, vous pouvez lancer les commandes en utilisant les commandes ci-dessus");
						this.currentAction = "";
						this.visualInterface.updateTopBar(this.currentId);
						this.visualInterface.empty();
						this.visualInterface.infoPrompt(t);
						if(current.getPointVictoire() >= 17){
							this.stop();
						}
						this.changeCurrentPlayer();
					} else {
						t.clear();
						t.add("il vous reste des actions,");
						t.add("vous ne pourrez finir votre tour qu'apres avoir fait toute vos actions");
						this.visualInterface.infoPrompt(t);
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
										t.add("Pour afficher plus de carte utilisez les fleches");
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
										t.add("Pour afficher plus de carte utilisez les fleches");
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
									if(this.current.cards.getBuild(num) != null && !this.current.cards.getBuild(num).getEstComplet()){
										this.currentActionBuild = this.current.cards.getBuild(num);
										t.clear();
										t.add("Veuillez selectionner le batisseur qui doit etre envoyé au chantier");
										this.visualInterface.updateTopBar(this.currentId);
										this.visualInterface.afficherOuvriers(this.current.cards.afficherOuvriersLibres(this.currentActionParam));
										this.visualInterface.infoPrompt(t);
										this.currentActionParam = 0;
									} else {
										t.clear();
										t.add("Ce batiment ne vous appartiens pas ou est deja en chantier");
										this.visualInterface.infoPrompt(t);
									}
								} else {
									if(this.current.cards.getBuilder(num) != null && !this.current.cards.getBuilder(num).getEstOccupe()){
										this.currentActionBuilder = this.current.cards.getBuilder(num);
									}
									if(this.currentActionBuilder == null){
										t.clear();
										t.add("Ce batisseur ne vous appartiens pas ou est deja occupé");
										this.visualInterface.infoPrompt(t);
									} else {
										if(this.current.envoyerTravailler(this.currentActionBuild, this.currentActionBuilder)){
											this.currentActionParam =0;
											this.visualInterface.updateTopBar(this.currentId);
											this.visualInterface.afficherBatiment(current.cards.afficherBatimentChantier(currentActionParam));
											t.clear();
											t.add("Pour afficher plus de carte utilisez les fleches");
											this.visualInterface.infoPrompt(t);
											this.currentAction = "";
											this.currentActionBuild = null;
											this.currentActionBuilder = null;
										} else {
											t.clear();
											t.add("Il vous faut au moins" + this.currentActionBuilder.getPrix() + " ecus et " + this.currentActionBuild.getCoutBatisseur() + " actions pour envoyer ce batisseur ici");
											this.visualInterface.infoPrompt(t);
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
									this.visualInterface.textReplyPrompt(t,this.current.getAction());
									t.clear();
									t.add("Cette valeur n'est pas correcte, veuillez réésayer");
									this.visualInterface.infoPrompt(t);
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
									this.visualInterface.textReplyPrompt(t,this.current.getEcus()/5);
								}
								break;

							default:
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

	/** 
	 * fin du jeu
	 */
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("la partie est finie mais j'a pas implémenté de fin de game :(");
	}

	/**
	 * sauvegarde l'etat actuel
	 */
	public void saveState(){
		try{
			FileWriter w = new FileWriter("data/save/save" + this.savefile + ".sav");
        	BufferedWriter b = new BufferedWriter(w);
        	PrintWriter out = new PrintWriter(b);

			out.println(this.currentId);
			String s="";
			for (int i = 0; i < 4; i++) {
				s = s + ":";
				s = s+players.get(i).getType();
			}
			if(s.length()>0){
				s = s.substring(1);
			}
			out.println(s);
			s = "";
			for( Integer i : this.currentCards.getBuilderKeys()){
				s = s + ":";
				s = s + i;
			}
			if(s.length()>0){
				s = s.substring(1);
			}
			out.println(s);
			s = "";
			for( Integer i : this.currentCards.getBuildKeys()){
				s = s + ":";
				s = s + i;
			}
			if(s.length()>0){
				s = s.substring(1);
			}
			out.println(s);
			for(Player p : this.players){
				if(p.getType() != PlayerType.None){
					out.println(p.getEcus() + ":" + p.getPointVictoire());

					s = "";
					for( Integer i : p.cards.getBuilderKeys()){
						s = s + ":";
						s = s + i;
					}
					if(s.length()>0){
						s = s.substring(1);
					}
					out.println(s);
					s = "";
					for( Integer i : p.cards.getBuildKeys()){
						s = s + ":";
						s = s + i;
					}
					if(s.length()>0){
						s = s.substring(1);
					}
					out.println(s);
				} else {
					out.println("");
					out.println("");
					out.println("");
				}
				
			}

			out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
	}

}
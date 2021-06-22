package controller;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import model.*;
import view.*;

/**
 * le lanceur du jeu, prépare la configuration
 */
public class GameLauncher {

	/**
	 * le jeu
	 */
	protected Game game;
	/**
	 * l'interface visuelle
	 */
	protected VisualInterface visualInterface;
	/**
	 * la liste des joueurs en jeu
	 */
	protected ArrayList<Player> players;
	/**
	 * la pile de carte
	 */
	protected Deck pile;
	/**
	 * les cartes actuellement affichées dans lequelles les joueurs peuvent piocher
	 */
	protected Deck currentCards;
	/**
	 * l'id du joueur actuel (de 0 a 3)
	 */
	protected int currentId;
	/**
	 * l'index de la sauvegarde a faire
	 */
	protected int savefile;
	/**
	 * le scanner permettant de récuperer les actions du joueur
	 */
	protected Scanner sc;
	/**
	 * le Listener permettant de gerer les actions du joueur
	 */
	protected Listener al;

	/**
	 * le constructeur de GameLauncher
	 * @param isTerminal true si l'interface est terminale
	 */
	public GameLauncher(boolean isTerminal){
		this.al = new Listener();
		this.players = new ArrayList<Player>();
		
		if (isTerminal) {
			//change l'encoding du système en utf-8
			try{
				if(System.getProperty("os.name").toLowerCase().startsWith("windows")){
					ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "chcp", "65001").inheritIO();
					Process p = pb.start();
					p.waitFor();
				}
			} catch (Exception e){
				e.printStackTrace();
			}

			try {
				System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new InternalError("VM does not support mandatory encoding UTF-8");
			}

			//   _________  
			// /|__/   \__|\
			// \|__\___/__|/
			//      |/|     
			//      |/|     
			//      |/|     
			//      /.\     
			//      \_/      

			//      ___      
			//     /_._\     
			//     / ° \     
			//    / / \ \    
			//   //     \\   
			//  //       \\  
			// /           \  
			System.out.println("   _________  " 	+ "   _                 ____        _                                 "			+ "      ___    ");
			System.out.println(" /|__/   \\__|\\" 	+ "  | |               |  _ \\      | | (_)                            "		+ "     /_._\\   ");
			System.out.println(" \\|__\\___/__|/" 	+ "  | |     ___  ___  | |_) | __ _| |_ _ ___ ___  ___ _   _ _ __ ___ "			+ "     / ° \\   ");
			System.out.println("      |/|     " 	+ "  | |    / _ \\/ __| |  _ < / _` | __| / __/ __|/ _ \\ | | | '__/ __|"		+ "    / / \\ \\  ");
			System.out.println("      |/|     " 	+ "  | |___|  __/\\__ \\ | |_) | (_| | |_| \\__ \\__ \\  __/ |_| | |  \\__ \\"	+ "   //     \\\\ ");
			System.out.println("      |/|     " 	+ "  |______\\___||___/ |____/ \\__,_|\\__|_|___/___/\\___|\\__,_|_|  |___/"	+ "  //       \\\\");
			System.out.println("      /.\\     " 	+ "                                                                   "			+ " /           \\");
			System.out.println("      \\_/      " 	+ "            veuillez appuyer sur entrée pour démarrer");
			//analyse de terminal, si ce dernier n'est pas compatible couleur, LegacyTerminalInterface est lancé sinon TerminalInterface
			sc = new Scanner(System.in);
			System.out.println("\u001B[6n");
			boolean legacy = sc.nextLine().equals("");
			if(!legacy){
				System.out.print(String.format("\033[%dA",1)); // Move up
				System.out.print("\033[2K"); // Erase line content
			}
			//sc.close();
			System.out.println("------info config------");
			System.out.println("Charset defaut  : " + Charset.defaultCharset());
			System.out.println("file encoding   : " + System.getProperty("file.encoding"));
			System.out.println("legacy mode     : " + legacy);
			System.out.println("------------------------");
			if(legacy){
				visualInterface = new LegacyTerminalInterface(players);
			} else {
				visualInterface = new TerminalInterface(players);
			}
			boolean fin = false;
			while(!fin){
				visualInterface.menu();
				System.out.print(">");
				String text = sc.nextLine();
				switch (text.toUpperCase()){
					case "N":
						boolean finN = false;
						while(!finN){
							visualInterface.saveSelect();
							System.out.print(">");
							String textN = sc.nextLine();
							switch (textN.toUpperCase()){
								case "B":
									finN = true;
									break;
								case "1":
								case "2":
								case "3":
								case "4":
								case "5":
								case "6":
									this.savefile = Integer.parseInt(textN);
									System.out.println("sauvegarde " +this.savefile);
									this.loadConf();
									finN = true;
									fin = true;
									break;
							}
						}
						break;
					case "C":
						boolean finC = false;
						while(!finC){
							visualInterface.saveSelect();
							System.out.print(">");
							String textC = sc.nextLine();
							switch (textC.toUpperCase()){
								case "B":
									finC = true;
									break;
								case "1":
								case "2":
								case "3":
								case "4":
								case "5":
								case "6":
									this.savefile = Integer.parseInt(textC);
									System.out.println("sauvegarde " +this.savefile);
									this.loadSave();
									finC = true;
									fin = true;
									break;
							}
						}
						break;
					case "R":
					boolean finR = false;
					while(!finR){
						visualInterface.regles();
						System.out.print(">");
						String textR = sc.nextLine();
						switch (textR.toUpperCase()){
							case "B":
								finR = true;
								break;
						}
					}
						
				}
			}
			launchGame(true);
		} else {
			sc = new Scanner(System.in);
			GameLauncher gl = this;
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					visualInterface = new GraphicalInterface(players,al,new MenuListener(gl));
					visualInterface.menu();
				}
			});
		}
		

		
	}

	/**
	 * lances le jeu
	 * @param isTerminal true si l'interface est terminale
	 */
	public void launchGame(boolean isTerminal){
		this.game = new Game(players, pile, currentCards, visualInterface,isTerminal,currentId,sc,savefile);
		al.setGame(game);
		this.game.start();
	}

	/**
	 * crées une nouvelle partie en chargeant une configuration
	 */
	public void loadConf(){
		System.out.println("creation de nouvelle partie");
		players.clear();
		pile = new Deck();
		currentCards = new Deck();
		currentId = 0;
		this.createCards();
		//TODO implementation du chargement de sauvegarde/configuration
		players.add(new Player(PlayerType.Human));
		players.add(new Player(PlayerType.Auto));
		players.add(new Player(PlayerType.Auto));
		players.add(new Player(PlayerType.Auto));

		for (int i = 1; i < 7; i++) {
			currentCards.addBuilder(pile.pickBuilder(i));
		}

		for (int i = 0; i < 4; i++) {
			if(players.get(i).getType() != PlayerType.None){
				players.get(i).cards.addBuilder(currentCards.pickRandomBuilder());
			}
		}

		for (int i = 1; i < 7; i++) {
			IBuilder b = currentCards.pickBuilder(i);
			if(b != null){
				pile.addBuilder(b);
			}
		}

		for (int i = 0; i < 5; i++) {
			currentCards.addBuild(pile.pickRandomBuild());
			currentCards.addBuilder(pile.pickRandomBuilder());
		}
	}

	/**
	 * crées le paquet de carte
	 */
	public void createCards() {
		int id = 0;
        try {
            // ouverture du fichier
            Scanner in = new Scanner(new FileReader("data/csv/batisseurs.csv",Charset.forName("UTF-8")));
            // lecture et ajout des lignes une par une
			in.nextLine();
            while (in.hasNextLine()) {
				id = id+1;
                String text = in.nextLine();
				String[] vals = text.split(";");
				
				pile.addBuilder(new Builder(id, Integer.parseInt(vals[1]), BuilderType.valueOf(vals[0]), Integer.parseInt(vals[2]), Integer.parseInt(vals[3]), Integer.parseInt(vals[4]), Integer.parseInt(vals[5])));

            }
            // fermeture du fichier ouvert en lecture
            in.close();

            // ouverture du fichier
            in = new Scanner(new FileReader("data/csv/batiments.csv",Charset.forName("UTF-8")));
            // lecture et ajout des lignes une par une
			in.nextLine();
            while (in.hasNextLine()) {
				id = id+1;
                String text = in.nextLine();
				String[] vals = text.split(";");
				
				pile.addBuild( new Build(id, vals[0], Integer.parseInt(vals[1]), Integer.parseInt(vals[2]), false, Integer.parseInt(vals[3]), Integer.parseInt(vals[4]), Integer.parseInt(vals[5]), Integer.parseInt(vals[6])));

            }
            // fermeture du fichier ouvert en lecture
            in.close();

            // ouverture du fichier
            in = new Scanner(new FileReader("data/csv/machines.csv",Charset.forName("UTF-8")));
            // lecture et ajout des lignes une par une
			in.nextLine();
            while (in.hasNextLine()) {
				id = id+1;
                String text = in.nextLine();
				String[] vals = text.split(";");
				
				pile.addMachine(new Machine(id, vals[0], Integer.parseInt(vals[5]), Integer.parseInt(vals[1]), Integer.parseInt(vals[2]), Integer.parseInt(vals[3]), Integer.parseInt(vals[4]), Integer.parseInt(vals[6]), Integer.parseInt(vals[7]), Integer.parseInt(vals[8]), Integer.parseInt(vals[9])));

            }
            // fermeture du fichier ouvert en lecture
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * charge une sauvegarde
	 */
	public void loadSave(){
		System.out.println("chargement de partie");
		this.players.clear();
		this.pile = new Deck();
		this.currentCards = new Deck();
		this.currentId = 0;
		this.createCards();
		try{
			FileReader r = new FileReader("data/save/save"+savefile+".sav");
        	BufferedReader in = new BufferedReader(r);
			String text = in.readLine();
			if(text != null){
				this.currentId = Integer.parseInt(text);
				String[] list;
				text = in.readLine();
				if(text != null && !text.equals("")){
					list = text.split(":");
					this.players.add(new Player(PlayerType.valueOf(list[0])));
					this.players.add(new Player(PlayerType.valueOf(list[1])));
					this.players.add(new Player(PlayerType.valueOf(list[2])));
					this.players.add(new Player(PlayerType.valueOf(list[3])));
				} else {
					in.close();
					throw new Exception("pas de joueurs");
				}
				text = in.readLine();
				if(text != null && !text.equals("")){
					list = text.split(":");
					for(String s : list){
						if(this.pile.getMachine(Integer.parseInt(s)) != null){
							this.currentCards.addBuilder(this.pile.pickMachine(Integer.parseInt(s)));
						} else {
							this.currentCards.addBuilder(this.pile.pickBuilder(Integer.parseInt(s)));
						}
					}
				}
				text = in.readLine();
				if(text != null && !text.equals("")){
					list = text.split(":");
					for(String s : list){
						if(this.pile.getMachine(Integer.parseInt(s)) != null){
							this.currentCards.addBuild(this.pile.pickMachine(Integer.parseInt(s)));
						} else {
							this.currentCards.addBuild(this.pile.pickBuild(Integer.parseInt(s)));
						}
					}
				}
				for(Player p : players){
					if(p.getType() != PlayerType.None){
						text = in.readLine();
						if(text != null && !text.equals("")){
							list = text.split(":");
							p.setEcus(Integer.parseInt(list[0]));
							p.setVictoire(Integer.parseInt(list[1]));
						}
						text = in.readLine();
						if(text != null && !text.equals("")){
							list = text.split(":");
							for(String s : list){
								if(this.pile.getMachine(Integer.parseInt(s)) != null){
									p.cards.addBuilder(this.pile.getMachine(Integer.parseInt(s)));
									
								} else {
									p.cards.addBuilder(this.pile.pickBuilder(Integer.parseInt(s)));
								}
							}
						}
						text = in.readLine();
						if(text != null && !text.equals("")){
							list = text.split(":");
							for(String s : list){
								if(this.pile.getMachine(Integer.parseInt(s)) != null){
									p.cards.addBuild(this.pile.pickMachine(Integer.parseInt(s)));
								} else {
									p.cards.addBuild(this.pile.pickBuild(Integer.parseInt(s)));
								}
							}	
						}
					} else {
						in.readLine();
						in.readLine();
						in.readLine();
					}
				}
				System.out.println("sauvegarde chargée");
			} else {
				in.close();
				throw new Exception("sauvegarde inexistante");
			}
			in.close();
		} catch (Exception e){
			this.loadConf();
		}
	}

}
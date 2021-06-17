package controller;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import model.*;
import view.*;

public class GameLauncher {

	Game game;

	public GameLauncher(){
		VisualInterface visualInterface;
		ArrayList<Player> players = new ArrayList<Player>();
		Deck pile = new Deck();
		Deck currentCards = new Deck();
		this.createCards(pile);
		this.loadConf(pile, currentCards, players);	
		
		//TODO l'interface graphique

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
		Scanner sc = new Scanner(System.in);
		System.out.println("\u001B[6n");
		boolean colorSupport = !sc.nextLine().equals("");
		boolean legacy = (!colorSupport);
		if(colorSupport){
			System.out.print(String.format("\033[%dA",1)); // Move up
			System.out.print("\033[2K"); // Erase line content
		}
		//sc.close();
		System.out.println("------info config------");
		System.out.println("Charset defaut  : " + Charset.defaultCharset());
		System.out.println("file encoding   : " + System.getProperty("file.encoding"));
		System.out.println("support couleur : " + colorSupport);
		System.out.println("legacy mode     : " + legacy);
		System.out.println("------------------------");
		if(legacy){
			visualInterface = new LegacyTerminalInterface(players);
		} else {
			visualInterface = new TerminalInterface(players);
		}

		//TODO modifier le currentid
		this.game = new Game(players, pile, currentCards, visualInterface,true,0,sc);

		//TODO menu
		this.game.start();
	}

	public void loadConf(Deck pile, Deck currentCards, ArrayList<Player> players){
		//TODO implementation du chargement de sauvegarde/configuration
		players.add(new Player(PlayerType.Human));
		players.add(new Player(PlayerType.Human));
		players.add(new Player(PlayerType.Auto));
		players.add(new Player(PlayerType.None));

		players.get(0).cards.addBuilder(pile.pickBuilder(1));
		players.get(1).cards.addBuilder(pile.pickBuilder(2));
		players.get(2).cards.addBuilder(pile.pickBuilder(3));

		currentCards.addBuild(pile.pickRandomBuild());
		currentCards.addBuild(pile.pickRandomBuild());
		currentCards.addBuild(pile.pickRandomBuild());
		currentCards.addBuild(pile.pickRandomBuild());
		currentCards.addBuild(pile.pickRandomBuild());

		currentCards.addBuilder(pile.pickRandomBuilder());
		currentCards.addBuilder(pile.pickRandomBuilder());
		currentCards.addBuilder(pile.pickRandomBuilder());
		currentCards.addBuilder(pile.pickRandomBuilder());
		currentCards.addBuilder(pile.pickRandomBuilder());
	}

	public void createCards(Deck pile) {
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

}
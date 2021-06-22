import controller.GameLauncher;

/**
 * l'entrée du programme
 */
public class Start {

	/**
	 * le point d'entrée du programme
	 * @param args les arguments de commande
	 */
	public static void main(String[] args) {
		if(args.length != 0 && args[0].equals("terminal")){
			new GameLauncher(true);
		} else {
			new GameLauncher(false);
		}
	}

}
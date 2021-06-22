package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * le listener, réagis au actions de l'utilisateur
 */
public class Listener implements ActionListener {

	/**
	 * le jeu en cours
	 */
	Game game;

	/**
	 * crées un nouveau listener
	 */
	public Listener(){
	}
	
	/**
	 * definis le game en cours
	 * @param game le game en cours
	 */
	public void setGame(Game game){
		this.game = game;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.game.makeAction(e.getActionCommand());
	}

	/**
	 * fait une action
	 * @param s l'action a faire
	 */
	public void makeAction(String s){
		this.game.makeAction(s);
	}

}
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Listener implements ActionListener {

	Game game;
	public Listener(){
	}
	
	public void setGame(Game game){
		this.game = game;

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.game.makeAction(e.getActionCommand());
	}

	public void makeAction(String s){
		this.game.makeAction(s);
	}

}
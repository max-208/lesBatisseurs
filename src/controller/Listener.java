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
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		this.game.makeAction(e.getActionCommand());
	}

}
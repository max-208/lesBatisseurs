package controller;

import java.util.*;
import model.*;
import view.*;

public class Game implements IGame {

	private ArrayList<Player> players;
	private Deck pile;
	private Deck currentCards;
	private Player current;
	private VisualInterface visualInterface;
	private int currentId;

	public Game(ArrayList<Player> players,Deck pile,Deck currentCards,VisualInterface visualInterface){
		

	}

	public void changeCurrentPlayer() {
		// TODO - implement Game.changeCurrentPlayer
		throw new UnsupportedOperationException();
	}

	public void play() {
		// TODO - implement Game.play
		throw new UnsupportedOperationException();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}

import java.util.*;
import model.*;

public class Start {

	/**
	 * le point d'entrée du programme
	 * @param args les arguments de commande
	 */
	public static void main(String[] args) {
		// TODO - implement Start.Main
		System.out.println("main");
		Player p = new Player(PlayerType.Auto);

		Build b0 = new Build(0, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b1 = new Build(1, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b2 = new Build(2, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b3 = new Build(3, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b4 = new Build(4, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b5 = new Build(5, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b6 = new Build(6, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b7 = new Build(7, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b8 = new Build(8, "manoir", 1 , 1, false, 1, 1, 1, 1);
		Build b9 = new Build(9, "manoir", 1 , 1, false, 1, 1, 1, 1);
		
		p.cards.addBuild(b0);
		p.cards.addBuild(b1);
		p.cards.addBuild(b2);
		p.cards.addBuild(b3);
		p.cards.addBuild(b4);
		p.cards.addBuild(b5);
		p.cards.addBuild(b6);
		p.cards.addBuild(b7);
		p.cards.addBuild(b8);
		p.cards.addBuild(b9);

		p.cards.getBuild(3).demarrerChantier();
		p.cards.getBuild(4).demarrerChantier();
		p.cards.getBuild(5).demarrerChantier();

		Builder bu1 = new Builder(10, 1, BuilderType.Apprenti, 1, 1, 1, 1);
		Builder bu2 = new Builder(11, 1, BuilderType.Apprenti, 1, 1, 1, 1);
		p.cards.addBuilder(bu1);
		p.cards.addBuilder(bu2);

		p.cards.getBuild(6).demarrerChantier();
		p.cards.getBuild(7).demarrerChantier();
		p.cards.getBuild(8).demarrerChantier();
		p.cards.getBuild(6).addBuilder(bu2);
		p.cards.getBuild(7).addBuilder(bu2);
		p.cards.getBuild(8).addBuilder(bu2);

		ArrayList<IBuild> l = p.afficherBatiment(0);
		Iterator<IBuild> it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
		System.out.println("");

		l = p.afficherBatiment(1);
		it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
		System.out.println("");

		l = p.afficherchantiers(0);
		it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
		System.out.println("");

		l = p.afficherchantiers(1);
		it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
		System.out.println("");

		ArrayList<IBuilder> lb = p.afficherOuvriers(0);
		Iterator<IBuilder> itb = lb.iterator();
		while(itb.hasNext()){
			System.out.println(itb.next().getId());
		}
		System.out.println("");

	}

}
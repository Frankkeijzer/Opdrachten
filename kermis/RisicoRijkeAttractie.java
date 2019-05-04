package opdrachten.kermis;

import java.util.Scanner;

abstract class RisicoRijkeAttractie extends Attractie{
	int limiet;
	boolean doorgaan = true;
	
	boolean testenLimiet() {
		if (--limiet < 1) {
			doorgaan = false;
		}
		return doorgaan;
	}
	
	void opstellingsKeuring() {
		System.out.println("De opstelling van " + naam + " wordt gekeurd, even geduld.\n");
	}
	
	boolean Onderhoudsbeurt(){
		System.out.println("De attractie " + naam + " moet gecontroleerd worden. Voor het sturen van een monteur toets \"m\".");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toLowerCase();
		if (input.contentEquals("m")) {
			System.out.println("Controle wordt uitgevoerd");
			doorgaan = true;
		} else {
			System.out.println("Je stuurt geen monteur voor controle de attractie " + naam + " blijft gesloten.");
			doorgaan = false;
		}
		return doorgaan;
	}
}

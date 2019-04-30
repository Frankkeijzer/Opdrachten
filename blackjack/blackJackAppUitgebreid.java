package opdrachten.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class blackJackAppUitgebreid {

	public static void main(String[] args) {
/*
		System.out.print("Welkom bij Black Jack, voer uw naam in: ");
	    
	    String naam = schermInput();
	    
		speler p1 = new speler(naam);
	    
		// Maak een kaartspel en schud de kaarten door elkaar.
//		ArrayList<String >kleurenKaarten = samenStellenStock();
		
		String[] kleuren = {"Harten ", "Klaver ", "Ruiten ", "Schoppen "};
		String[] kaarten = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "V", "H", "A"};
		ArrayList<String> kleurenKaarten = new ArrayList<>();
		
		for(String kleur : kleuren) {
			for (String kaart : kaarten) {
				kleurenKaarten.addAll(Arrays.asList(kleur + kaart));
			}
		} 

		ArrayList<String >randomKaarten = schudden(kleurenKaarten);

		System.out.println(p1.naam + " , de kaarten zijn geschud, kies \"k\" voor een kaart, \"p\" om te passen en \"q\" om te stoppen.");
		
		String input = schermInput();
		input = input.toLowerCase();
		
		while (input.equals("k") ) {
			ArrayList<String> hand = new ArrayList<>();
			for (int i = 0; i < randomKaarten.size(); i++) {
				hand.add(randomKaarten.get(i));
				//System.out.println(randomKaarten.get(i));
				//System.out.println(hand.get(i));
				String gekregenKaart = hand.get(i);
				
				int waarde = kaartwaarde(gekregenKaart);
				System.out.println("Je Kaart is "+ randomKaarten.get(i) + " de waarde is: " );
				System.out.println("Wil je nog een kaart kies kies \"k\" voor een kaart, of \"p\" om te passen.");
				input = schermInput();
			}
		}
		switch (input) {
		case "p":
			passen();
			break;
		case "q":
			stoppen();
			break;
		default:
			System.out.println("Je hebt geen juiste waarde gekozen, het spel wordt beeindigd.");
			break;	
		}
		
*/	
//einde PSVM		
	}
	
	public static String schermInput( ) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	
	public static ArrayList<String> samenStellenStock(){
		String[] kleuren = {"Harten ", "Klaver ", "Ruiten ", "Schoppen "};
		String[] kaarten = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "V", "H", "A"};

		ArrayList<String> kleurenKaarten = new ArrayList<>();
		
		for(String kleur : kleuren) {
			for (String kaart : kaarten) {
				kleurenKaarten.addAll(Arrays.asList(kleur + kaart));
			}
		} 
		
		return kleurenKaarten;
	}
	
	public static ArrayList<String> schudden(ArrayList<String> kleurenKaarten){
		
		ArrayList<String> randomKaarten = new ArrayList<>();
		
		//randomize: bepalen random positie voor het array
/*		Collections.shuffle(kleurenKaarten);
		
		//Printen van de random kaarten
		for (int i = 0; i < kleurenKaarten.size(); i++) {
				System.out.println(i + ": " + kleurenKaarten.get(i));
		}
*/
		
		for (int i = 0 ; i < kleurenKaarten.size() ; ) {
			Random nummer = new Random();
			int positieKaart = nummer.nextInt(kleurenKaarten.size());
			randomKaarten.add(kleurenKaarten.get(positieKaart));
			kleurenKaarten.remove(positieKaart);
/*		
			//Printen van de random kaarten
					for (int x = 0; x < randomKaarten.size(); x++) {
							System.out.println(x + ": " + randomKaarten.get(x));
						}
*/
		}
		return randomKaarten;
	}
	
	public static void passen() {
		System.out.println("Je hebt \"p\" gekozen. De totale waarde van je kaarten is: ");
	}
	
	public static void stoppen() {
		System.out.println("Je hebt \"q\" gekozen en daarmee het spel gestopt. Tot de volgende keer.");
	}

	public static int kaartwaarde(String gekregenKaart) {
		int kaartwaarde = 0;
		
		char teken = gekregenKaart.charAt(gekregenKaart.length() -1);
		
		switch (teken) {
		case '2':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '3':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '4':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '5':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '6':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '7':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '8':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '9':
			kaartwaarde = Integer.parseInt(String.valueOf(teken));
			break;
		case '0':
		case 'B':
		case 'V':
		case 'H':
			kaartwaarde = 10;
			break;
		case 'A':
			kaartwaarde = 11;
			break;
		default:
			kaartwaarde = 0;
			break;
		}
		
		return kaartwaarde;
	}
	
//Einde class	
}

/*
class speler{
	//ArrayList<String> hand = new ArrayList<>();
	// Hand en punten horen bij 1 speler
	
	String naam;
	
	speler(String input){
		naam = input;	
	}
	
	//hand.add(randomKaarten.get(0));
	
}
*/
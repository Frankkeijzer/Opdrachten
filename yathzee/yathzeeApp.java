package opdrachten.yathzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class yathzeeApp {
	public static void main(String[] args) {
		
		yathzeeSpel yathzee = new yathzeeSpel();
		yathzee.opstarten();
		
	}
}

class yathzeeSpel{
	ArrayList<Dobbelsteen> Dobbelstenen = new ArrayList<>();
	int blokkeerArray[] = {0,0,0,0,0};
	
	yathzeeSpel(){
		for (int i = 0; i < 5; i++) {
		Dobbelstenen.add(i, new Dobbelsteen());
		}
	}

	void opstarten() {
System.out.println("We gaan Yathzee spelen!\n");
		
		System.out.println("Geef het aantal spelers op (max. 4 spelers): ");
		String aantalString = schermInput();
		Integer aantal = Integer.parseInt(aantalString);
		
		Speler speler1 = new Speler();
		Speler speler2 = new Speler();
		Speler speler3 = new Speler();
		Speler speler4 = new Speler();
		
		switch (aantal) {
		case 1:
			System.out.println("Je speelt alleen, geef je naam op: ");
			Scanner sp1naam1 = new Scanner(System.in);
			speler1.naamSpeler = sp1naam1.nextLine();

			System.out.println("Welkom, we gaan beginnen.");
			spelen(speler1);
			break;
		case 2:
			System.out.println("Je speelt met zijn tweeen, geef jullie namen op: ");
			Scanner sp2naam1 = new Scanner(System.in);
			speler1.naamSpeler = sp2naam1.nextLine();
			Scanner sp2naam2 = new Scanner(System.in);
			speler2.naamSpeler = sp2naam2.nextLine();
			
			System.out.println("Welkom, we gaan beginnen.");
			spelen(speler1);
			spelen(speler2);	
			break;
		case 3:
			System.out.println("Je speelt met zijn drieen, geef jullie namen op: ");
			Scanner sp3naam1 = new Scanner(System.in);
			speler1.naamSpeler = sp3naam1.nextLine();
			Scanner sp3naam2 = new Scanner(System.in);
			speler2.naamSpeler = sp3naam2.nextLine();
			Scanner sp3naam3 = new Scanner(System.in);
			speler3.naamSpeler = sp3naam3.nextLine();

			System.out.println("Welkom, we gaan beginnen.");
			spelen(speler1);
			spelen(speler2);
			spelen(speler3);
			break;
		case 4:
			System.out.println("Je speelt met zijn vieren, geef jullie namen op: ");
			Scanner sp4naam1 = new Scanner(System.in);
			speler1.naamSpeler = sp4naam1.nextLine();
			Scanner sp4naam2 = new Scanner(System.in);
			speler2.naamSpeler = sp4naam2.nextLine();
			Scanner sp4naam3 = new Scanner(System.in);
			speler3.naamSpeler = sp4naam3.nextLine();
			Scanner sp4naam4 = new Scanner(System.in);
			speler4.naamSpeler = sp4naam4.nextLine();
			
			System.out.println("Welkom, we gaan beginnen.");
			spelen(speler1);
			spelen(speler2);
			spelen(speler3);
			spelen(speler4);
			break;
		default:
			System.out.println("Je hebt een te groot aantal spelers ingevoerd, het spel wordt gestopt.");
			break;
		}
		System.out.println("Einde van het spel, tot de volgende keer!");
	}
	
	
	Scanner scanner = new Scanner(System.in);
	void spelen(Speler inputNaam) {
		Speler speler = inputNaam;
		
		int aantalWorpen = 1;
		boolean doorgaan = true;
		
		System.out.println("Druk op \"Enter\" om te gooien en \"q\" om te stoppen: ");
		
			while(doorgaan) {
				String invoer = scanner.nextLine().toLowerCase();
				
				//String invoer = schermInput().toLowerCase();
				switch(invoer) {
				case "":
					int c = 0;
					System.out.println("\tWorp " + aantalWorpen++ + ":");
					System.out.println("\t \tPositie: 1" + "\t2 \t3 \t4 \t5");
					
					Worp w = new Worp();
					for (Dobbelsteen dobbelsteen : Dobbelstenen) {
							if (blokkeerArray[c] == 0 ) {
								dobbelsteen.worp = dobbelsteen.werpen();
								w.worpUitslag[c] = dobbelsteen.worp;
								speler.worpGeschiedenis.add(w.worpUitslag[c]);
							} else {
								w.worpUitslag[c] = dobbelsteen.worp;
								speler.worpGeschiedenis.add(w.worpUitslag[c]);
							}
					c++;
					}

					w.uitslag();
					/*
					for (int i = 0; i < w.worpUitslag.length; i++) {
						speler.worpGeschiedenis.add(w.worpUitslag[i]);
					}
					*/
					System.out.print("\n\nDe eerdere waarde van je beurt(en) was/waren:");
					for (int i= 0; i < speler.worpGeschiedenis.size() ;i++ ) {
						if(i % 5 == 0) {
							System.out.println("");
						}
						System.out.print(speler.worpGeschiedenis.get(i) + " ");
					}
					
					vasthouden();
					
					System.out.println("Druk op \"Enter\" om te gooien en \"q\" om te stoppen: ");
					
					break;
				case "q":
						System.out.println("Het spel wordt gestopt");
						doorgaan = false;
						break;
				default:
						System.out.println("foutieve invoer, probeer het opnieuw");
				}
		}
	}
	
	class Speler{
		String naamSpeler;
		
		ArrayList<Integer> worpGeschiedenis = new ArrayList<>();
	}
	
	class Dobbelsteen {
		int worp;
		
		int werpen(){
			Random rnd = new Random();
			worp = rnd.nextInt(6) + 1;
			return worp;
		}
	}
	
	class Worp{
		int worpUitslag[] = new int[5];
		
		void uitslag() {
			System.out.print("De gegooide stenen zijn: ");
			for (int i = 0; i < worpUitslag.length; i++) {
				System.out.print(worpUitslag[i] + "\t");
			}
			System.out.print("Weergegeven nullen zijn de eerder vastgezette posities.");
		}
	}
	
	public static String schermInput( ) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	
	void vasthouden(){
		
		System.out.println("\n\nWelke posities wil je vasthouden, geef de waarde van de positie (met 0 maak je geen keuze): ");
		//Scanner sc = new Scanner(System.in);
		//String input = sc.nextLine();
		
		String input = schermInput();
		
		if (input.equals("0")) {
			System.out.print("Je hebt er voor gekozen om geen dobbelstenen vast te zetten. ");
		} else {
			for (int i = 0; i < input.length(); i++) {
				String inputSub = input.substring(i, i+1);
				Integer inputIndex = Integer.parseInt(inputSub) - 1;
				blokkeerArray[inputIndex] = 1;
			}
		}
		
		/*
		for (int i= 0; i<blokkeerArray.length;i++ ) {
			System.out.print(blokkeerArray[i]);
		}
		*/
		/*
		for (int i = 0; i < input.length(); i++) {
			Integer inputInt = (int) input.charAt(i);
			int inputIndex = inputInt - 49;
			blokkeerArray[inputIndex] = 1;
		}*/	
	}
	
}
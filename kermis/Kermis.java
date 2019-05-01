package opdrachten.kermis;

import java.util.Scanner;

class Kermis {
	boolean open = true;
	
	void Open(){
		Attractie botsauto = new Botsauto();
		RisicoRijkeAttractie spin = new Spin();
		Attractie spiegelpaleis = new Spiegelpaleis();
		Attractie spookhuis = new Spookhuis();
		RisicoRijkeAttractie hawaii = new Hawaii();
		Attractie ladderklimmen = new Ladderklimmen();
		Kassa kassa = new Kassa();
		
		spin.opstellingsKeuring();
		hawaii.opstellingsKeuring();
		System.out.println("De kermis is open en de attracties draaien, voor welke attractie is er een kaart verkocht?\n");
		while (open) {
			System.out.println("1: De Botsauto's\n2: De Spin\n3: Het Spiegelpaleis\n4: Het Spookhuis\n5: De Hawaii\n6: Ladderklimmen\no: Tonen omzet per atractie en totaal\nk: Tonen het aantal verkochte kaartjes per attractie en totaal\nq: Stop de applicatie\n");
			System.out.println("Geef het nummer van de attractie in of \"q\" om te stoppen: ");
			String input = schermInput();
			
			switch(input) {
			case "1":
				botsauto.Draaien();
				kassa.Omzet(botsauto.prijs);
				break;
			case "2":
				if (spin.doorgaan) {
					spin.Draaien();
					kassa.Omzet(spin.prijs);
					spin.doorgaan = spin.testenLimiet();
				} else {
					spin.doorgaan = spin.Monteur();
					spin.limiet = 5;
				}
				break;
			case "3":
				spiegelpaleis.Draaien();
				kassa.Omzet(spiegelpaleis.prijs);
				break;
			case "4":
				spookhuis.Draaien();
				kassa.Omzet(spookhuis.prijs);
				break;
			case "5":
				if (hawaii.doorgaan) {
					hawaii.Draaien();
					kassa.Omzet(hawaii.prijs);
					hawaii.doorgaan = hawaii.testenLimiet();
				} else {
					hawaii.doorgaan = hawaii.Monteur();
					hawaii.limiet = 5;
				}
				break;
			case "6":
				ladderklimmen.Draaien();
				kassa.Omzet(ladderklimmen.prijs);
				double belastingLadderklimmen =((gokAttractie) ladderklimmen).kansSpelBelastingBetalen();
				System.out.println("even ladderklimmen info " + belastingLadderklimmen);
				break;
			case "o":
				System.out.println("\nHuidige omzet:");
				System.out.println(botsauto.naam + ":\t\t" + botsauto.omzet);
				System.out.println(spin.naam + ":\t\t" + spin.omzet);
				System.out.println(spiegelpaleis.naam + ":\t" + spiegelpaleis.omzet);
				System.out.println(spookhuis.naam + ":\t\t" + spookhuis.omzet);
				System.out.println(hawaii.naam + ":\t\t" + hawaii.omzet);
				System.out.println(ladderklimmen.naam + ":\t\t" + ladderklimmen.omzet);
				System.out.println("TOTAAL:\t\t\t" + kassa.omzet + "\n");
				break;
			case "k":
				System.out.println("\nVerkochtte kaartjes:");
				System.out.println(botsauto.naam + ":\t\t"+ botsauto.kaartje);
				System.out.println(spin.naam + ":\t\t" + spin.kaartje);
				System.out.println(spiegelpaleis.naam + ":\t" + spiegelpaleis.kaartje);
				System.out.println(spookhuis.naam + ":\t\t" + spookhuis.kaartje);
				System.out.println(hawaii.naam + ":\t\t" + hawaii.kaartje);
				System.out.println(ladderklimmen.naam + ":\t\t" + ladderklimmen.kaartje);
				System.out.println("TOTAAL:\t\t\t" + kassa.kaartje + "\n");
				break;
			case "q":
				System.out.println("De kermis is gesloten, de totale omzet van vandaag is " + kassa.omzet + ". Er zijn in totaal " + kassa.kaartje + " kaartjes verkocht.");
				open = false;
				break;
			default:
				System.out.println("Je invoer is niet juist, probeer het nog een keer.\n\n");
				break;
			
			}
		}
		
	}
	
	void startKermis() {
		Attractie botsauto = new Botsauto();
		Attractie spin = new Spin();
	}
	
	static String schermInput( ) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

}

package opdrachten.kermis;

import java.util.Scanner;

class Kermis {
	boolean open = true;
	
	void Open(){
		System.out.println("De kermis is open en de attracties draaien, voor welke attractie is er een kaart verkocht?\n");
		
		Attractie botsauto = new Botsauto();
		Attractie spin = new Spin();
		Attractie spiegelpaleis = new Spiegelpaleis();
		Attractie spookhuis = new Spookhuis();
		Attractie hawaii = new Hawaii();
		Attractie ladderklimmen = new Ladderklimmen();
		Kassa kassa = new Kassa();
		
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
				spin.Draaien();
				kassa.Omzet(spin.prijs);
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
				hawaii.Draaien();
				kassa.Omzet(hawaii.prijs);
				break;
			case "6":
				ladderklimmen.Draaien();
				kassa.Omzet(ladderklimmen.prijs);
				break;
			case "o":
				System.out.println("De totale omzet tot nu toe is " + kassa.omzet);
				System.out.println("De omzet van " + botsauto.naam + " is tot nu toe " + botsauto.omzet + " geweest.");
				System.out.println("De omzet van " + spin.naam + " is tot nu toe " + spin.omzet + " geweest.");
				System.out.println("De omzet van " + spiegelpaleis.naam + " is tot nu toe " + spiegelpaleis.omzet + " geweest.");
				System.out.println("De omzet van " + spookhuis.naam + " is tot nu toe " + spookhuis.omzet + " geweest.");
				System.out.println("De omzet van " + hawaii.naam + " is tot nu toe " + hawaii.omzet + " geweest.");
				System.out.println("De omzet van " + ladderklimmen.naam + " is tot nu toe " + ladderklimmen.omzet + " geweest.");
				break;
			case "k":
				System.out.println("Het aantal kaartjes dat is verkocht tot nu toe zijn " + kassa.kaartje);
				System.out.println("Het aantal kaartjes dat tot nu toe is verkocht voor " + botsauto.kaartje);
				System.out.println("Het aantal kaartjes dat tot nu toe is verkocht voor " + spin.kaartje);
				System.out.println("Het aantal kaartjes dat tot nu toe is verkocht voor " + spiegelpaleis.kaartje);
				System.out.println("Het aantal kaartjes dat tot nu toe is verkocht voor " + spookhuis.kaartje);
				System.out.println("Het aantal kaartjes dat tot nu toe is verkocht voor " + hawaii.kaartje);
				System.out.println("Het aantal kaartjes dat tot nu toe is verkocht voor " + ladderklimmen.kaartje);
				break;
			case "q":
				System.out.println("De kermis is gesloten, de totale omzet van vandaag is " + kassa.omzet);
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

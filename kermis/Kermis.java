package opdrachten.kermis;

import java.util.Scanner;

class Kermis {
	boolean open = true;
	Attractie botsauto = new Botsauto();
	RisicoRijkeAttractie spin = new Spin();
	Attractie spiegelpaleis = new Spiegelpaleis();
	Attractie spookhuis = new Spookhuis();
	RisicoRijkeAttractie hawaii = new Hawaii();
	Attractie ladderklimmen = new Ladderklimmen();
	Kassa kassa = new Kassa();

	
	void Open(){
		spin.opstellingsKeuring();
		hawaii.opstellingsKeuring();
		kassa.inspecteur.Inspecteren();

		System.out.println("De kermis is open en de attracties draaien, voor welke attractie is er een kaart verkocht?\n");
		
		while (open) {
			System.out.println("1: De Botsauto's\n2: De Spin\n3: Het Spiegelpaleis\n4: Het Spookhuis\n5: De Hawaii\n6: Ladderklimmen\no: Tonen omzet per atractie en totaal\nk: Tonen het aantal verkochte kaartjes per attractie en totaal\nq: Stop de applicatie\n");
			System.out.println("Geef het nummer van de attractie in of \"q\" om te stoppen: ");
			String input = schermInput().toLowerCase();
			
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
					((Spin) spin).kansSpelBelastingBetalen();
					uitvoerenInspectie();
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
					hawaii.doorgaan = hawaii.Onderhoudsbeurt();
					hawaii.limiet = 5;
				}
				break;
			case "6":
				ladderklimmen.Draaien();
				kassa.Omzet(ladderklimmen.prijs);
				((Ladderklimmen) ladderklimmen).kansSpelBelastingBetalen();
				uitvoerenInspectie();
				break;
			case "o":
				omzetPrint();
				break;
			case "k":
				kaartenPrint();
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
	
	void uitvoerenInspectie() {
		if (ladderklimmen.kaartje + spin.kaartje == kassa.inspecteur.inspectie) {
			System.out.print("De inspecteur komt, de te betalen belasting is ");
			System.out.println(((Ladderklimmen) ladderklimmen).kansSpelBelasting + ((Spin) spin).kansSpelBelasting - ((Ladderklimmen) ladderklimmen).omzetBelastingBetaald - ((Spin) spin).omzetBelastingBetaald);
			((Ladderklimmen) ladderklimmen).omzetBelastingBetaald = ((Ladderklimmen) ladderklimmen).kansSpelBelasting;
			((Spin) spin).omzetBelastingBetaald = ((Spin) spin).kansSpelBelasting;
			kassa.inspecteur.Inspecteren();
		} else {
			spin.doorgaan = spin.Onderhoudsbeurt();
			spin.limiet = 5;
		}
	}
	
	void omzetPrint() {
		System.out.println("\nHuidige omzet:");
		System.out.println(botsauto.naam + ":\t\t" + botsauto.omzet);
		System.out.println(spin.naam + ":\t\t" + spin.omzet);
		System.out.println(spiegelpaleis.naam + ":\t" + spiegelpaleis.omzet);
		System.out.println(spookhuis.naam + ":\t\t" + spookhuis.omzet);
		System.out.println(hawaii.naam + ":\t\t" + hawaii.omzet);
		System.out.print(ladderklimmen.naam + ":\t\t");
		System.out.println(ladderklimmen.omzet - ((Ladderklimmen) ladderklimmen).omzetBelastingBetaald);
		System.out.print("TOTAAL:\t\t\t");
		System.out.println(kassa.omzet - ((Ladderklimmen) ladderklimmen).omzetBelastingBetaald + "\n");
	}
	
	void kaartenPrint() {
		System.out.println("\nVerkochtte kaartjes:");
		System.out.println(botsauto.naam + ":\t\t"+ botsauto.kaartje);
		System.out.println(spin.naam + ":\t\t" + spin.kaartje);
		System.out.println(spiegelpaleis.naam + ":\t" + spiegelpaleis.kaartje);
		System.out.println(spookhuis.naam + ":\t\t" + spookhuis.kaartje);
		System.out.println(hawaii.naam + ":\t\t" + hawaii.kaartje);
		System.out.println(ladderklimmen.naam + ":\t\t" + ladderklimmen.kaartje);
		System.out.println("TOTAAL:\t\t\t" + kassa.kaartje + "\n");
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

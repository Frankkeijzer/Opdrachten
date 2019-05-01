package opdrachten.kermis;


abstract class Attractie {
	String naam;
	double prijs;
	double oppervlakte;
	double omzet;
	int kaartje;
	
	void Draaien(){
		System.out.println(naam + " draait.");
		omzet += prijs;
		//System.out.println(kaartje);
		kaartje++;
		//System.out.println(kaartje);
	}
}

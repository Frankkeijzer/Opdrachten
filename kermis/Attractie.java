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
		kaartje++;
	}
}

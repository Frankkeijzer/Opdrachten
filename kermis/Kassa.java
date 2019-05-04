package opdrachten.kermis;

class Kassa {
	double omzet = 0.0;
	int kaartje = 0;
	
	void Omzet (double prijs){
		 omzet = prijs + omzet;
		 kaartje++;
	}
	
	
}

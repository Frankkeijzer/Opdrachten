package opdrachten.kermis;

class Kassa {
	double omzet = 0.0;
	int kaartje = 0;
	
	BelastingInspecteur inspecteur = new BelastingInspecteur();
	
	void Omzet (double prijs){
		 omzet = prijs + omzet;
		 kaartje++;
	}
	
	void belastingbetalen ( ) {
		inspecteur.Inspecteren();
	}
	
	
}

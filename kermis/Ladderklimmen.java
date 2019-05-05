package opdrachten.kermis;

class Ladderklimmen extends Attractie implements gokAttractie{
	double kansSpelBelasting;
	double omzetBelastingBetaald;
	
	Ladderklimmen(){
		naam = "Ladderklimmen";
		prijs = 5.00;
		oppervlakte = 4.55;
	}

	@Override
	public void kansSpelBelastingBetalen() {
		kansSpelBelasting = omzet * percentageBelasting;
	}
	
	
		

}

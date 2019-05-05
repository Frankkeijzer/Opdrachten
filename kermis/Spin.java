package opdrachten.kermis;

public class Spin extends RisicoRijkeAttractie implements gokAttractie{
	double kansSpelBelasting;
	double omzetBelastingBetaald;
	
	Spin(){
		naam = "De Spin";
		prijs = 2.25;
		oppervlakte = 10.95;
		limiet = 5;
	}

	@Override
	public void kansSpelBelastingBetalen() {
		kansSpelBelasting = omzet * percentageBelasting;
		
	}
	
}

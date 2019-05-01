package opdrachten.kermis;

public class Ladderklimmen extends Attractie implements gokAttractie{
	double kansSpelBelasting;

	Ladderklimmen(){
		naam = "Ladderklimmen";
		prijs = 5.00;
		oppervlakte = 4.55;
	}

	@Override
	public double kansSpelBelastingBetalen() {
		return kansSpelBelasting = omzet * 0.3;
		
	}
}

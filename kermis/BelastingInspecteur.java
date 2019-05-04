package opdrachten.kermis;

import java.util.Random;

class BelastingInspecteur {
	int inspectie;
	
	void Inspecteren(){
		Random getal = new Random();
		int randomInspectie = getal.nextInt(3) + 1;
//		inspectie = getal.nextInt(14) + 1;
		inspectie = inspectie + randomInspectie;
		System.out.println("Random inspectie " + inspectie);
	}
	
	
}

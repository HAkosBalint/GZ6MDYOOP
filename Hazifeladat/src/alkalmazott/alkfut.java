package alkalmazott;

public class alkfut {

	public static void main(String[] args) {
		alkalmazott[] alkTomb = new alkalmazott[5];
				
		feltolt(alkTomb);
		kiir(alkTomb);
		
		alkalmazott maxFiz = getLegmagasabbFiz(alkTomb);
		System.out.println("A legnagyobb: " + maxFiz.getAdatok());
		
		System.out.println("10 es 40 koze eso: " + getIntervallum(alkTomb,10,40));
		System.out.println("Az atlagfizetes" + getAtlag(alkTomb));
		System.out.println("Ado: " + getAdo(alkTomb));
		
		
		//Hazi 5.gyakorlat
		
		alkalmazott sz1 = new alkalmazott("Akos",600000);
		
		System.out.println(sz1.toString());
		
		sz1 = new alkalmazott("Remelem jo");
		
		System.out.println(sz1.toString());
		
		
		
		
		
	}
	
	private static void feltolt(alkalmazott[] alkTomb) {
		for (int i = 0; i < alkTomb.length; i++) {
			alkTomb[i] = new alkalmazott("Babu" + i,(int) (Math.random()*50+1));
			
		}
	}
	
	private static void kiir(alkalmazott[] alkTomb) {
		for (int i = 0; i < alkTomb.length; i++) {
			System.out.println(alkTomb[i].getAdatok());
		}
		
	}
	
	private static alkalmazott getLegmagasabbFiz(alkalmazott[] input) {
		alkalmazott max = input[0];
		
		for(alkalmazott alk : input) {
			if(alk.getFizetes() > max.getFizetes()) {
				max = alk;
			}
		}
		
		return max;
	}
	
	private static int getIntervallum(alkalmazott[] input, int also, int felso) {
		int db = 0;
		
		for(alkalmazott alk : input) {
			if(alk.getFizhatarok(also,felso))
				db++;
		}
		
		return db;
	}
	private static double getAtlag(alkalmazott[] input) {
		double sum = 0;
		
		for(alkalmazott alk : input) {
			sum += alk.getFizetes();
		}
		
		return sum / input.length;
	}
	private static double getAdo(alkalmazott[] input) {
		int sum = 0;
		
		for(alkalmazott alk : input) {
			sum += alk.getAdo();
		}
		
		return sum;
	}


}

package alkalmazott;

public class alkalmazott {
	private String nev;
	private int fizetes;
	
	public alkalmazott(String nev, int fizetes) {
		this.nev = nev;
		this.fizetes = fizetes;
	}
	
	public alkalmazott(String nev) {
		this.nev = nev;
		this.fizetes = 250000;
	}
	

	@Override
	public String toString() {
		return "alkalmazott [nev=" + nev + ", fizetes=" + fizetes + "]";
	}


	public void fizetesNovel(int ertek) {
		this.fizetes += ertek;
	}

	public String getAdatok() {
		return "Nev: " + this.nev + " Fizetes: " + this.fizetes;
	}
	
	public int getFizetes() {
		return this.fizetes;
	}
	
	public void setNev(String nev) {
		this.nev = nev;
	}
	public void setFizetes(int fizetes){
		this.fizetes = fizetes;
	}
	
	public boolean getFizhatarok(int also, int felso) {
		if(this.fizetes < felso && this.fizetes > also)
			return true;
		
		return false;
	}
	
	public double getAdo()
	{
		return this.fizetes * (16/100);
	}
	
	
	public boolean getAlkFizNagyobb(alkalmazott alk) {
		if(this.fizetes > alk.fizetes)
			return true;
		
		return false;
	}

}

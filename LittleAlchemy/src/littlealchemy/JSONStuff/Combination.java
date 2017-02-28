


public class Combination{

	//Istanze dell'oggetto: contendono il primo e il secondo elemento di una combinazione.
	private String first;
	private String second;


	//Costruttore di un oggetto Combination.
	public Combination(String first, String second){
		this.first = first;
		this.second = second;
	}

	//Metodi della classe

	public String getFirst(){
		return this.first;
	}

	public String getSecond(){
		return this.second;
	}

	public boolean equals(Combination comb){
		if(this.first.equals(comb.getFirst()) && this.second.equals(comb.getSecond()))
		return true;
		else
		return false;
	}

	public String toString(){
		return "Primo elemento: "+this.first+"; Secondo elemento: "+this.second;
	}

}
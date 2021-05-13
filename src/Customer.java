
public class Customer {
	
	private static int costNrCount = 0;
	String name;
	long id;
	int costumerNr;
	
	/**
	* Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'.
	* Kunden tilldelas ocks� ett unikt kundnummer.
	*/
	public Customer(String name, long idNr){
		this.name = name;
		id = idNr;
		
		costumerNr = costNrCount;
		costNrCount++;
	}
	/** Tar reda p� kundens namn. */
	String getName(){
		return name;
	}
	/** Tar reda p� kundens personnummer. */
	long getIdNr(){
		return id;
	}
	/** Tar reda p� kundens kundnummer. */
	int getCustomerNr(){
		return costumerNr;
	}
	/** Returnerar en str�ngbeskrivning av kunden. */
	public String toString(){
		return name;
	}
}

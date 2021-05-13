
public class Costumer {
	
	private static int costNrCount = 0;
	String name;
	long id;
	int costumerNr;
	
	/**
	* Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'.
	* Kunden tilldelas också ett unikt kundnummer.
	*/
	public Costumer(String name, long idNr){
		this.name = name;
		id = idNr;
		
		costumerNr = costNrCount;
		costNrCount++;
	}
	/** Tar reda på kundens namn. */
	String getName(){
		return name;
	}
	/** Tar reda på kundens personnummer. */
	long getIdNr(){
		return id;
	}
	/** Tar reda på kundens kundnummer. */
	int getCustomerNr(){
		return costumerNr;
	}
	/** Returnerar en strängbeskrivning av kunden. */
	public String toString(){
		return name;
	}
}

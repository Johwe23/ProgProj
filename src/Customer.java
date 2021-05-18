
public class Customer {
	
	private static int custNrCount = 0;
	private String name;
	private long id;
	private int customerNr;
	
	/**
	* Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'.
	* Kunden tilldelas ocks� ett unikt kundnummer.
	*/
	public Customer(String name, long idNr){
		this.name = name;
		id = idNr;
		
		customerNr = custNrCount;
		custNrCount++;
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
		return customerNr;
	}
	/** Returnerar en str�ngbeskrivning av kunden. */
	public String toString(){
		return name + ", " + "ID " + id + ", " + "customer nr: " + customerNr;
	}
}

import java.util.ArrayList;

public class Bank {
	
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	/** Skapar en ny bank utan konton. */
	/**
	* �ppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna ska inte en ny Customer skapas, utan ist�llet
	* den befintliga anv�ndas. Det nya kontonumret returneras.
	*/
	public int addAccount(String holderName, long idNr){
		accounts.add(new BankAccount(holderName, idNr));
		
	}
	
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen s�dan finns.
	*/
	public Customer findHolder(long idNr){
		
	}
	
	/**
	* Tar bort konto med nummer 'number' fr�n banken. Returnerar true om
	* kontot fanns (och kunde tas bort), annars false.
	*/
	public boolean removeAccount(int number){
		
	}
	
	/**
	* Returnerar en lista inneh�llande samtliga bankkonton i banken.
	* Listan �r sorterad p� kontoinnehavarnas namn.
	*/
	public ArrayList<BankAccount> getAllAccounts(){
		
	}
	
	/**
	* S�ker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	* Returnerar null om inget s�dant konto finns.
	*/
	public BankAccount findByNumber(int accountNumber){
		
	}
	
	/**
	* S�ker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'.
	* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	*/
	public ArrayList<BankAccount> findAccountsForHolder(long idNr){
		
	}
	/**
	* S�ker upp kunder utifr�n en s�kning p� namn eller del av namn. Alla
	* personer vars namn inneh�ller str�ngen 'namePart' inkluderas i
	* resultatet, som returneras som en lista. Samma person kan f�rekomma
	* flera g�nger i resultatet. S�kningen �r "case insensitive", det vill
	* s�ga g�r ingen skillnad p� stora och sm� bokst�ver.
	*/
	public ArrayList<Customer> findByPartofName(String namePart){
		
	}
}

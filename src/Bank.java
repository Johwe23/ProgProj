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
		int low = 0;
		int high = accounts.size() - 1;
		int mid = -1;
		while (low < high) { 
			mid = (low + high) / 2;
			if (accounts.get(mid).getHolder().getName() == holderName) {
				return accounts.get(mid).getAccountNumber();
				
			} else if (accounts.get(mid).getHolder().getName().compareTo(holderName) < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		BankAccount newAccount = new BankAccount(holderName, idNr);
		accounts.add(high, newAccount);
		
		return newAccount.getAccountNumber();
	}
	
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen s�dan finns.
	*/
	public Customer findHolder(long idNr){
		for (BankAccount account : accounts){
			if(account.getHolder().getIdNr() == idNr){
				return account.getHolder();
			}
		}
		
		return null;
	}
	
	/**
	* Tar bort konto med nummer 'number' fr�n banken. Returnerar true om
	* kontot fanns (och kunde tas bort), annars false.
	*/
	public boolean removeAccount(int number){
		BankAccount account = findByNumber(number);
		if(account == null){return false;}
		else{
			accounts.remove(account);
			return true;
		}
	}
	
	/**
	* Returnerar en lista inneh�llande samtliga bankkonton i banken.
	* Listan �r sorterad p� kontoinnehavarnas namn.
	*/
	public ArrayList<BankAccount> getAllAccounts(){
		return accounts;
	}
	
	/**
	* S�ker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	* Returnerar null om inget s�dant konto finns.
	*/
	public BankAccount findByNumber(int accountNumber){
		for (BankAccount account : accounts){
			if(account.getAccountNumber() == accountNumber){
				return account;
			}
		}
		
		return null;
	}
	
	/**
	* S�ker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'.
	* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	*/
	public ArrayList<BankAccount> findAccountsForHolder(long idNr){
		ArrayList<BankAccount> holderAccounts = new ArrayList<BankAccount>();
		
		for (BankAccount account : accounts){
			if(account.getHolder().getIdNr() == idNr){
				holderAccounts.add(account);
			}
		}
		
		return holderAccounts;
	}
	/**
	* S�ker upp kunder utifr�n en s�kning p� namn eller del av namn. Alla
	* personer vars namn inneh�ller str�ngen 'namePart' inkluderas i
	* resultatet, som returneras som en lista. Samma person kan f�rekomma
	* flera g�nger i resultatet. S�kningen �r "case insensitive", det vill
	* s�ga g�r ingen skillnad p� stora och sm� bokst�ver.
	*/
	public ArrayList<Customer> findByPartofName(String namePart){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		for (BankAccount account : accounts){
			if(account.getHolder().getName().contains(namePart)){
				customers.add(account.getHolder());
			}
		}
		
		return customers;
	}
}

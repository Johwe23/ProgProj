import java.util.ArrayList;

public class Bank {

	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	/** Skapar en ny bank utan konton. */

	public Bank(){
		addAccount("Daniel", 123);
		addAccount("Johan", 321);
		addAccount("Abraham", 456);
		addAccount("Klara", 453);
		addAccount("Sebastian", 976);
		addAccount("Torsten", 2578);
		
		addAccount("Gustav", 4567);
		addAccount("Agnes", 3467);
		addAccount("Lotta", 5463);
		
	}
	/**
	* �ppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna ska inte en ny Customer skapas, utan ist�llet
	* den befintliga anv�ndas. Det nya kontonumret returneras.
	*/
	public int addAccount(String holderName, long idNr){
		boolean added = false;
		int i = 0;
		while(i < accounts.size() - 1){
			if(accounts.get(i).getHolder().getName().compareTo(holderName) == 0 && accounts.get(i).getHolder().getIdNr() == idNr){
				accounts.add(i, new BankAccount(accounts.get(i).getHolder()));
				added = true;
				break;
			}
			else if(accounts.get(i).getHolder().getName().compareTo(holderName) >= 0){
				accounts.add(i, new BankAccount(new Customer(holderName, idNr)));
				added = true;
				break;
			}
			i++;
		}
		
		if(!added){
			accounts.add(new BankAccount(new Customer(holderName, idNr)));
		}
		
		return accounts.get(i).getAccountNumber();
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
		
		int index=0;
		while(index<accounts.size()) {
			if(accounts.get(index).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
					customers.add(accounts.get(index).getHolder());
			}
			index++;
			if(!customers.isEmpty()) {
				while (index<accounts.size()-1 && accounts.get(index).getHolder()==customers.get(customers.size()-1)) {
					index++;
				}
			}
		}

		return customers;
	}
}

import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	private Scanner scanner=new Scanner(System.in);
	private Bank bank=new Bank();
	
	public static void main(String[] args) {
		new BankApplication();
	}
	
	public BankApplication() {
		runApplication();
	}
	
	private void runApplication() {
		boolean running = true;
		while(running) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1: Find account(s) from the ID-number of the customer");
			System.out.println("2: Search for customer from (part of) name");
			System.out.println("3: Deposit.");
			System.out.println("4: Withrawal.");
			System.out.println("5: Transfer between accounts.");
			System.out.println("6: Create account.");
			System.out.println("7: Delete account.");
			System.out.println("8: Print all accounts (Sorted by customer name).");
			System.out.println("9: Exit.");
			//System.out.println("");
			System.out.println("");
			int choice=-1;

			while(!(0<choice && choice<10)) {
				System.out.print("Input choice of action: ");
				choice=expectInt();

				if(0<choice && choice<10) {
					break;
				} else {
					System.out.println("Please input one of the alternatives.");
					System.out.println("");
				}
				
			}
			
			switch (choice) {
				case 1: 
					findAccountByUserId();
					break;
				case 2: 
					findCustomerFromPartOfName();
					break;
				case 3:
					depositInAccount();
					break;
				case 4:
					withdrawFromAccount();
					break;	
				case 5:
					transferBetweenAmount();
					break;
				case 6:
					createAccount();
					break;
				case 7:
					removeAccount();
					break;
				case 8: 
					printAllAccounts();
					break;
				case 9:
					running = false;
					break;
				default:
					break;
			}
			
		}
	}
	
	private void findAccountByUserId() { //Alt 1
		System.out.println("");
		long ID=-1;
		do {
			System.out.print("Please enter a valid ID number: ");
			ID=expectLong();
		} while (ID<0);
		
		ArrayList<BankAccount> accounts = bank.findAccountsForHolder(ID);
		if(accounts.isEmpty()){
			System.out.println("No accounts found.");
			return;
		}
		for (BankAccount account : accounts) {
			System.out.println(account.toString());
		}
	}
	
	private void findCustomerFromPartOfName(){ //Alt 2
		System.out.print("Search for: ");
		String input = expectString();
		ArrayList<Customer> customers = bank.findByPartofName(input);
		if(customers.isEmpty()){
			System.out.println("No accounts found.");
		}
		for (Customer cust : customers){
			System.out.println(cust);
		}
	}

	private void depositInAccount() { //Alt 3
		System.out.println("");
		int accNbr=-1;
		boolean validAccNbr=false;
		do {
			do {
				System.out.print("Please enter a valid account number: ");
				accNbr=expectInt();
			} while (BankAccount.accountCounter<accNbr || accNbr<0);
			
			for (BankAccount account : bank.getAllAccounts()) {
				if(account.getAccountNumber()==accNbr) validAccNbr=true;
			}
		} while (!validAccNbr);
		
		double deposit=-1;
		do {
			System.out.print("Please enter a valid amount to deposit: ");
			deposit=expectDouble();
		} while (deposit<0);
		
		bank.findByNumber(accNbr).deposit(deposit);
		System.out.println(bank.findByNumber(accNbr));
	}
	
	private void withdrawFromAccount() { //Alt 4
		System.out.println("");
		int accNbr=-1;
		boolean validAccNbr=false;
		do {
			do {
				System.out.print("Please enter a valid account number: ");
				accNbr=expectInt();
			} while (BankAccount.accountCounter<accNbr || accNbr<0);
			
			for (BankAccount account : bank.getAllAccounts()) {
				if(account.getAccountNumber()==accNbr) validAccNbr=true;
			}
		} while (!validAccNbr);
		
		double withdrawal=-1;
		do {
			do {
				System.out.print("Please enter a valid amount to withdraw: ");
				withdrawal=expectDouble();
			} while (withdrawal<0);
			
			if(bank.findByNumber(accNbr).getAmount()<withdrawal) {
				System.out.println("Error, amount withdrawn greater than account balance.");
			}
		} while (bank.findByNumber(accNbr).getAmount()<withdrawal);
		
		
		bank.findByNumber(accNbr).withdraw(withdrawal);
		System.out.println(bank.findByNumber(accNbr));
	}
	
	private void transferBetweenAmount() { //Alt 5
		System.out.println("");
		int accNbrBen=-1;
		boolean validAccNbr=false;
		do {
			do {
				System.out.print("Please enter a valid account number to be the benefactor: ");
				accNbrBen=expectInt();
			} while (BankAccount.accountCounter<accNbrBen || accNbrBen<0);
			
			for (BankAccount account : bank.getAllAccounts()) {
				if(account.getAccountNumber()==accNbrBen) validAccNbr=true;
			}
		} while (!validAccNbr);
		
		int accNbrRec=-1;
		validAccNbr=false;
		do {
			do {
				System.out.print("Please enter a valid account number to be the recipient: ");
				accNbrRec=expectInt();
			} while ((BankAccount.accountCounter<accNbrRec || accNbrRec<0) && accNbrRec==accNbrBen);
			
			for (BankAccount account : bank.getAllAccounts()) {
				if(account.getAccountNumber()==accNbrRec) validAccNbr=true;
			}
		} while (!validAccNbr);
		
		double transfer=-1;
		do {
			do {
				System.out.print("Please enter a valid amount to withdraw: ");
				transfer=expectDouble();
			} while (transfer<0);
			
			if(bank.findByNumber(accNbrBen).getAmount()<transfer) {
				System.out.println("Error, amount withdrawn greater than account balance.");
			}
		} while (bank.findByNumber(accNbrBen).getAmount()<transfer);
		
		
		bank.findByNumber(accNbrBen).withdraw(transfer);
		bank.findByNumber(accNbrRec).deposit(transfer);
		System.out.println(bank.findByNumber(accNbrBen));
		System.out.println(bank.findByNumber(accNbrRec));
		
	}
	
	private void createAccount(){ //Alt 6
		String name = null;
		do {
			System.out.print("Name: ");
			name = expectString();
		} while (name==null || name=="");
		
		Long id=-1L;
		do {
			System.out.print("ID: ");
			id = expectLong();
		} while (id==-1);
		
		int nbr = bank.addAccount(name, id);
		System.out.println("Account created: " + nbr);
	}
	
	private void removeAccount(){ //Alt 7
		System.out.print("Account Number: ");
		int id = expectInt();
		if(bank.removeAccount(id)){
			System.out.println("Account successfully removed.");
		}
		else{
			System.out.println("No such account exists, please try another account number.");
		}
	}
	
	private void printAllAccounts(){ //Alt 8
		ArrayList<BankAccount> accounts = bank.getAllAccounts();
		for (BankAccount account : accounts){
			System.out.println(account);
		}
	}
	
	private int expectInt() {
		//while(true) {
			if(scanner.hasNextInt()) return scanner.nextInt();
			String disposal=scanner.next();
			System.out.println("Error, invalid option.");
		//}
			return -1;
	}
	
	private long expectLong() {
		//while(true) {
			if(scanner.hasNextLong()) return scanner.nextLong();
			String disposal=scanner.next();
			System.out.println("Error, invalid option.");
		//}
			return -1;
	}
	
	private double expectDouble() {
		//while(true) {
			try {
				if(scanner.hasNext()) return Double.parseDouble(scanner.next());
			} catch (NumberFormatException e) {
				//String disposal=scanner.next();
				System.out.println("Error, invalid option.");
			}
		//}
			return -1;
	}
	
	private String expectString() {
		//while(true) {
		scanner.nextLine();
		return scanner.nextLine();
		//}
	}

}

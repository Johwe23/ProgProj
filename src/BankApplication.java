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
	
	public void runApplication() {
		while(true) {
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
				choice=waitForInt();

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
<<<<<<< Updated upstream
=======
				case 3:
					depositInAccount();
					break;
				case 4:
					withdrawFromAccount();
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
>>>>>>> Stashed changes
				default:
					break;
			}
			
		}
	}
	
	private void findAccountByUserId() {
		System.out.println("");
		long ID=-1;
		do {
			System.out.print("Please enter a valid ID number: ");
			ID=waitForLong();
		} while (ID<0);
		
		for (BankAccount account : bank.findAccountsForHolder(ID)) {
			System.out.println(account.toString());
		}
	}
	
	private void findCustomerFromPartOfName(){
		System.out.println("Search for: ");
	}
	
	private void depositInAccount() {
		System.out.println("");
		int accNbr=-1;
		boolean validAccNbr=false;
		do {
			do {
				System.out.print("Please enter a valid account number: ");
				accNbr=waitForInt();
			} while (BankAccount.accountCounter<accNbr || accNbr<0);
			for (BankAccount account : bank.accounts) {
				if(account.getAccountNumber()==accNbr) validAccNbr=true;
			}
		} while (!validAccNbr);
		
		double deposit=-1;
		do {
			System.out.println("Please enter a valid amount to deposit: ");
			deposit=waitForDouble();
		} while (deposit<0);
		
		bank.findByNumber(accNbr).deposit(deposit);
		System.out.println(bank.findByNumber(accNbr));
	}
	
	private void withdrawFromAccount() {
		System.out.println("");
		int accNbr=-1;
		boolean validAccNbr=false;
		do {
			do {
				System.out.print("Please enter a valid account number: ");
				accNbr=waitForInt();
			} while (BankAccount.accountCounter<accNbr || accNbr<0);
			
			for (BankAccount account : bank.accounts) {
				if(account.getAccountNumber()==accNbr) validAccNbr=true;
			}
		} while (!validAccNbr);
		
		double withdrawal=-1;
		do {
			do {
				System.out.println("Please enter a valid amount to withdraw: ");
				withdrawal=waitForDouble();
			} while (withdrawal<0);
			
			if(bank.findByNumber(accNbr).getAmount()<withdrawal) {
				System.out.println("Error, amount withdrawn greater than account balance.");
			}
		} while (bank.findByNumber(accNbr).getAmount()<withdrawal);
		
		
		bank.findByNumber(accNbr).deposit(withdrawal);
		System.out.println(bank.findByNumber(accNbr));
	}
	
	private void findCustomerFromPartOfName(){
		System.out.println("Search for: ");
		String input = waitForString();
		ArrayList<Customer> customers = bank.findByPartofName(input);
		for (Customer cust : customers){
			System.out.println(cust);
		}
	}
	
	private int waitForInt() {
		while(true) {
			if(scanner.hasNextInt()) return scanner.nextInt();
			String disposal=scanner.nextLine();
			System.out.println("Error, invalid option.");
		}
	}
	
	private long waitForLong() {
		while(true) {
			if(scanner.hasNextLong()) return scanner.nextLong();
			String disposal=scanner.nextLine();
			System.out.println("Error, invalid option.");
		}
	}
	private double waitForDouble() {
		while(true) {
			if(scanner.hasNextDouble()) return scanner.nextDouble();
			String disposal=scanner.nextLine();
			System.out.println("Error, invalid option.");
		}
	}
	
	private String waitForString() {
		while(true) {
			if(scanner.hasNext()) return scanner.nextLine();
			String disposal=scanner.nextLine();
		}
	}

}

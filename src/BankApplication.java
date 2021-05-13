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
			System.out.println("1: Hitta konto(n) utifrån innehavares ID-nummer.");
			System.out.println("2: Sök kontoinnehavare från (del av) namn.");
			System.out.println("3: Sätt in.");
			System.out.println("4: Ta ut.");
			System.out.println("5: Överför mellan konton.");
			System.out.println("6: Skapa konto.");
			System.out.println("7: Radera konto");
			System.out.println("8: Skriv ut samtliga konton (sorterade efter innehavarens namn).");
			System.out.println("9: Avsluta.");
			//System.out.println("");
			System.out.println("");
			int choice=-1;

			while(!(0<choice && choice<10)) {
				System.out.print("Input choice of action: ");
				choice=waitForInt();

				if(!(0<choice && choice<10)) {
					System.out.println("Please input one of the alternatives.");
					System.out.println("");
				}
				
			}
			
			switch (choice) {
				case 1: 
					findAccountByUserId();
					break;
					
				case 3:
					
					break;
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
		} while (!validAccNbr);
		
		
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

}

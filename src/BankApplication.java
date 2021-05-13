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
			do {
				System.out.print("Input choice of action: ");
				choice=waitForInt();

				if(0<choice && choice<10) {
					break;
				} else {
					System.out.println("Please input one of the alternatives.");
					System.out.println("");
				}
				
			} while(true);
			
			switch (choice) {
				case 1: 
					findAccountByUserId();
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
			
		} while (true);
		
	}
	
	private void findCustomerFromPartOfName(){
		System.out.println("Search for: ");
	}
	
	private int waitForInt() {
		while(true) {
			if(scanner.hasNextInt()) return scanner.nextInt();
			String disposal=scanner.nextLine();
		}
	}
	
	private long waitForLong() {
		while(true) {
			if(scanner.hasNextLong()) return scanner.nextLong();
			String disposal=scanner.nextLine();
		}
	}
	
	private String waitForString() {
		while(true) {
			if(scanner.hasNext()) return scanner.nextLine();
			String disposal=scanner.nextLine();
		}
	}

}

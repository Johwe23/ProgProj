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
			do {
				System.out.print("Inmata val av handling: ");
				choice=waitForInt();

				if(0<choice && choice<10) {
					break;
				} else {
					System.out.println("Vänligen inmata ett av alternativen.");
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
		System.out.println("");
	}
	
	private int waitForInt() {
		while(true) {
			if(scanner.hasNextInt()) return scanner.nextInt();
			String disposal=scanner.nextLine();
			
		}
	}

}

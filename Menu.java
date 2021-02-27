package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SodasDao;
import entity.Sodas;

public class Menu {

	private Scanner scanner = new Scanner( System.in );
	private SodasDao sodaDao = new SodasDao();
	
	private List<String> options = Arrays.asList( //this list holds our menu options as strings
			"Display Sodas",
			"Update a Soda",
			"Create a Soda",
			"Delete a Soda");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displaySodas();
				} else if (selection.equals("2")) { 
					updateSoda();
				} else if (selection.equals("3")) {
					createSoda();
				} else if (selection.equals("4")) {
					deleteSoda();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1")); // -1 terminates the program. So, while selection != -1, it will run.

	}
	
	private void printMenu() {
		System.out.println("Select an option:\n-------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}	
	
	private void displaySodas() throws SQLException {
		List<Sodas> SodaList = sodaDao.getAllSodas();
		for (Sodas s : SodaList) {
			System.out.println(s.getSodaId() + ": " + s.getSodaName());
		}
	}
	
	private void updateSoda() throws SQLException {
		System.out.println("Enter the ID # of the Soda you wish to change: ");
		String nl = scanner.nextLine();
		Integer id = null;
		try { // try/catch here in case id input is malformed
			id = Integer.parseInt( nl );
		} catch (NumberFormatException e ) {
			System.out.println("Please input an ID #.");
			return;
		}
		if (id != null ) {
			System.out.println("Enter the new Soda name: ");
			String name = scanner.nextLine();
			if (!name.isEmpty() ) {
				sodaDao.updateSodas(id, name);
			}
	}
}
	
	private void createSoda() throws SQLException {
		System.out.print("Enter a new soda name: ");
		String sodaName = scanner.nextLine();
		sodaDao.createNewSoda(sodaName);
	}
	
	private void deleteSoda() throws SQLException {
		System.out.print("Enter a Soda ID # to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		sodaDao.deleteSodaById(id);
	}
}

package fr.pizzeria.console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.services.MenuService;
import fr.pizzeria.services.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		Properties properties = new Properties();
		String path=new File("").getAbsolutePath(); 
		String fic = path + "/src/main/resources/jdbc.properties";
		/* Ici le fichier contenant les données de configuration est nommé 'db.myproperties' */
		try{
			FileInputStream in = new FileInputStream(fic);
			properties.load(in);
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// Extraction des propriétés
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		
		PizzaDao pizzaDao = null;
		try {
			pizzaDao = new PizzaDao(DriverManager.getConnection(url, user, password));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Initialisation du scanner */
		Scanner scanner = new Scanner(System.in);
		int choix = 0;
		

		do {
			println("***** Pizzeria Administration *****");
			println("1. Lister les pizzas ");
			println("2. Ajouter une nouvelle pizza ");
			println("3. Mettre � jour une pizza ");
			println("4. Supprimer une pizza ");
			println("5. Initialiser base de données");
			println("6. Supprimer toutes les pizza");
			println("99. Sortir ");
	
			System.out.print("Veuillez choisir une option:");
			choix = scanner.nextInt();
			
			MenuService service = MenuServiceFactory.getInstance(choix);
			service.executeUC(scanner, pizzaDao);

			
		} while(choix<7);
		pizzaDao.fermerConnexion();
		scanner.close();
		
	}
	
	

	private static void println(String msg){
		System.out.println(msg);
	}
}

package fr.pizzeria.services;

public class MenuServiceFactory {

	public static MenuService getInstance(int choix){
		
		switch (choix) {
		case 1:
			return new ListerPizzasService();
		case 2:
			return new AjouterPizzaService();

		case 3:
			return new ModifierPizzaService();
			
		case 4:
			return new SupprimerPizzaService();

		case 5:
			return new InitialiserPizzaService();
			
		case 6:
			return new SupprimerToutesPizzaService();

		default:
			return new AuRevoirService();
		}
	}
}

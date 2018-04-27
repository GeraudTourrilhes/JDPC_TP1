package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaDao pizzaDao) {
		System.out.println("Supprimer une pizza");
		
		System.out.println("Code de la pizza � supprimer:");
		String codePizzaSupp = scanner.next();
		
		pizzaDao.deletePizza(codePizzaSupp);

		

	}

}

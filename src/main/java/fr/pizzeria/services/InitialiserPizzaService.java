package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public class InitialiserPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaDao pizzaDao) {
		
		
		pizzaDao.initaliserListePizza();

		

	}

}

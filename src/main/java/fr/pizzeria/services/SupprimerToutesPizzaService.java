package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

public class SupprimerToutesPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaDao pizzaDao) {
		
		pizzaDao.deleteAllPizza();


	}

}

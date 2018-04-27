package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;

public class AuRevoirService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaDao pizzaDao) {
		System.out.println("Au revoir");
	}

}

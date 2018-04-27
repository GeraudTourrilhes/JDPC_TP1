package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaDao pizzaDao) {
		System.out.println("Lister les pizzas");

		try{
			for (Pizza pizza: pizzaDao.findAllPizzas()){
				System.out.println(pizza);
			}
		}
		catch (NullPointerException e) {
			System.out.println("Aucune pizza n'existe");
		}
		

	}

}

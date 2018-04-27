package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;

public abstract class MenuService {

	public abstract void executeUC(Scanner scanner, PizzaDao pizzaDao);
}

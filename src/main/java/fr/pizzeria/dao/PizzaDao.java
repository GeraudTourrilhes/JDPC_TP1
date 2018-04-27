package fr.pizzeria.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	
	
	private Connection conn;
	
	 
	public PizzaDao(Connection conn)
	{
		this.conn = conn;
	}
	
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		try {

			PreparedStatement selectPizzaSt = conn.prepareStatement("SELECT id, code, libelle, prix FROM PIZZA");
			ResultSet resultats = selectPizzaSt.executeQuery();
			
			while(resultats.next())
			{
				pizzas.add(new Pizza(resultats.getInt("id"), resultats.getString("code"), resultats.getString("libelle"), resultats.getDouble("prix")));
				
			}
			
			
		        
		    } catch (SQLException e) {

		      e.printStackTrace();

		    }
		return pizzas;
	}

	public void saveNewPizza(Pizza pizza) {
		try {

			PreparedStatement insertPizzaSt = conn.prepareStatement("insert into pizza (id, code, libelle, prix) values (?,?,?,?)");
			insertPizzaSt.setInt(1,pizza.getId());
			insertPizzaSt.setString(2,pizza.getCode());
			insertPizzaSt.setString(3,pizza.getLibelle());
			insertPizzaSt.setDouble(4,pizza.getPrix());
			insertPizzaSt.executeQuery();
			
			
		        
		    } catch (SQLException e) {

		      e.printStackTrace();

		    }
		
	}

	public void updatePizza(String codePizza, Pizza pizza){
		if(pizzaExists(codePizza))
		{
			try {
	
				PreparedStatement updatePizzaSt = conn.prepareStatement("update pizza  set code =?, libelle=?, prix=? WHERE code=?");
				updatePizzaSt.setString(1,pizza.getCode());
				updatePizzaSt.setString(2,pizza.getLibelle());
				updatePizzaSt.setDouble(3,pizza.getPrix());
				updatePizzaSt.setString(4,codePizza);
				updatePizzaSt.executeQuery();
				
				
			        
			    } catch (SQLException e) {
	
			      e.printStackTrace();
	
			    }
		}
		
	}

	public void deletePizza(String codePizza) {
		if(pizzaExists(codePizza))
		{
			try {
	
				PreparedStatement deletePizzaSt = conn.prepareStatement("delete FROM PIZZA WHERE code=?");
				deletePizzaSt.setString(1,codePizza);
				deletePizzaSt.executeQuery();
				
				
			        
			    } catch (SQLException e) {
	
			      e.printStackTrace();
	
			    }
		}
		
	}

	public Pizza findPizzaByCode(String codePizza)  {
		Pizza pizza = null;
		if(pizzaExists(codePizza))
		{
			
			try {
	
				PreparedStatement selectPizzaSt = conn.prepareStatement("SELECT id, code, libelle, prix FROM PIZZA WHERE ID=?");
				selectPizzaSt.setInt(1,1);
				ResultSet resultats = selectPizzaSt.executeQuery();
				pizza = new Pizza(resultats.getInt("id"), resultats.getString("code"), resultats.getString("libelle"), resultats.getDouble("prix"));
				
			        
			    } catch (SQLException e) {
	
			      e.printStackTrace();
	
			    }
		}
		return pizza;
		    
	}

	public boolean pizzaExists(String codePizza) {
		boolean exist = false;
		try{
			PreparedStatement selectPizzaSt = conn.prepareStatement("SELECT * FROM PIZZA WHERE code=?");
			selectPizzaSt.setString(1,codePizza);
			ResultSet resultats = selectPizzaSt.executeQuery();
			exist = (resultats.wasNull()) ? false : true;
			
		
		} catch(SQLException e){
			 e.printStackTrace();
		}
		return exist;
	}

}

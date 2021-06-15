package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.User;
import beans.Bar;

public class Helper {

	public ArrayList<User> setUserArrayList(ResultSet resultados) {
		// Ya tengo los datos de la BBDD
		// Voy a transformarlos a objetos
		ArrayList<User> arraylist = new ArrayList<User>();
		try {
			while (resultados.next()) {
				
				String nombre = resultados.getString("user");
				String password = resultados.getString("pass");
				arraylist.add(new User(nombre, password));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta de usuarios");
		}

		return arraylist;
	}

	public User setUserObject(ResultSet resultado) {
		try {
			if (resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				String password = resultado.getString("password");
				User user = new User(id, nombre, password);
				return user;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta de usuarios");
		}
		return null;
	}
	
	public ArrayList<Bar> setBarArrayList(ResultSet resultados) {
		// Ya tengo los datos de la BBDD
		// Voy a transformarlos a objetos
		ArrayList<Bar> arraylist = new ArrayList<Bar>();
		try {
			while (resultados.next()) {
				int id = resultados.getInt("id");
				String nombre= resultados.getString("nombre");
				String direccion= resultados.getString("direccion");
				int telefono = resultados.getInt("telefono");
				int tipo = resultados.getInt("tipo");
				arraylist.add(new Bar(id, nombre, direccion, telefono, tipo));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta de bares");
		}

		return arraylist;
	}

	public Bar setBarObject(ResultSet resultado) {
		try {
			if (resultado.next()) {
				int id = resultado.getInt("id");
				String nombre= resultado.getString("nombre");
				String direccion= resultado.getString("direccion");
				int telefono = resultado.getInt("telefono");
				int tipo = resultado.getInt("tipo");
				Bar bar = new Bar(id, nombre, direccion, telefono, tipo);
				return bar;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la consulta de bares");
		}
		return null;
	}
	
	
}
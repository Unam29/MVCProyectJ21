package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbdd.Conexion;
import beans.User;

public class Users {

	public ArrayList<User> getAllUsers() {
		ResultSet resultados = Conexion.EjecutarSentencia("SELECT * FROM usuarios WHERE nombre");
		ArrayList<User> user = new controlador.Helper().setUserArrayList(resultados);
		return user;
	}

	public User getUserByNameAndPass(String usuario, String pass) {
		ResultSet userBD = Conexion
				.EjecutarSentencia("SELECT * FROM usuarios WHERE nombre='" + usuario + "' AND password ='" + pass +"'");
		User user = new controlador.Helper().setUserObject(userBD);
		return user;
	}

	public boolean checkUserAndPass(String nombre, String password) {
		ResultSet usuarioBD = Conexion
				.EjecutarSentencia("SELECT * FROM usuarios WHERE nombre ='" + nombre + "' AND password='" + password + "'");

		try {
			return usuarioBD.next();
		} catch (SQLException e) {
			return false;
		}
	}

	public void insertUser(String nombre, String password) {
		Conexion.EjecutarUpdate("INSERT INTO usuarios (nombre, password) VALUES (' " + nombre + "', '" + password + "');");
	}

	// Metodo para implementar una vez iniciado sesion (con un boton ej)
	public void updateUser(String nombre, String password) {
		Conexion.EjecutarUpdate("UPDATE usuarios SET password='" + password + "' WHERE nombre='" + nombre + "';");
	}

	public void deleteUser(String nombre, String password) {
		Conexion.EjecutarUpdate("DELETE FROM usuario WHERE nombre = '" + nombre + "' AND password = '" + password + "';");
	}

}
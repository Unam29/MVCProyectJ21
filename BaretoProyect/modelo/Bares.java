package modelo;

import java.sql.ResultSet;

import java.util.ArrayList;

import bbdd.Conexion;
import beans.Bar;


public class Bares {
	public void crearBar(int id, String nombre, String direccion, String string, Integer telefono) {
		Conexion.EjecutarUpdate("INSERT INTO bares ( ID, Nombre, Direccion, Tipo,Telefono) VALUES ('" + id + "', '" + nombre + "', '" + direccion + "+ " + string + "" + telefono + "');");
	}
	public ArrayList<Bar> getAllBares() {
		ResultSet resultados = Conexion.EjecutarSentencia("SELECT * FROM bares;");
		ArrayList<Bar> bares = new controlador.Helper().setBarArrayList(resultados);
		return bares;
	}
	
	public Bar getBarByTelefono(int telefono) {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM bares WHERE telefono = '" + telefono + "'; ");
		Bar bar = new controlador.Helper().setBarObject(resultado);
		return bar;
	}
	public Bar getBarByTipo(boolean tipo) {
		ResultSet resultado = Conexion.EjecutarSentencia("SELECT * FROM bares WHERE tipo = '" + tipo + "'; ");
		Bar bar = new controlador.Helper().setBarObject(resultado);
		return bar;
	}
	public void modificarTelefono(int telefonoAntiguo, int telefonoNuevo) {
		Conexion.EjecutarUpdate("UPDATE bares SET telefono='" + telefonoAntiguo + "' WHERE telefono='" + telefonoNuevo + "';");
	}
	
}

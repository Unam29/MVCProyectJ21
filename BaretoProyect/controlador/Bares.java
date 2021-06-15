package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.Bar;
import beans.User;



public class Bares {
	

	public void crearBar(int id, String nombre, String direccion, String string, Integer telefono) {
		if(nombre.length() == 0) {
			JOptionPane.showMessageDialog(null, "Texto vac�o. INCORRECTO");
		}else if(telefono < 100000000) {
			JOptionPane.showMessageDialog(null, "Texto demasiado largo. INCORRECTO");
		} else {
			new modelo.Bares().crearBar( id,  nombre,  direccion,  string,  telefono);
			JOptionPane.showMessageDialog(null, "Opini�n publicada");
		}
	}

	public ArrayList<Bar> obtenerBares() {
		ArrayList<Bar> bares = new modelo.Bares().getAllBares();
		return bares;
	}
	
	public void obtenerBarPorTelefono(int telefono, String vista, User user) {
		Bar bar = new modelo.Bares().getBarByTelefono(telefono);
		new vistas.BarVista(user, bar, vista);
	}
	public void obtenerBarPorTipo(boolean tipo, String vista, User user) {
		Bar bar = new modelo.Bares().getBarByTipo(tipo);
		new vistas.BarVista(user, bar, vista);
	}
	
	public void modificarTelefono(int telefonoViejo , int  telefonoNuevo, String vista, User user, Bar bar) {
		new modelo.Bares().modificarTelefono(telefonoViejo,telefonoNuevo);
			new vistas.BarVista(user, bar, vista);
	}

}

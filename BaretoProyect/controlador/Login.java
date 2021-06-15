package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import beans.User;


public class Login {

	public void insertUser(String user, String password) {
		if(user.length() != 0 && password.length() != 0) {
			new modelo.Users().insertUser(user, password);
			JOptionPane.showMessageDialog(null, "Usuario Creado");
		} else {
			JOptionPane.showMessageDialog(null, "Introduzca los datos requeridos");
		}
		
	}

	public void updateUser(String user, String password) {
		if(password.length() != 0) {
			JOptionPane.showMessageDialog(null, "Password Actualizada");
			new modelo.Users().updateUser(user, password);
		} else {
			JOptionPane.showMessageDialog(null, "Introduzca los datos requeridos");
		}
	}

	public void deleteUser(String user, String password) {
		new modelo.Users().deleteUser(user, password);
	}

	public boolean checkUser(String username, String password) {
		// Recoger los usuarios
		User user = new modelo.Users().getUserByNameAndPass(username, password);
		if (user != null) {
			new vistas.Principal(user);
			return true;
		} else { // Sino error
			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
			return false;
		}
	}

	public boolean checkUserOld(String user, String password) {
		// Recoger los usuarios
		ArrayList<User> usuarios = new modelo.Users().getAllUsers();
		// Comprobar si usuario y contrase�a son correctos
		for (User usuario : usuarios) {
			if (user.equals(usuario.getUser()) && password.equals(usuario.getPass())) {
				JOptionPane.showMessageDialog(null, "Usuario correcto");
			} else { // Sino error
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
			}
		}
		return true;
	}

}
package main;

import java.awt.EventQueue;

import java.sql.SQLException;

import bbdd.Conexion;
import vistas.Login;

public class Main {

	public static void main(String[] args) throws SQLException {
		/* Conexion a bade de datos */
		Conexion.Conectar();

		/* Arranque de interfaz */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
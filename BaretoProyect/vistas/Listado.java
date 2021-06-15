package vistas;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import beans.User;
import beans.Bar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;


import java.io.FileWriter;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public Listado() {
		this( new User() );
	}

	public Listado(User user) {
		
		//Generar Casetas
		ArrayList<Bar> bares =  new controlador.Bares().obtenerBares();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 384);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JTextField camponombre = new JTextField();
		camponombre.setBounds(31, 368, 371, 55);
		panel.add(camponombre);
		JTextField campodireccion = new JTextField();
		campodireccion.setBounds(31, 368, 371, 55);
		panel.add(campodireccion);
		JTextField campotipo = new JTextField();
		campotipo.setBounds(31, 368, 371, 55);
		panel.add(campotipo);
		JTextField campotelefono = new JTextField();
		campotelefono.setBounds(31, 368, 371, 55);
		panel.add(campotelefono);

		JButton btnPublicar = new JButton("Añadir Bar");
		btnPublicar.setBounds(420, 380, 89, 23);
		panel.add(btnPublicar);

		
		JButton goBackButton = new JButton("< Volver");
		goBackButton.setFont(new Font("Arial", Font.BOLD, 14));
		goBackButton.setBackground(Color.LIGHT_GRAY);
		goBackButton.setBounds(638, 292, 109, 43);
		panel.add(goBackButton);
		
		/* Crear la tabla con su modelo */
		DefaultTableModel dtm = new DefaultTableModel();
		table = new JTable(dtm);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 60, 684, 285);
		panel.add(table);
		
		/*JButton btnNewButton = new JButton("22");
		btnNewButton.setBounds(682, 74, 65, 12);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("97");
		btnNewButton_1.setBounds(682, 91, 65, 12);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("153");
		btnNewButton_1_1.setBounds(682, 108, 65, 12);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("215");
		btnNewButton_1_2.setBounds(682, 124, 65, 12);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("82");
		btnNewButton_1_3.setBounds(682, 140, 65, 12);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("85");
		btnNewButton_1_4.setBounds(682, 156, 65, 12);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("61");
		btnNewButton_1_5.setBounds(682, 172, 65, 12);
		panel.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_6 = new JButton("225");
		btnNewButton_1_6.setBounds(682, 188, 65, 12);
		panel.add(btnNewButton_1_6);
		
		JButton btnNewButton_1_7 = new JButton("13");
		btnNewButton_1_7.setBounds(682, 204, 65, 12);
		panel.add(btnNewButton_1_7);
		
		JButton btnNewButton_1_8 = new JButton("77");
		btnNewButton_1_8.setBounds(682, 220, 65, 12);
		panel.add(btnNewButton_1_8);*/
		
		JLabel lblListadoDeBares = new JLabel("LISTADO DE BARES");
		lblListadoDeBares.setFont(new Font("Arial", Font.BOLD, 15));
		lblListadoDeBares.setBounds(10, 11, 231, 26);
		panel.add(lblListadoDeBares);
		
		JButton btnFichero = new JButton("Fichero");
		btnFichero.setBounds(190, 11, 89, 23);
		panel.add(btnFichero);
		/* Crear las columnas */
		dtm.addColumn("Nombre");
		dtm.addColumn("Direccion");
		dtm.addColumn("Tipo");
		dtm.addColumn("Telefono");
		
		
		Object[] filaInicial = new Object[4];
		filaInicial[0] = "NOMBRE";
		filaInicial[1] = "DIRECCION";
		filaInicial[2] = "TIPO";
		filaInicial[3] = "TELEFONO";
		dtm.addRow(filaInicial);
		
		for(Bar bar : bares) {
			Object[] fila = new Object[5];
			fila[0] = bar.getNombre();
			fila[1] = bar.getDireccion();
			fila[2] = bar.getTelefono();
			
			if (bar.getTipo() == 1) {
				fila[3] = "Cafe-Bar";
			} else {
				fila[3] = "Restaurante";
			}
			dtm.addRow(fila);			
		}

		// Acciones
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer auxtelf= new Integer(campotelefono.getText());
				new controlador.Bares().crearBar(1, camponombre.getText(), campodireccion.getText(), campotipo.getText(), auxtelf);
			
				
			}
		});
		btnFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fichero = null;
		        String linea = "";
		        try {
		            fichero = new FileWriter("bares.txt");
		            for (int i=0; i<bares.size(); i++) {
		                linea = (i+1)+". ";
		                linea = linea + bares.get(i).toString()+"\n";
		                fichero.write(linea);
		            }
		            fichero.close();
		            JOptionPane.showMessageDialog(null, "Fichero creado");
		        } catch (Exception err) {
		            System.out.println(err);
		        }
		        
		    }
		});

		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal principal = new vistas.Principal();
				principal.setVisible(true);
			}
		});
		
		/*btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Bares().obtenerCasetaPorNumero(97, "listado", user);
			}
		});
		
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(85, "listado", user);
			}
		});
		
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(215, "listado", user);
			}
		});
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(153, "listado", user);
			}
		});
		
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(82, "listado", user);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(22, "listado", user);
			}
		});
		
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(77, "listado", user);
			}
		});
		
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(13, "listado", user);
			}
		});
		
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(225, "listado", user);
			}
		});
		
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new controlador.Casetas().obtenerCasetaPorNumero(61, "listado", user);
			}
		});*/

	}
}
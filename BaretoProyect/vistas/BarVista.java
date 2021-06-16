package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import beans.User;
import beans.Bar;
import beans.Opinion;

import java.awt.List;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.Checkbox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JScrollPane;

public class BarVista extends JFrame {

	private JPanel contentPane;
	private JTable table;

	public BarVista() {
		this(new User(), new Bar(), "vista");
	}

	public BarVista(User user, Bar bar, String vista) {
		
		//Generar Opinionea
		ArrayList<Opinion> opiniones =  new controlador.OpinionesControl().obtenerOpiniones(bar.getId());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 472);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel(""+bar.getTelefono());
		label.setBounds(10, 11, 148, 47);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Arial", Font.BOLD, 40));
		
		JButton goBackButton = new JButton("< Volver");
		goBackButton.setBounds(575, 390, 109, 43);
		goBackButton.setFont(new Font("Arial", Font.BOLD, 14));
		goBackButton.setBackground(Color.LIGHT_GRAY);
		
		JButton btnEstado = new JButton("ESTADO");
		btnEstado.setBounds(575, 11, 89, 23);
		btnEstado.setBackground(Color.LIGHT_GRAY);
		
		/* Crear la tabla con su modelo */
		DefaultTableModel dtm = new DefaultTableModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 122, 684, 212);
		panel.add(scrollPane);
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblListadoDeBares = new JLabel("Opiniones :");
		lblListadoDeBares.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeBares.setFont(new Font("Arial", Font.BOLD, 15));
		lblListadoDeBares.setBounds(287, 85, 98, 26);
		panel.add(lblListadoDeBares);
		panel.setLayout(null);
		panel.add(lblListadoDeBares);
		panel.add(label);
		panel.add(btnEstado);
		panel.add(goBackButton);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(31, 368, 371, 55);
		panel.add(textArea);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.setBounds(420, 380, 89, 23);
		panel.add(btnPublicar);
		
		Label label_1 = new Label("Escribir opini\u00F3n:");
		label_1.setBounds(31, 340, 127, 22);
		panel.add(label_1);
		
		Label label_2 = new Label(bar.getNombre());
		label_2.setFont(new Font("Arial", Font.BOLD, 20));
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(95, 25, 463, 43);
		panel.add(label_2);
		/* Crear las columnas */
		dtm.addColumn("Usuario");
		dtm.addColumn("Opinion");
		
		for(Opinion opinion : opiniones) {
			Object[] fila = new Object[5];
			fila[0] = opinion.getNombreUsuario();
			fila[1] = opinion.getTxt();
			dtm.addRow(fila);			
		}

		// Acciones
		
		btnPublicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = textArea.getText();
				new controlador.OpinionesControl().crearOpinion(bar.getId(), user.getId(), txt);
				setVisible(false);
				BarVista vistaNueva = new vistas.BarVista(user, bar, vista);
				vistaNueva.setVisible(true);
			}
		});
		
		btnEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new controlador.Bares().cambiarEstado(bar.getTelefono(), bar.getEstado());
			}
		});

		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (vista.equals("mapa")) {
					Mapa mapa = new vistas.Mapa();
					mapa.setVisible(true);
				} else {
					Listado listado = new vistas.Listado();
					listado.setVisible(true);
				}
				setVisible(false);
			}
		});
		
		

	}
}
package vistas;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;

public class Ajustes extends JFrame {

	private JPasswordField passwordInput;
	private JPanel contentPane;

	public Ajustes() {
		this(new User());
	}

	public Ajustes(User user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(-221, 33, 645, 33);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Modificar Contrase\u00F1a");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ebrima", Font.PLAIN, 17));

		passwordInput = new JPasswordField();
		passwordInput.setEchoChar('*');
		passwordInput.setBounds(138, 96, 149, 20);
		contentPane.add(passwordInput);
		passwordInput.setColumns(10);

		JButton updateButton = new JButton("Actualizar");
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.setForeground(SystemColor.inactiveCaptionText);
		updateButton.setBounds(165, 127, 91, 23);
		contentPane.add(updateButton);
		updateButton.setVerticalAlignment(SwingConstants.BOTTOM);
		updateButton.setToolTipText("");

		JLabel passwordLabel = new JLabel(" Nueva Contrase\u00F1a :");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		passwordLabel.setBounds(162, 77, 135, 14);
		contentPane.add(passwordLabel);

		JButton deleteButton = new JButton("Eliminar");
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setBounds(171, 205, 85, 22);
		contentPane.add(deleteButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(-262, 161, 686, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lb2NewLabel = new JLabel("Eliminar Usuario");
		panel_1.add(lb2NewLabel);
		lb2NewLabel.setFont(new Font("Ebrima", Font.PLAIN, 17));
		
		JButton goBackButton = new JButton("<");
		goBackButton.setBackground(Color.LIGHT_GRAY);
		goBackButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		goBackButton.setBounds(0, -1, 51, 23);
		contentPane.add(goBackButton);

		

		// Acciones
		
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal principal = new vistas.Principal();
				principal.setVisible(true);
			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordInput.getText();
				new controlador.Login().updateUser(user.getUser(), password);
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Usuario Eliminado");
				setVisible(false);
				Login loginNuevo = new vistas.Login();
				loginNuevo.setVisible(true);
				new controlador.Login().deleteUser(user.getUser(), user.getPass());

			}
		});

	}
}

package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordInput;
	private JTextField userInput;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		passwordInput = new JPasswordField();
		passwordInput.setBounds(115, 155, 190, 20);
		panel.add(passwordInput);
		passwordInput.setColumns(10);

		userInput = new JTextField();
		userInput.setColumns(10);
		userInput.setBounds(115, 99, 190, 20);
		panel.add(userInput);

		JLabel userLabel = new JLabel("Usuario");
		userLabel.setBounds(115, 74, 46, 14);
		panel.add(userLabel);

		JLabel passwordLabel = new JLabel("Contrase\u00F1a");
		passwordLabel.setBounds(115, 130, 76, 14);
		panel.add(passwordLabel);

		JButton insertButton = new JButton("Registrar");
		insertButton.setBackground(Color.LIGHT_GRAY);
		insertButton.setBounds(115, 199, 89, 23);
		panel.add(insertButton);

		JButton loginButton = new JButton("Entrar");
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setBounds(222, 199, 89, 23);
		panel.add(loginButton);
		
		JLabel lblFerial = new JLabel("BIENVENIDOS AL BARETO");
		lblFerial.setHorizontalAlignment(SwingConstants.CENTER);
		lblFerial.setFont(new Font("Arial", Font.PLAIN, 22));
		lblFerial.setBounds(52, 27, 316, 36);
		panel.add(lblFerial);

		// Acciones

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamar al controlador
				String user = userInput.getText();
				String password = passwordInput.getText();
				boolean pass = new controlador.Login().checkUser(user, password);
				if (pass) {
					setVisible(false);
				}
			}
		});

		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userInput.getText();
				String password = passwordInput.getText();
				new controlador.Login().insertUser(user, password);
			}
		});
	}
}
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		System.out.println("Register Constructor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(154, 212, 112, 40);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(154, 253, 112, 22);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password : ");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setBounds(114, 285, 112, 22);
		contentPane.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(218, 223, 250, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setAction(action);
		btnRegister.setBounds(289, 316, 85, 21);
		contentPane.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 255, 250, 19);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(218, 287, 250, 19);
		passwordField_1.setEchoChar('*');
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 194, 251, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(174, 197, 64, 13);
		contentPane.add(lblEmail);
	}
	private class SwingAction extends AbstractAction {
		private Mainpage plan;
		public SwingAction() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String username = textField.getText();
			String password = new String(passwordField.getPassword());
			String conf_password = new String(passwordField_1.getPassword());
			String email = textField_1.getText();
			try
			{
				if (password.equals(conf_password))
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
					Statement st = con.createStatement();
					st.execute("USE test");
					st.execute("INSERT INTO people (username,password,email) VALUE ('"+username+"','"+password+"','"+email+"')");
					System.out.println("Account Created");
					dispose();
					plan = new Mainpage(username);
					plan.setVisible(true);
				}
				else 
					System.out.println("Passwords Don't match");
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}
		}
	}
}

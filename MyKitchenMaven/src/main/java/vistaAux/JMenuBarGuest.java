package vistaAux;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.InitGUI;
import vista.Ayuda;
import vista.MenuPrincipal;
import vista.cronometro;

public class JMenuBarGuest extends JMenuBar{
	
	private JButton loginButton;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton registerButon;
	
	public JMenuBarGuest(){
		
		this.setPreferredSize(new Dimension(0, 49));
		this.setBackground(new Color(34, 139, 34));
	
		
		JLabel lblMykitchen = new JLabel("MyKitchen          ");
		lblMykitchen.setBackground(new Color(0, 128, 128));
		lblMykitchen.setForeground(new Color(230, 230, 250));
		this.add(lblMykitchen);
		
		Component horizontalStrut = Box.createHorizontalStrut(47);
		this.add(horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(60);
		this.add(verticalStrut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 139, 34));
		this.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblUsuario = new JLabel("Usuario");
		panel_1.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		panel_1.add(lblContrasea);
		
	    textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
	    passwordField = new JPasswordField(20);
		panel_1.add(passwordField);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		 loginButton = new JButton("Login");
		this.add(loginButton);
		registerButon = new JButton("Registrarse");
		this.add(registerButon);
		
		
	}

	public JButton getLoginButton() {
		return loginButton;
	}
	public JButton getRegisterButton() {
		return registerButon;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}



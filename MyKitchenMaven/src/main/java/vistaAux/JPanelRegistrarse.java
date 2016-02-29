package vistaAux;

import java.awt.Canvas;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class JPanelRegistrarse extends JPanelBackground{
	
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_check;
	private JButton btnRegistrate;
	private JButton cancelar;
	private CanvasObject canvasObject;
	
	
	public JPanelRegistrarse(){
	this.setOpaque(false);
	this.setBackground("/src/imagenes/loginWallpaper.jpg");
	this.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setLayout(null);
	canvasObject = new CanvasObject();
	canvasObject.cogerImagen("/src/imagenes/unete.jpg");
	canvasObject.setBounds(60, 62, 418, 213);
	this.add(canvasObject);
		
    textField = new JTextField();
    textField.setBounds(524, 62, 99, 23);
    this.add(textField);
    textField.setColumns(10);
    
    passwordField = new JPasswordField();
    passwordField.setBounds(524, 111, 99, 23);
    this.add(passwordField);
    
    passwordField_check = new JPasswordField();
    passwordField_check.setBounds(524, 166, 99, 23);
    this.add(passwordField_check);
    
    JLabel lblNombreONick = new JLabel("nombre o nick");
    lblNombreONick.setBounds(524, 42, 99, 23);
    this.add(lblNombreONick);
    
    JLabel lblContrasea = new JLabel("contrase\u00F1a");
    lblContrasea.setBounds(524, 91, 99, 23);
    this.add(lblContrasea);
    
    JLabel lblRepiteContrasea = new JLabel("repite contrase\u00F1a");
    lblRepiteContrasea.setBounds(524, 146, 109, 23);
    this.add(lblRepiteContrasea);
    
    btnRegistrate = new JButton("Registrate!");
    btnRegistrate.setBounds(524, 220, 99, 23);
    this.add(btnRegistrate);
    
    cancelar = new JButton("cancelar");
    cancelar.setBounds(200, 220, 89, 23);
    this.add(cancelar);
	}

	public  JButton getCancelar() {
		return cancelar;
	}
	
	public  JButton getRegistrate() {
		return btnRegistrate;
	}
	
	public  JTextField getTextField() {
		return textField;
	}
	
	public  JPasswordField getPasswordField() {
		return passwordField;
	}
	
	public  JPasswordField getPasswordField_check() {
		return passwordField_check;
	}
	public CanvasObject getCanvasObject(){
		return canvasObject;
	}
	
}

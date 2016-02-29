package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorUsuario {
	private String name;
	private String pass;
	private String type;
	
	public ControladorUsuario(){
		name = "Invitado";
		pass = " ";
		type = "invitado";
	}
	/********************************************************************************************
					true si existe ; false si no existe
	********************************************************************************************/
	public boolean usuarioExiste(String nombre){
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/mykitchen",
				"MyKitchen",
				"mykitchen");
		PreparedStatement st = con.prepareStatement(
			 "SELECT alias, password ,tipo FROM usuarios"
					 + " WHERE alias = ?");
		) 
	{
		// Rellenamos el marcador con la información introducida
		// y ejecutamos la consulta.
		st.setString(1,nombre);
		try (ResultSet rs = st.executeQuery()) {
		
		// Si existe un primer resultado (sólo debería existir como mucho uno,
		// ya que estamos buscando una fila por su clave).
			if (rs.next()) {
				return true;
			}
		}
	} catch (SQLException e) {
		return false;
		} 
		return false;
	}
	/********************************************************************************************
				Cambia parametros a modo invitado
	 ********************************************************************************************/
	public void logOut() {
		name = "invitado";
		pass = " ";
		type = "invitado";
	}
	/********************************************************************************************
			devuelve true si se encontró el usuario y false si ocurrió algún error
	********************************************************************************************/
	public boolean checkLogin(String nombre ,String clave) {
		// Solicitamos la información al usuario
	
		// Creamos la consulta paramétrica (PreparedStatement)
		try (Connection con = DriverManager.getConnection(
								"jdbc:mysql://localhost/mykitchen",
								"MyKitchen",
								"mykitchen");
			 PreparedStatement st = con.prepareStatement(
					 "SELECT alias, password,tipo FROM usuarios"
							 + " WHERE alias = ?"
							 + " AND password = ?");
			) 
		{
			// Rellenamos el marcador con la información introducida
			// y ejecutamos la consulta.
			st.setString(1,nombre);
			st.setString(2,clave);
			try (ResultSet rs = st.executeQuery()) {
				
				// Si existe un primer resultado (sólo debería existir como mucho uno,
				// ya que estamos buscando una fila por su clave).
				if (rs.next()) {
					name = rs.getString("alias");
					pass = rs.getString("password");
					type = rs.getString("tipo");
					return true;
				}
			}
		} catch (SQLException e) {
			return false;
		} 
		return true;
	}
	/********************************************************************************************
						Crea un nuevo usuario en la base de datos
	********************************************************************************************/
	public void escrituraNueva(String nombre ,String clave,String tipo){
	try (Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost/mykitchen",
			"MyKitchen",
			"mykitchen");
			PreparedStatement st = con.prepareStatement
			("INSERT INTO usuarios(alias, password,tipo) "
			+ "VALUES (?, ?, ?)");
		) 
	{
	
	// Los dos primeros marcadores los rellenamos con dos strings
	st.setString(1, nombre);
	st.setString(2, clave);
	st.setString(3, tipo);
	st.executeUpdate();
	
	} catch (SQLException e) {
	e.printStackTrace();
	} 
		
}
	/********************************************************************************************
					Devuelve el tipo de usuario actual en string
	 ********************************************************************************************/
	public String getType(){
		return type;
	}
	/********************************************************************************************
					devuelve un entero para checkear que tipo de panel se debe 
							usar en función del tipo de usuario
	 ********************************************************************************************/
	public Integer checkTypeForPanel(){
		Integer aux = -1;
		switch(type){
		case "invitado": aux = -1; break;
		case "registrado": aux = 1; break;
		case "cocinero": aux = 2; break;
		case "administrador": aux = 3; break;
		}
		return aux;
	}
	/********************************************************************************************
						devuelve la contraseña del usuario actual
	 ********************************************************************************************/
	public String getPass(){
		return pass;
	}
	/********************************************************************************************
							devuelve el nombre del usuario actual
	 ********************************************************************************************/
	public String getName(){
		return name;
	}
	
}
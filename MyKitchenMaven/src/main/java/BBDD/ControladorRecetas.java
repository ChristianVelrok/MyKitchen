package BBDD;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Blob;

import dataStructs.category;
import dataStructs.recetaAuxStruct;

public class ControladorRecetas {

private String actualCategory;

public ControladorRecetas(){
		actualCategory = null;
	}
/********************************************************************************************
				Crear nueva receta con los parametros de entrada y una foto a seleccionar
********************************************************************************************/
	public void crearReceta(String name,String cat,String desc){
	// Creamos la conexión y la consulta paramétrica
			try (Connection con = DriverManager.getConnection(
									"jdbc:mysql://localhost/mykitchen",
									"MyKitchen",
									"mykitchen");
				 PreparedStatement st = con.prepareStatement
						 ("INSERT INTO recetas(nombre,categoria,descripcion,imagen) "
							+ "VALUES (?, ?, ?,?)");
				) 
			{
				// Los dos primeros marcadores los rellenamos con dos strings
				st.setString(1, name);
				st.setString(2, cat);
				st.setString(3, desc);
				
				// Solicitamos al usuario un nombre de archivo para la foto
				JFileChooser fc = new JFileChooser();
				InputStream is = null;
				// Si el usuario pulso el botón aceptar, inicializamos 'is'
				// a un InputStream de la imagen
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						is = new FileInputStream(fc.getSelectedFile());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				st.setBinaryStream(4, is);
				st.executeUpdate();
			} catch (SQLException  e) {
				e.printStackTrace();
			} 	
	}
/********************************************************************************************
	Vuelca en un arraylist<String> los nombres de recetas que pertenecen a una categoria
********************************************************************************************/	
	public ArrayList<String> ListarCategoria(String c){
		ArrayList<String> lista= new ArrayList<String>();
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/mykitchen",
				"MyKitchen",
				"mykitchen");
		PreparedStatement st = con.prepareStatement(
			 "SELECT nombre FROM recetas"
					 + " WHERE categoria = ?");
		) 
	{
		// Rellenamos el marcador con la información introducida
		// y ejecutamos la consulta.
		st.setString(1,c);
		try (ResultSet rs = st.executeQuery()) {
		
		// Si existe un primer resultado (sólo debería existir como mucho uno,
		// ya que estamos buscando una fila por su clave).
			while (rs.next()) {
				String aux = rs.getString("nombre");
				lista.add(aux);
			}
		}
	} catch (SQLException e) {
		System.out.println("error de SQL en listarCategoria");
		lista = null;
		} 
		return lista;
	}
/********************************************************************************************
	Comprueba si una categoria contiene miembros true = vacia
												 false = no vacia
********************************************************************************************/	
	public boolean categoriaVacia(String c){
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/mykitchen",
				"MyKitchen",
				"mykitchen");
		PreparedStatement st = con.prepareStatement(
			 "SELECT id FROM recetas"
					 + " WHERE categoria = ?");
		) 
	{
		// Rellenamos el marcador con la información introducida
		// y ejecutamos la consulta.
		st.setString(1,c);
		try (ResultSet rs = st.executeQuery()) {
		
		// Si existe un primer resultado (sólo debería existir como mucho uno,
		// ya que estamos buscando una fila por su clave).
			if (rs.next()) {
				return false;
			}
		}
	} catch (SQLException e) {
		System.out.println("error de SQL");
		} 
		return true;
	}
/********************************************************************************************
	Comprueba si una receta existe en particular true = existe
												 false = no existe
********************************************************************************************/		
	public boolean existeReceta(String name){
		boolean existe = false;
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/mykitchen",
				"MyKitchen",
				"mykitchen");
		PreparedStatement st = con.prepareStatement(
			 "SELECT id FROM recetas"
					 + " WHERE nombre = ?");
		) 
	{
		// Rellenamos el marcador con la información introducida
		// y ejecutamos la consulta.
		st.setString(1,name);
		try (ResultSet rs = st.executeQuery()) {
		
		// Si existe un primer resultado (sólo debería existir como mucho uno,
		// ya que estamos buscando una fila por su clave).
			if (rs.next()) {
				existe = true;
				return true;
				
			}
		}
	} catch (SQLException e) {
		System.out.println("error de SQL");
		} 	
		return false;
		
	}
/********************************************************************************************
	vuelca los datos de una receta en un auxiliar tras consulta por clave primaria
********************************************************************************************/	
	public recetaAuxStruct lecturaReceta(String name,String c){
		boolean existe = false;
		Integer id = null;
		String desc = null;
		BufferedImage img = null;
		recetaAuxStruct aux;
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/mykitchen",
				"MyKitchen",
				"mykitchen");
		PreparedStatement st = con.prepareStatement(
			 "SELECT id,descripcion,imagen FROM recetas"
					 + " WHERE nombre = ?");
		) 
	{
		// Rellenamos el marcador con la información introducida
		// y ejecutamos la consulta.
		st.setString(1,name);
		try (ResultSet rs = st.executeQuery()) {
		
		// Si existe un primer resultado (sólo debería existir como mucho uno,
		// ya que estamos buscando una fila por su clave).
			if (rs.next()) {
				existe = true;
				id = rs.getInt("id");
				desc = rs.getString("descripcion");
				//___________________inicio imagen_______________________
				java.sql.Blob blob =  rs.getBlob("imagen");
				byte[] data = blob.getBytes(1, (int)blob.length());
				try {
					img = ImageIO.read(new ByteArrayInputStream(data));
				} catch (IOException ex) {
					Logger.getLogger(ControladorRecetas.class.getName()).log(Level.SEVERE, null, ex);
				}
				//__________________fin imagen________________________
				
				
			}
		}
	} catch (SQLException e) {
		System.out.println("error de SQL en lectura receta");
		aux = null;
		} 
		
		if (existe){
		 aux = new recetaAuxStruct(id, desc, c, img, name);
		}else{
		 aux = null;
		 System.out.println("error con la receta");
		}
		return aux;
		
	}
/********************************************************************************************
							actualiza la categoría en uso
********************************************************************************************/	
	public void setCategory(String c) {
		Component controllingFrame = null;
		switch(c){
		case "arroz":	
		case "bebida":
		case "carne":
		case "ensalada":
		case "rebozado":
		case "pasta":
		case "salsa":
		case "pescado":
		case "postre":
		case "guiso":
		case "aperitivo":
		case "otro":
				actualCategory = c;
				break;
			default:
						JOptionPane.showMessageDialog(controllingFrame,
		                "No existe dicha categoría",
		                "Error Message",
		                JOptionPane.ERROR_MESSAGE);
				break;
		}
		// TODO Auto-generated method stub	
	}
/********************************************************************************************
			Devuelve la categoría actual de la receta buscada
********************************************************************************************/
	public String getActualCategory(){
		return actualCategory;
	}

}

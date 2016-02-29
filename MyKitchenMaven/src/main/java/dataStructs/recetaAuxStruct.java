package dataStructs;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.util.ArrayList;

public class recetaAuxStruct {
	private String category; 
	private Integer IDReceta;
	private String nombre;
	private String descripcion;
	private BufferedImage  imgBlob;
	public recetaAuxStruct( Integer ID,String desc,String cat,BufferedImage img,String nom){
		
		this.IDReceta = ID;
		this.nombre = nom;
		this.descripcion = desc;
		this.category = cat;
		this.imgBlob = img;
	}
	
	public Integer getIDReceta(){
		return IDReceta;
	}
	
	public String getCategory(){
		return category;
	}
	
	public String getDescription(){
		return descripcion;
	}
	public String getNombre(){
		return nombre;
	}
	public BufferedImage getImageBlob(){
		return imgBlob;
	}
}
package dataStructs;

import java.awt.Image;
import java.util.ArrayList;

public class recetaStruct {
	private category category; 
	private Integer IDReceta;
	private String nombre;
	private String descripcion;
	private String imgLink;
	public recetaStruct( Integer ID,String desc,category cat,String img,String nom){
		
		this.IDReceta = ID;
		this.nombre = nom;
		this.descripcion = desc;
		this.category = cat;
		this.imgLink = img;
	}
	
	public Integer getIDReceta(){
		return IDReceta;
	}
	
	public category getCategory(){
		return category;
	}
	
	public String getDescription(){
		return descripcion;
	}
	public String getNombre(){
		return nombre;
	}
	public String getImageLink(){
		return imgLink;
	}
}

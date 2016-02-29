package controlador;
import java.util.ArrayList;

import dataStructs.category;
import dataStructs.recetaStruct;;
public class RecetasID {
	 private Integer cont;
	 private recetaStruct recetaStruct;
	 private ArrayList<recetaStruct> recetaList;
	 private category actualCategory;
	 private void loadRecetas(){
		 cont = 0;
	 }
	 
	 public RecetasID(){
		 recetaList = new ArrayList<recetaStruct>();
		 loadRecetas();
		 recetaStruct = new recetaStruct(cont, "Para hacer las tortitas caseras lo primero que debes hacer es\n"
		 		+ " dejar listos los ingredientes. Si dispones de harina de repostería \n"
		 		+ "mucho mejor pero, si no tienes, puedes utilizar la variedad que quieras.\n\n"
		 		+ "Ahora que lo tenemos todo listo, cogemos un bol y mezclamos la harina con la levadura y la sal.\n"
		 		+ " Si lo tamizamos la masa quedará mucho más fina.", category.postre, "/src/imagenes/tortitas.jpg", "Tortitas");
		 cont++;
		 recetaList.add(recetaStruct);
	 }
	 
	 public void crearReceta(recetaStruct receta){
		 recetaList.contains(receta.getIDReceta());
	 }
	 
	public Integer ExisteReceta(String name){
		for(int i=0;i<recetaList.size();i++){
			if(recetaList.get(i).getNombre().equals(name))
				return recetaList.get(i).getIDReceta();
		}
		return -1;	 
	 }
	
	public recetaStruct getReceta(Integer id){
		return recetaList.get(id);
		
	}
	public ArrayList<Integer> ListarCategoria(category c){
		ArrayList<Integer> lista= new ArrayList<Integer>();
		for(int i=0;i<recetaList.size();i++){
			if(recetaList.get(i).getCategory() == c)
			{
				lista.add(recetaList.get(i).getIDReceta());
			}
		}
		
		return lista;
	}
	
	public void setCategory(String c) {
		switch(c){
		case "arroz":	
			actualCategory = category.arroz;
			break;
		case "bebida":
			actualCategory = category.bebida;
			break;
		case "carne":
			actualCategory = category.carne;
			break;
		case "ensalada":
			actualCategory = category.ensalada;
			break;
		case "rebozado":
			actualCategory = category.rebozado;
			break;
		case "pasta":
			actualCategory = category.pasta;
			break;
		case "salsa":
			actualCategory = category.salsa;
			break;
		case "pescado":
			actualCategory = category.pescado;
			break;
		case "postre":
			actualCategory = category.postre;
			break;
		case "guiso":
			actualCategory = category.guiso;
			break;
		case "aperitivo":
			actualCategory = category.aperitivo;
			break;
			default:
		}
		// TODO Auto-generated method stub	
	}
	public category getActualCategory(){
		return actualCategory;
	}
}

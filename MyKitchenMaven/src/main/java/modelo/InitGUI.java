package modelo;

import vista.MenuPrincipal;


public class InitGUI {
	private MenuPrincipal menuP;
public InitGUI(){
	menuP = new MenuPrincipal();
	menuP.setVisible(true);
	}

	public MenuPrincipal getMenu(){
		return menuP;
		
	}
}

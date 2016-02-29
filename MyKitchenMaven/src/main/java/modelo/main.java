package modelo;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

public class main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				try {
					InitGUI frame = new InitGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

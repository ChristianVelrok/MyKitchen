package vistaAux;
 
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.main;
 
/**
 * 
 * Clase que extiende de JPanel y permite poner una imagen como fondo.
 * 
 */
 
public class JPanelBackground extends JPanel {
 
	// Atributo que guardara la imagen de Background que le pasemos.
	private Image background;
 

 
	// Metodo donde le pasaremos la dirección de la imagen a cargar.
	public void setBackground(String imagePath) {
		String file = new File ("").getAbsolutePath ();
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		//Image img = new ImageIcon(getClass().getResource(imagePath)).getImage();
		file = file.replace('\\', '/');		
			this.background = new ImageIcon(file.concat(imagePath)).getImage();		
		repaint();
	}
	public void setBlob(BufferedImage img) {
		String file = new File ("").getAbsolutePath ();
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		//Image img = new ImageIcon(getClass().getResource(imagePath)).getImage();
			this.background = Toolkit.getDefaultToolkit().createImage(img.getSource());	
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		 
		/* Obtenemos el tamaño del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		// Mandamos que pinte la imagen en el panel
		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
			
 
		super.paintComponent(g);
		}
	}
 
}
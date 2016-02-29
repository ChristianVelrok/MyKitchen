package vistaAux;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

public class CanvasObject extends Canvas {
	
	private Image img1 ;
	private Graphics2D g2;
	private boolean giro;
	
	  public CanvasObject() {
		  this.setBackground(new Color(1, 0, 0, 1));
		  giro = false;
	      }

		public void paintComponent(Graphics g) {
			 
			/* Obtenemos el tamaño del panel para hacer que se ajuste a este
			cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
			int width = this.getSize().width;
			int height = this.getSize().height;
	 
			// Mandamos que pinte la imagen en el panel
			if (this.getBackground() != null) {
				g.drawImage(img1, 0, 0, width, height, null);
			}
	 
			super.paint(g);
		}
	      public void paint (Graphics g) {
	         g2 = (Graphics2D) g;     
	         if(giro){
	        	 g2.rotate(5.4);
	         for(int i=0;i<180;i++){
		 	         try {
		 				Thread.sleep( 10 );
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
		 	         g2.rotate(0.005);
		 	         g2.drawImage(img1, 5, 5, this);
		 	         this.repaint();
		 	         g2.finalize();
	    	     }
	         }else{
	        	 g2.drawImage(img1, 5, 5, this);
	         }
	         giro = false;
	         g2.finalize();
	         
	      }
	      public void cogerImagen(String imagen){
	    	  String file = new File ("").getAbsolutePath ();
	  		file = file.replace('\\', '/');
	    	  img1 = Toolkit.getDefaultToolkit().getImage(file.concat(imagen));
	      }
	      public void girarFoto(){
	    	 giro = true;
	      }
}

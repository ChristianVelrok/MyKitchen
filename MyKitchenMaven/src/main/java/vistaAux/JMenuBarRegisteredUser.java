package vistaAux;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import vista.Ayuda;
import vista.MenuPrincipal;
import vista.cronometro;

public class JMenuBarRegisteredUser extends JMenuBar{
	private JMenuItem mntmquinesSomos;
	private JMenuItem LogoutMenuItem;
	private JMenuItem mntmFavoritos;
	private JMenuItem mntmCronmetro;
	
	public JMenuBarRegisteredUser(){
		
		this.setVisible(true);
		this.setEnabled(true);
		this.setBackground(new Color(255, 255, 255));
		this.setForeground(new Color(0, 0, 0));
				
		/**
	 * 
	 */
		JMenu mnArchivo = new JMenu("Receta   ");
		mnArchivo.setBackground(new Color(255, 255, 255));
		this.add(mnArchivo);
		
		mntmFavoritos = new JMenuItem("Favoritos");
		mnArchivo.add(mntmFavoritos);
		
		JMenu mnNewMenu = new JMenu("Herramientas   ");
		this.add(mnNewMenu);
		
		mntmCronmetro = new JMenuItem("Cron\u00F3metro");
		mnNewMenu.add(mntmCronmetro);
		
		JMenu mnAyuda = new JMenu("Ayuda   ");
		this.add(mnAyuda);
		
		 mntmquinesSomos = new JMenuItem("Manual de uso");
		mnAyuda.add(mntmquinesSomos);
		
		Component horizontalStrut = Box.createHorizontalStrut(535);
		horizontalStrut.setBackground(Color.WHITE);
		horizontalStrut.setVisible(true);
		this.add(horizontalStrut);
		
	    LogoutMenuItem = new JMenuItem("Logout");
		LogoutMenuItem.setBackground(new Color(173, 255, 47));
		LogoutMenuItem.setToolTipText("");
		LogoutMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		LogoutMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(LogoutMenuItem);
		
		
		mntmCronmetro.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==mntmCronmetro) {
					try {
						new cronometro();
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		
	
		
		mntmquinesSomos.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==mntmquinesSomos) {
					try {
						Ayuda help = new Ayuda();
						help.setVisible(true);
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
	}
	public JMenuItem getLogoutMenuItem(){
		return LogoutMenuItem;
	}
}



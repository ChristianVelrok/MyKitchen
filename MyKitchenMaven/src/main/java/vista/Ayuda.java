package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class Ayuda extends JFrame {

	private JPanel Panel;

	
	
	public  JTextArea reproducirManual(String archivo) throws IOException{
        String cadena,documento= null;
        JTextArea texto = new JTextArea();
        texto.setEditable(false);
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
        	documento = documento + cadena+"\n";
        }
        texto.setText(documento);
        b.close();
        
		return texto;
    }
	/**
	 * Create the frame.
	 */
	public Ayuda() {
		
			setTitle("Manual de uso");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(200, 100, 600, 400);
			Panel = new JPanel();
			Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(Panel);
			Panel.setLayout(new BorderLayout(0, 0));
			
			Component horizontalStrut = Box.createHorizontalStrut(58);
			Panel.add(horizontalStrut, BorderLayout.WEST);
			
			Component horizontalStrut_1 = Box.createHorizontalStrut(58);
			Panel.add(horizontalStrut_1, BorderLayout.EAST);
			
			JPanel panel = new JPanel();
			Panel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			JButton btnNewButton = new JButton("Cerrar\r\n");
			panel.add(btnNewButton, BorderLayout.CENTER);
			
			Component horizontalStrut_2 = Box.createHorizontalStrut(58);
			panel.add(horizontalStrut_2, BorderLayout.WEST);
			
			Component verticalStrut_1 = Box.createVerticalStrut(8);
			panel.add(verticalStrut_1, BorderLayout.SOUTH);
			
			Component horizontalStrut_3 = Box.createHorizontalStrut(56);
			panel.add(horizontalStrut_3, BorderLayout.EAST);
			
			JPanel panel_1 = new JPanel();
			Panel.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JTextArea textArea = new JTextArea();
			textArea.setMaximumSize(new Dimension(1000, 600));
			panel_1.add(textArea);
	          try {
				textArea =  reproducirManual("C:/hlocal/MyKitchen/src/imagenes/README.TXT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JScrollPane scrollpane1=new JScrollPane(textArea);    
			scrollpane1.setMaximumSize(new Dimension(1000, 600));
	        scrollpane1.setBounds(10,50,400,300);
	        panel_1.add(scrollpane1);
	        
	        JPanel panel_2 = new JPanel();
	        Panel.add(panel_2, BorderLayout.NORTH);
	        panel_2.setLayout(new GridLayout(0, 2, 0, 0));
	        
	        JButton btnNewButton_1 = new JButton("Atras");
	        panel_2.add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("Siguiente");
	        panel_2.add(btnNewButton_2);
		
		btnNewButton.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==btnNewButton) {
					try {
						Ayuda.this.dispose();
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});

	}
}

package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import vistaAux.CanvasObject;
import vistaAux.JMenuBarChef;
import vistaAux.JMenuBarGuest;
import vistaAux.JMenuBarRegisteredUser;
import vistaAux.JPanelBackground;
import vistaAux.JPanelRegistrarse;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.Window;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.ControladorRecetas;
import BBDD.ControladorUsuario;
import dataStructs.recetaAuxStruct;
import dataStructs.recetaStruct;
import controlador.RecetasID;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.SystemColor;
import javax.swing.JDesktopPane;
import javax.swing.JTextArea;

public class MenuPrincipal extends JFrame {
	private JPanel panelRecetas;
	private JPanelBackground fotoReceta;
	private JMenuBarRegisteredUser menuR;
	private JMenuBarGuest menuG ;
	private JMenuBarChef menuC;
	private JPanelBackground contentPane;
	private JTextField textField;
	private JLabel lblBienvenidouser;
	private JButton btnNewButton;
	private ControladorUsuario ControlUser;
	private ControladorRecetas ControlRecetas;
	private JPanelRegistrarse panelRegister;
	private JPanel cardPanel;
	private CardLayout cardPrincipal;
	private CardLayout cardRecetas;
	private JPanel panelRecetasCard;
	private JPanel PanelMenuRecetas;
	private JScrollPane scrollPane;
	private JPanel PanelMostrarReceta;
	private JLabel nombreReceta;
	private JTextPane descripcionReceta;
	private RecetasID RecetasID;
	private JButton backMenuRecetas;
	private JButton categoryButton[][];
	private JPanel PanelCategoriaReceta;
	private ArrayList<String> ArrayRecetas;
	private JPanel PanelCrearReceta;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JButton btnVolverAlMenu;
	private JButton btnGuardar;
	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		cardPrincipal = new CardLayout();
		cardRecetas = new CardLayout();
		//_______________________________________Inicializaciones_______________________________________
		//menus
		menuR = new JMenuBarRegisteredUser();
		menuC = new JMenuBarChef();
		//controladores
		ControlUser = new ControladorUsuario();
		ControlRecetas = new ControladorRecetas();
		//**********************************************************************************************
		RecetasID = new RecetasID();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuG = new JMenuBarGuest();
		setJMenuBar(menuG);
		
		contentPane = new JPanelBackground();
		contentPane.setOpaque(false);
		contentPane.setBackground("/src/imagenes/loginWallpaper.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		cardPanel = new JPanel();
		cardPanel.setLayout(cardPrincipal);
		cardPrincipal.show(cardPanel, "principal");  
		setContentPane(cardPanel);
		cardPanel.add(contentPane,"principal");
		contentPane.setLayout(null);
		
		
		panelRegister = new JPanelRegistrarse();
		panelRegister.getRegistrate().setLocation(524, 338);
		panelRegister.getCancelar().setLocation(639, 338);
		cardPanel.add(panelRegister,"principal");
		
		
		panelRecetas = new JPanel();
		panelRecetas.setBounds(61, 80, 663, 398);
		contentPane.add(panelRecetas);
		panelRecetas.setLayout(new BorderLayout(0, 0));
		
	//	panelRecetasCard = new JPanel();
//		panelRecetasCard.setLayout(new GridLayout(5, 8, 10, 0));
		panelRecetasCard = new JPanel();
		panelRecetasCard.setLayout(cardRecetas);
		cardRecetas.show(panelRecetasCard,"Menu");
		scrollPane = new JScrollPane(panelRecetasCard); 
		PanelMenuRecetas = new JPanel();
		PanelMenuRecetas.setLayout(new GridLayout(4, 3, 10, 0));
	    String counts[] = { "Orden alfabético","arroz","bebida",
	    		"carne", "ensalada","rebozado",	
	    		"pasta", "salsa", "pescado",
	    		"postre","guiso", "aperitivo" };

		  categoryButton = new JButton[4][3];
		  for (int row = 0; row < 4; row++) {
			  //ButtonGroup bg = new ButtonGroup();
			  for (int col = 0; col < 3; col++) {
				  categoryButton[row][col] = new JButton(counts[(col+(3*(row)))]);
					  PanelMenuRecetas.add(categoryButton[row ][col]);
					          		
			        	  
		      }
		  }
		  panelRecetasCard.add(PanelMenuRecetas,"Menu"); 
		  
		  PanelMostrarReceta = new JPanel();
		  panelRecetasCard.add(PanelMostrarReceta, "MostarReceta");
		  PanelMostrarReceta.setLayout(null);
		  
		  descripcionReceta = new JTextPane();
		  descripcionReceta.setBackground(SystemColor.window);
		  descripcionReceta.setEditable(false);
		  descripcionReceta.setBounds(20, 85, 391, 260);
		  PanelMostrarReceta.add(descripcionReceta);
		  
		  fotoReceta = new JPanelBackground();
		  fotoReceta.setBorder(new EmptyBorder(5, 5, 5, 5));
		  fotoReceta.setOpaque(false);
		  fotoReceta.setBounds(421, 85, 233, 260);
		  PanelMostrarReceta.add(fotoReceta);
		  
		  nombreReceta = new JLabel("Receta");
		  nombreReceta.setFont(new Font("Nirmala UI", Font.PLAIN, 40));
		  nombreReceta.setBounds(49, 11, 602, 49);
		  PanelMostrarReceta.add(nombreReceta);
		  
		  backMenuRecetas = new JButton("Volver al menu");
		
		  backMenuRecetas.setBounds(521, 357, 140, 39);
		  PanelMostrarReceta.add(backMenuRecetas);
		  
		  PanelCategoriaReceta = new JPanel();
		  panelRecetasCard.add(PanelCategoriaReceta, "categorias");
		  PanelCategoriaReceta.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		  
		  ArrayRecetas = new ArrayList<String>();
		  
		  PanelCrearReceta = new JPanel();
		  panelRecetasCard.add(PanelCrearReceta, "creaReceta");
		  PanelCrearReceta.setLayout(null);
		  
		  JButton btnSelecionaUnaImagen = new JButton("Seleciona una imagen");
		  btnSelecionaUnaImagen.setBounds(343, 318, 167, 23);
		  PanelCrearReceta.add(btnSelecionaUnaImagen);
		  
		  JLabel lblNewLabel = new JLabel("URL");
		  lblNewLabel.setBounds(81, 318, 252, 23);
		  PanelCrearReceta.add(lblNewLabel);
		  
		  JTextArea textArea = new JTextArea();
		  textArea.setBounds(83, 132, 427, 168);
		  PanelCrearReceta.add(textArea);
		  
		  JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		  lblDescripcin.setBounds(83, 103, 76, 16);
		  PanelCrearReceta.add(lblDescripcin);
		  
		  textField_1 = new JTextField();
		  textField_1.setBounds(219, 63, 291, 28);
		  PanelCrearReceta.add(textField_1);
		  textField_1.setColumns(10);
		  
		  lblNewLabel_1 = new JLabel("Nombre de la receta");
		  lblNewLabel_1.setBounds(83, 63, 124, 28);
		  PanelCrearReceta.add(lblNewLabel_1);
		  
		  btnVolverAlMenu = new JButton("Volver al menu");
		  btnVolverAlMenu.setBounds(519, 357, 142, 28);
		  PanelCrearReceta.add(btnVolverAlMenu);
		  
		  btnGuardar = new JButton("Guardar");
		  btnGuardar.setBounds(10, 352, 142, 33);
		  PanelCrearReceta.add(btnGuardar);
		  
		  
		  
		  
		  
		  
		panelRecetas.add(scrollPane, BorderLayout.CENTER);                  	 	         	  
		
		textField = new JTextField();
		textField.setBounds(472, 59, 252, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	    btnNewButton = new JButton("Buscar");
	    btnNewButton.setBounds(392, 57, 81, 23);
	    contentPane.add(btnNewButton);
	    
	    lblBienvenidouser = new JLabel("Accediendo como "+ ControlUser.getName());
	    lblBienvenidouser.setBounds(637, 0, 157, 25);
	    contentPane.add(lblBienvenidouser);
	    
	    btnVolverAlMenu.addActionListener (new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (e.getSource()==btnVolverAlMenu) {
	    			try {		
	    					cardRecetas.show(panelRecetasCard,"Menu");
	    				}
	    			catch (Exception e2) {
	    				e2.printStackTrace();
	    			}
	            }
	    	} 
	    });
	    
	    menuC.getNuevoJItem().addActionListener (new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (e.getSource()==menuC.getNuevoJItem()) {
	    			try {		
	    					cardRecetas.show(panelRecetasCard,"creaReceta");
	    				}
	    			catch (Exception e2) {
	    				e2.printStackTrace();
	    			}
	            }
	    	} 
	    });
	    
	    for (int row = 0; row < 4; row++) {
			  //ButtonGroup bg = new ButtonGroup();
	    	int auxRow = row;
			  for (int col = 0; col < 3; col++) {
				  int auxCol = col;
			    categoryButton[row][col].addActionListener (new ActionListener(){
			    	public void actionPerformed(ActionEvent e){
			    		if (e.getSource()==categoryButton[auxRow][auxCol]) {
			    			try {	
			    				ControlRecetas.setCategory(categoryButton[auxRow][auxCol].getText());
			    				if(!ControlRecetas.categoriaVacia(ControlRecetas.getActualCategory())){
			    					ArrayRecetas = ControlRecetas.ListarCategoria(ControlRecetas.getActualCategory());
				    				 for(int i = 0;i<ArrayRecetas.size();i++){
				    					 
				    					  JButton enlace = new JButton(ArrayRecetas.get(i));
				    					  enlace.setBackground(Color.lightGray);
				    					  PanelCategoriaReceta.add(enlace);
				    					  String aux = ArrayRecetas.get(i);
				    					  enlace.addActionListener (new ActionListener(){
				    					    	public void actionPerformed(ActionEvent e){
				    					    		
				    					    		if (e.getSource()==enlace) {
				    					    			try {		
				    					    					recetaAuxStruct struct = ControlRecetas.lecturaReceta(aux,ControlRecetas.getActualCategory());
				    					    					fotoReceta.setOpaque(false);
				    					    					fotoReceta.setBlob(struct.getImageBlob());
				    					    					nombreReceta.setText(struct.getNombre());
				    					    					descripcionReceta.setText(struct.getDescription());
				    					    					
				    					    					 PanelCategoriaReceta.removeAll(); 
				    					    					cardRecetas.show(panelRecetasCard,"MostarReceta");
				    					    				}
				    					    			catch (Exception e2) {
				    					    				e2.printStackTrace();
				    					    			}
				    					            }
				    					    	} 
				    					    });
				    				  }
				    					cardRecetas.show(panelRecetasCard,"categorias");
			    				}else{
			    						Component controllingFrame = null;
			    						JOptionPane.showMessageDialog(controllingFrame,
							                "No existe ninguna receta en esta categoría",
							                "Error Message",
							                JOptionPane.ERROR_MESSAGE);
			    					 }
			    				}
			    			catch (Exception e2) {
			    				e2.printStackTrace();
			    			}
			            }
			    	} 
			    });
			  }
	    }
	    
	    backMenuRecetas.addActionListener (new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (e.getSource()==backMenuRecetas) {
	    			try {		
	    					cardRecetas.show(panelRecetasCard,"Menu");
	    				}
	    			catch (Exception e2) {
	    				e2.printStackTrace();
	    			}
	            }
	    	} 
	    });
	    
	    btnNewButton.addActionListener (new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if (e.getSource()==btnNewButton) {
	    			try {
	    				String label;
	    				Integer aux ;
	    				recetaAuxStruct struct ;
	    				label = textField.getText();
	    				
	    				if(ControlRecetas.existeReceta(label)){
	    					 struct = ControlRecetas.lecturaReceta(label,ControlRecetas.getActualCategory());
	    					fotoReceta.setOpaque(false);
	    					fotoReceta.setBlob(struct.getImageBlob());
	    					nombreReceta.setText(struct.getNombre());
	    					descripcionReceta.setText(struct.getDescription());
	    					
	    					 PanelCategoriaReceta.removeAll(); 
	    					cardRecetas.show(panelRecetasCard,"MostarReceta");
	    				}
	    				
	    				}
	    			catch (Exception e2) {
	    				e2.printStackTrace();
	    			}
	            }
	    	} 
	    });
	  				
		
		
		menuG.getLoginButton().addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==menuG.getLoginButton()) {
					String user;
					char[] passAux;
					user = menuG.getTextField().getText();
					passAux =  menuG.getPasswordField().getPassword();
					String pass = new String(passAux);
					Integer userType;
					boolean checkaux = false;
					//System.out.println(menuG.getPasswordField().getPassword().toString());
					try {
						checkaux = ControlUser.checkLogin(user, pass);
						if (checkaux)
							userType =  ControlUser.checkTypeForPanel();
						else
							userType = -1;
							if(userType != -1 ){
								
								menuChangeUser(userType,user);
							}else{
								Component controllingFrame = null;
								JOptionPane.showMessageDialog(controllingFrame,
						                "Invalid password. Try again.",
						                "Error Message",
						                JOptionPane.ERROR_MESSAGE);
							}
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		menuR.getLogoutMenuItem().addActionListener  (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==menuR.getLogoutMenuItem()) {
					try {
						//Component controllingFrame = null;
						
						int option = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro que desea abandonar la sesion?",
						        "alert", JOptionPane.OK_CANCEL_OPTION);
						//ok = 0  ;  cancel = 2
						if(option == 0){		
							menuChangeUser(0,"invitado");
						}
							
							
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		menuC.getLogoutMenuItem().addActionListener  (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==menuC.getLogoutMenuItem()) {
					try {
						//Component controllingFrame = null;
						
						int option = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro que desea abandonar la sesion?",
						        "alert", JOptionPane.OK_CANCEL_OPTION);
						//ok = 0  ;  cancel = 2
						if(option == 0){		
							menuChangeUser(0,"Guest");
						}
							
							
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		
		menuG.getRegisterButton().addActionListener  (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==menuG.getRegisterButton()) {
					try {
						//Component controllingFrame = null;
						panelRegister.getCanvasObject().girarFoto();						
						menuChangePanel(0);
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		
		panelRegister.getRegistrate().addActionListener  (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==panelRegister.getRegistrate()) {
					String pass = new String(panelRegister.getPasswordField().getPassword());
					String pass_check = new String(panelRegister.getPasswordField_check().getPassword());
					String user = panelRegister.getTextField().getText();
				   try {
						
						if(pass.equals(pass_check)){
							if(!user.isEmpty()){
								if(!ControlUser.usuarioExiste(user)){
									ControlUser.escrituraNueva(user, pass, "registrado");
									menuChangePanel(1);
								}else{
									Component controllingFrame = null;
									JOptionPane.showMessageDialog(controllingFrame,
					                "Usuario en uso",
					                "Error",
					                JOptionPane.ERROR_MESSAGE);
									 }
							}else{
										Component controllingFrame = null;
										JOptionPane.showMessageDialog(controllingFrame,
						                "Usuario vacío",
						                "Error",
						                JOptionPane.ERROR_MESSAGE);
							
								 }
						}else{
									Component controllingFrame = null;
									JOptionPane.showMessageDialog(controllingFrame,
					                "La contraseña no coincide con la comprobación",
					                "Error",
					                JOptionPane.ERROR_MESSAGE);
							 }
					}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		
		panelRegister.getCancelar().addActionListener  (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource()==panelRegister.getCancelar()) {
					try {
						//Component controllingFrame = null;
						menuChangePanel(1);
						}
					catch (Exception e2) {
						e2.printStackTrace();
					}
		        }
			} 
		});
		
	}
	
	public void menuChangePanel(int panel){
		switch(panel){
		case 0://Poner panel de registro de usuario
			menuG.getRegisterButton().setVisible(false);
				cardPrincipal.next(cardPanel);			
			break;
		case 1: //Poner panel de Usuario registrado & usuario guest
			menuG.getRegisterButton().setVisible(true);
			cardPrincipal.next(cardPanel);	
			break;
			default:
		}
	}
		public void menuChangeUser(int menu,String user){
			boolean exist = true;
			switch(menu){
			case 0:// menuG = new JMenuBarGuest();
				ControlUser.logOut();
				menuG.setVisible(true);
				menuR.setVisible(false);
			this.setJMenuBar(menuG);			
				break;
			case 1: //menuR = new JMenuBarRegisteredUser();
				menuG.setVisible(false);
				menuR.setVisible(true);
				this.setJMenuBar(menuR);
				break;
			case 2:
				menuG.setVisible(false);
				menuC.setVisible(true);
				this.setJMenuBar(menuC);
				break;
				default: exist = false;
			}
			if(exist){
				
				lblBienvenidouser.setText("Accediendo como "+ControlUser.getName());
			}
		}
	}
/*anotaciones:
 * Sólo funciona bien el cambio de menu cuando se ha llevado a cabo un cambio de usuario */
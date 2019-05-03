import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.eclipse.swt.widgets.MessageBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreGestion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmGestionDesArtistes;
	public JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JTable table_1;
	JList<Album> list = Connexion.afficherAlbums();
	JCheckBox chckbxNewCheckBox = new JCheckBox("");
	JLabel lblNewLabel_1 = new JLabel("");
	JLabel lblNewLabel = new JLabel("New label");
	private String conne = "jdbc:sqlite:c:/BD/data.sqlite";
	public static DefaultTableModel dtm;
	ArrayList<Artiste> listeArtiste= new ArrayList<Artiste>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreGestion window = new FenetreGestion();
					window.frmGestionDesArtistes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreGestion() {
		initialize();
		Connexion.etablirConnection(conne);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesArtistes = new JFrame();
		frmGestionDesArtistes.setTitle("Gestion des Artistes");
		frmGestionDesArtistes.setBounds(100, 100, 529, 437);
		frmGestionDesArtistes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesArtistes.getContentPane().setLayout(null);
		
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setBounds(10, 11, 161, 14);
		frmGestionDesArtistes.getContentPane().add(lblRechercherUnArtiste);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 189, 15);
		frmGestionDesArtistes.getContentPane().add(textField);
		textField.setColumns(10);
		String text = "Dra";
		JButton btnNewButton = new JButton("Recherche");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connexion.afficherRecherche(textField.getText(),table_1);
				
			}
		});
		btnNewButton.setBounds(226, 24, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnNewButton);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnQuitter.setBounds(404, 24, 89, 18);
		frmGestionDesArtistes.getContentPane().add(btnQuitter);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setBounds(10, 68, 117, 14);
		frmGestionDesArtistes.getContentPane().add(lblArtistes);				
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 68, 237, 136);
		frmGestionDesArtistes.getContentPane().add(scrollPane);
		
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Nom", "Membre"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setAutoCreateRowSorter(true);
		table_1.getRowSorter().toggleSortOrder(0);
		table_1.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent e) {
	        	String id = (String) table_1.getValueAt(table_1.getSelectedRow(), 0);
	        	String nom = (String) table_1.getValueAt(table_1.getSelectedRow(), 1);
	        	String membre = (String) table_1.getValueAt(table_1.getSelectedRow(), 2);
	            textField_1.setText(id);
	            textField_2.setText(nom);
	            if (membre == "1") {
					chckbxNewCheckBox.setSelected(true);
				} else if (membre == "0") {
					chckbxNewCheckBox.setSelected(false);
				}
	         }
	      });

		
		Connexion.afficher(table_1);
		scrollPane.setViewportView(table_1);
		
		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser(); 
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gig", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lblNewLabel.setIcon(Connexion.resizeImage(path, lblNewLabel));
				} else if(result == JFileChooser.CANCEL_OPTION){
					System.out.println("asff");
				}
			}
		});
		

		
		btnRemplacer.setBounds(10, 178, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnRemplacer);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String weeknd = Connexion.getImage();
				BufferedImage img = null;
				try {
				    img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/img.png"));
				} catch (IOException e) {
				    e.printStackTrace();
				}
				
				Image dimg = img.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1
						.getHeight(),
				        Image.SCALE_SMOOTH);
				
				textField_2.setText("");
				chckbxNewCheckBox.setSelected(false);
				//System.out.println(Connexion.nouveau());
				String id1 = Connexion.nouveau();
			    int id = Integer.parseInt(id1) + 1;

				//System.out.println(id);
				textField_1.setText(Integer.toString(id));
				
				lblNewLabel_1.setIcon(new ImageIcon(dimg));
			}
		});
		
		btnNouveau.setBounds(393, 98, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_1.getText();
				String nom = textField_2.getText();
				String membre;
				if (chckbxNewCheckBox.isSelected()) {
					membre = "1";
				} else {
					membre = "0";
				}
				String photo = "asddsa";
				
				Connexion.ajouter(id, nom, membre, photo);
				Connexion.afficher(table_1);
			}
		});
		btnAjouter.setBounds(393, 127, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_1.getText();
				String nom = textField_2.getText();
				String membre;
				if (chckbxNewCheckBox.isSelected()) {
					membre = "1";
				} else {
					membre = "0";
				}
				String photo = "asddsa";
				Connexion.modifier(nom,membre,table_1);
				Connexion.afficher(table_1);
			}
		});
		btnModifier.setBounds(393, 156, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(null, "êtes vous sur de vouloir supprimer?", "Supprimer", JOptionPane.YES_NO_OPTION);
				int rowIndex = table_1.getSelectedRow();
			    int colIndex = table_1.getSelectedColumn();
				
			    Object id = table_1.getValueAt(rowIndex,colIndex);
			    
				//int id = (int) table_1.getValueAt( table_1.getSelectedRow(),  table_1.getSelectedColumn());
				if (opt == 0) {
					try {
					Connexion.supprimer(table_1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Connexion.afficher(table_1);
				}
				
			}
		});
		btnSupprimer.setBounds(393, 186, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnSupprimer);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setBounds(10, 207, 117, 14);
		frmGestionDesArtistes.getContentPane().add(lblInformations);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setBounds(10, 232, 117, 14);
		frmGestionDesArtistes.getContentPane().add(lblNumro);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 261, 117, 14);
		frmGestionDesArtistes.getContentPane().add(lblNom);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setBounds(10, 295, 117, 14);
		frmGestionDesArtistes.getContentPane().add(lblMembre);
		
		textField_1 = new JTextField();		
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(74, 231, 117, 15);
		frmGestionDesArtistes.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(74, 260, 117, 15);
		frmGestionDesArtistes.getContentPane().add(textField_2);
		
		
		chckbxNewCheckBox.setBounds(74, 286, 97, 23);
		frmGestionDesArtistes.getContentPane().add(chckbxNewCheckBox);
		
		
		lblNewLabel.setBounds(20, 93, 100, 74);
		frmGestionDesArtistes.getContentPane().add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(349, 232, 144, 134);
		frmGestionDesArtistes.getContentPane().add(lblNewLabel_1);
		

		list.setBounds(212, 260, 134, 108);
		frmGestionDesArtistes.getContentPane().add(list);
	}
	

}

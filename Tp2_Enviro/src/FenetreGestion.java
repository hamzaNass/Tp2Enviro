import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenetreGestion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmGestionDesArtistes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	//private Artiste artiste = new Artiste(null, null, null, null);
	//private Base base = new Base();
	//private Connexion conn = new Connexion();
	private String conne = "jdbc:sqlite:c:/BD/data.sqlite";
	public static DefaultTableModel dtm;
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
		
		JButton btnNewButton = new JButton("Recherche");
		btnNewButton.setBounds(226, 24, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnNewButton);
		
		JButton btnQuitter = new JButton("Quitter");
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
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		/*table_1.setModel(new DefaultTableModel(
         
			new Object[][] {
				{artiste.getId(), artiste.getNomArtiste(), artiste.getMembre()},
				{artiste.getId(), artiste.getNomArtiste(), artiste.getMembre()},
				{artiste.getId(), artiste.getNomArtiste(), artiste.getMembre()},
				{artiste.getId(), artiste.getNomArtiste(), artiste.getMembre()},
				{artiste.getId(), artiste.getNomArtiste(), artiste.getMembre()},
			},
			new String[] {
				"No", "Nom", "Membre"
			}
		));*/
		Connexion.etablirConnection(conne);
		Connexion.afficher(table_1);
		scrollPane.setViewportView(table_1);
		
		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setBounds(10, 178, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnRemplacer);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnNouveau.setBounds(393, 98, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(393, 127, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(393, 156, 100, 18);
		frmGestionDesArtistes.getContentPane().add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
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
		textField_1.setColumns(10);
		textField_1.setBounds(74, 231, 117, 15);
		frmGestionDesArtistes.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(74, 260, 117, 15);
		frmGestionDesArtistes.getContentPane().add(textField_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(74, 286, 97, 23);
		frmGestionDesArtistes.getContentPane().add(chckbxNewCheckBox);
		
		JList list = new JList();
		list.setBounds(209, 305, 117, -78);
		frmGestionDesArtistes.getContentPane().add(list);
	}


}

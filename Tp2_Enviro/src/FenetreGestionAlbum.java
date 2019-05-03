import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreGestionAlbum {

	private JFrame frmGestionDesAlbums;
	private JTextField textField;
	private JTable table;
	private String conne = "jdbc:sqlite:c:/BD/data.sqlite";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreGestionAlbum window = new FenetreGestionAlbum();
					window.frmGestionDesAlbums.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreGestionAlbum() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesAlbums = new JFrame();
		frmGestionDesAlbums.setTitle("Gestion des albums");
		frmGestionDesAlbums.setBounds(100, 100, 450, 300);
		frmGestionDesAlbums.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesAlbums.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des albums");
		lblNewLabel.setBounds(10, 11, 159, 14);
		frmGestionDesAlbums.getContentPane().add(lblNewLabel);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(68, 191, 89, 23);
		frmGestionDesAlbums.getContentPane().add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(169, 191, 89, 23);
		frmGestionDesAlbums.getContentPane().add(btnModifier);
		
		JButton btnNewButton = new JButton("Supprimer");
		btnNewButton.setBounds(268, 191, 100, 23);
		frmGestionDesAlbums.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(335, 35, 89, 23);
		frmGestionDesAlbums.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 120, 20);
		frmGestionDesAlbums.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Rechercher");
		btnNewButton_2.setBounds(140, 36, 118, 23);
		frmGestionDesAlbums.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 67, 247, 116);
		frmGestionDesAlbums.getContentPane().add(scrollPane);
		
		table = new JTable();
		Connexion.etablirConnection(conne);
		Connexion.afficherAlbum(table);
		scrollPane.setViewportView(table);
		
	}
}

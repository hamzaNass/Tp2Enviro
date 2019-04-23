import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class FenetreConnexion extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmGestionDesAlbums;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnexion window = new FenetreConnexion();
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
	public FenetreConnexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesAlbums = new JFrame();
		frmGestionDesAlbums.setTitle("Gestion des Albums");
		frmGestionDesAlbums.setBounds(100, 100, 450, 300);
		frmGestionDesAlbums.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesAlbums.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion \u00E0 l'application");
		lblNewLabel.setBounds(35, 51, 194, 14);
		frmGestionDesAlbums.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Valider");		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton ) {
					
					try{
						if (textField.getText().equals("admin") && textField_1.getText().equals("pass")) {							
							FenetreChoix.main(null);
							
						} else {
							JOptionPane.showMessageDialog(null, "Nom ou mots de pass incorecte");
						}
						
					}
					catch (NumberFormatException nfe){
						//JOptionPane.showMessageDialog(this, "Le salaire n'est pas un nombre");
					}
				}
			}
		});
		btnNewButton.setBounds(93, 206, 123, 23);
		frmGestionDesAlbums.getContentPane().add(btnNewButton);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(230, 206, 123, 23);
		frmGestionDesAlbums.getContentPane().add(btnQuitter);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur");
		lblNomDutilisateur.setBounds(35, 87, 96, 14);
		frmGestionDesAlbums.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(35, 112, 107, 14);
		frmGestionDesAlbums.getContentPane().add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBounds(183, 84, 96, 20);
		frmGestionDesAlbums.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(183, 109, 96, 20);
		textField_1.setEchoChar('*');
		frmGestionDesAlbums.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}

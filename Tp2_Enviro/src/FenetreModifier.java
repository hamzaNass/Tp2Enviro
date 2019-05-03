import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreModifier {

	private JFrame frame;
	private JTextField textField;
	FenetreGestion fen = new FenetreGestion();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreModifier window = new FenetreModifier();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreModifier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODIFIER UN ARTISTE");
		lblNewLabel.setBounds(148, 32, 165, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom de l'artiste");
		lblNewLabel_1.setBounds(44, 82, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Membre");
		lblNewLabel_2.setBounds(44, 121, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(148, 79, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnModifier = new JButton("Valider");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//fen.table_1.setModel();
				
			}
		});
		btnModifier.setBounds(145, 177, 89, 23);
		frame.getContentPane().add(btnModifier);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(148, 121, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
	}
}

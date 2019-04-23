import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreChoix extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmMenuDeChoix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreChoix window = new FenetreChoix();
					window.frmMenuDeChoix.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreChoix() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuDeChoix = new JFrame();
		frmMenuDeChoix.setTitle("Menu des choix");
		frmMenuDeChoix.setBounds(100, 100, 450, 300);
		frmMenuDeChoix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuDeChoix.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir un des choix suivant :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 30, 240, 14);
		frmMenuDeChoix.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Menu Gestion des artistes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					FenetreGestion.main(null);
				}
			}
		});
		btnNewButton.setBounds(10, 66, 214, 23);
		frmMenuDeChoix.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Menu Gestion des albums");
		btnNewButton_1.setBounds(10, 116, 214, 23);
		frmMenuDeChoix.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(335, 215, 89, 23);
		frmMenuDeChoix.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FenetreConnexion.main(null);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(335, 181, 89, 23);
		frmMenuDeChoix.getContentPane().add(btnNewButton_3);
	}
}

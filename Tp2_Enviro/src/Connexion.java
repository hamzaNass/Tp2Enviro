import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JTable;

import net.proteanit.sql.DbUtils;







public class Connexion {
	static Connection connexion = null;
	String conn = "jdbc:sqlite:c:/BD/data.sqlite";
	
	public static void etablirConnection(String conn) {
		try {
			connexion = DriverManager.getConnection(conn);
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("ERREUR : La base de donn\u00E9es  manquante.");
		} /*finally {
			try { // Fermeture de la connexion
				if (connexion != null)
					connexion.close();
			} catch (SQLException se) {
				System.out.println("ERREUR : impossible de fermer la connexion.");
			}
		}*/
	}
	
	public static void afficher(JTable table){
		Statement statement = null;
		ResultSet jeuxResultats = null;
		//ArrayList<Artiste> listeEmployes= new ArrayList<Artiste>();
		try {
			statement = connexion.createStatement();
			jeuxResultats = statement.executeQuery("SELECT * FROM artiste");
			int i =0;
			while (jeuxResultats.next()){
				/*String id = jeuxResultats.getString("id");
				String nom = jeuxResultats.getString("nomArtiste");
				String membre = jeuxResultats.getString("membre");
				String photo = jeuxResultats.getString("photo");*/
				
				/*System.out.print("Num\u00E9ro: "+ id +"\tNom : " + nom+ "\tPr\u00E9nom : " + membre);
				System.out.println();*/
				/*listeEmployes.add(new  Artiste(id, nom, membre, photo));
				table = new JTable();
				for (Artiste artiste : listeEmployes) {
					FenetreGestion.dtm.addRow(new Object[][] {{id,nom,membre}});
				}*/
				//System.out.println(listeEmployes.toString() + "    asfsfd");
				//modeleEmploye = new ModeleEmploye(initialiserEmployes(id,nom,membre,photo));
				//table= new JTable(modeleEmploye );
				//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// sélection simple
				ResultSet set=statement.executeQuery("SELECT id,nomArtiste AS Nom,membre FROM artiste");
				table.setModel(DbUtils.resultSetToTableModel(set));
				/*table.setModel(new DefaultTableModel(
				         
						new Object[][] {
							{id,nom,membre},
							{id,nom,membre},
							{id,nom,membre},
							{id,nom,membre},
						},
						new String[] {
							"No", "Nom", "Membre"
						}
					));*/
				
				/*table.getModel().setValueAt(id, i, 0);
				table.getModel().setValueAt(nom, i, 1);
				table.getModel().setValueAt(membre, i, 2);
				//table.getModel().setValueAt(photo, i, 3);*/
				System.out.println(i);
				i++;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*private static ArrayList<Artiste> initialiserEmployes(String id, String nom, String membre, String photo){
		ArrayList<Artiste> listeEmployes= new ArrayList<Artiste>();
		
		//listeEmployes.add(new  Artiste(id, nom, membre, photo));
		return listeEmployes;
	}*/
}

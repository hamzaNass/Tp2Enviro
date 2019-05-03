import java.awt.Image;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;


public class Connexion {
	static Connection connexion = null;
	static String conn = "jdbc:sqlite:c:/BD/data.sqlite";
	static PreparedStatement pstmt;
	static Artiste artiste = new Artiste();
	static ArrayList<Artiste> listeArtiste= new ArrayList<Artiste>();
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
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ajouter(String id, String Nom, String membre, String photo){
		
		 String sql = "INSERT INTO artiste(id,nomArtiste,membre,photo) VALUES(?,?,?,?)";
		 
	        try{
	            pstmt = connexion.prepareStatement(sql);
	            pstmt.setString(1, id);
	            pstmt.setString(2, Nom);
	            pstmt.setString(3, membre);
	            pstmt.setString(4, photo);
	            pstmt.executeUpdate();
	            new Artiste(id,Nom,membre,photo);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
	}
	
	public static void supprimer(JTable table) throws SQLException{
		String sql = "DELETE FROM artiste WHERE id = ?";
        try {
            PreparedStatement pstmt = connexion.prepareStatement(sql);

            String selected = (String) table.getValueAt(table.getSelectedRow(), 0);
            pstmt.setString( 1, selected );
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	
    }
	
	public static void modifier(String Nom, String membre, JTable table){
		
		String sql = "UPDATE artiste SET nomArtiste = ?, membre = ? WHERE id = '"+table.getValueAt(table.getSelectedRow(), 0)+"'";
 
        try{
            PreparedStatement pstmt = connexion.prepareStatement(sql);
            //String selected = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            // set the corresponding param
            pstmt.setString(1, Nom);
            pstmt.setString(2, membre);
            
            // update 
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
	}
	
	public static String nouveau(){
		Statement statement = null;
		ResultSet jeuxResultats = null;
		String id = "";
		try {
			statement = connexion.createStatement();
			jeuxResultats = statement.executeQuery("SELECT * FROM artiste");			
			while (jeuxResultats.next()){
				id = jeuxResultats.getString("id");								
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}	
	
	public static void afficherRecherche(String text, JTable table){
				
		Statement statement = null;
		ResultSet jeuxResultats = null;
		try {
			statement = connexion.createStatement();
			jeuxResultats = statement.executeQuery("SELECT * FROM artiste WHERE UPPER(nomArtiste) LIKE UPPER('%"+text+"%');");
			
			while (jeuxResultats.next()){

				ResultSet set=statement.executeQuery("SELECT id,nomArtiste AS Nom,membre FROM artiste");
				table.setModel(DbUtils.resultSetToTableModel(set));		
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void afficherRes(JTable table, JTextField text){
		Statement statement = null;
		ResultSet jeuxResultats = null;
		//ArrayList<Artiste> listeEmployes= new ArrayList<Artiste>();
		String sql = "SELECT * FROM artiste WHERE UPPER(nomArtiste) LIKE UPPER('%"+text.getText()+"%');";
		try {
			PreparedStatement pstmt = connexion.prepareStatement(sql);
			/*statement = connexion.createStatement();
			jeuxResultats = statement.executeQuery("SELECT * FROM artiste WHERE UPPER(nomArtiste) LIKE UPPER('%"+text.getText()+"%');");*/
			
			pstmt.setString(1, text.getText());
			/*while (jeuxResultats.next()){

				ResultSet set=statement.executeQuery("SELECT id,nomArtiste AS Nom,membre FROM artiste");
				table.setModel(DbUtils.resultSetToTableModel(set));

				}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ImageIcon resizeImage(String path, JLabel label){
		
		ImageIcon MyImage = new ImageIcon(path);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	
	public static String getImage(){
		Statement statement = null;
		ResultSet jeuxResultats = null;
		String photo = "";
		try {
			jeuxResultats = statement.executeQuery("SELECT * FROM artiste");
			photo = jeuxResultats.getString("photo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return photo;
		
	}
	
	public static JList afficherAlbums(){
		Statement statement = null;
		ResultSet jeuxResultats = null;
		ArrayList<Album> albums = new ArrayList<Album>();
		try {
			if (connexion == null) {
				Connexion.etablirConnection("jdbc:sqlite:c:/BD/data.sqlite");
			}
			statement = connexion.createStatement();
			jeuxResultats = statement.executeQuery("SELECT * FROM album");
			while (jeuxResultats.next()) {
				String id = jeuxResultats.getString("id");
				String titre = jeuxResultats.getString("titre");
				String genre = jeuxResultats.getString("genre");
				String annee = jeuxResultats.getString("annee");
				String image = jeuxResultats.getString("image");
				String id_artiste = jeuxResultats.getString("id_artiste");
				albums.add(new Album(id, titre, genre, annee, image, id_artiste));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new JList(albums.toArray());
	}
	
	public static void afficherAlbum(JTable table){
		Statement statement = null;
		ResultSet jeuxResultats = null;
		//ArrayList<Artiste> listeEmployes= new ArrayList<Artiste>();
		try {
			statement = connexion.createStatement();
			jeuxResultats = statement.executeQuery("SELECT * FROM album");
			
			while (jeuxResultats.next()){

				ResultSet set=statement.executeQuery("SELECT id,titre,genre,annee FROM album");
				table.setModel(DbUtils.resultSetToTableModel(set));

				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
	


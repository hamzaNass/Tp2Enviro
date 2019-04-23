

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class ModeleEmploye extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
    //Structure de données
	private ArrayList<Artiste> lesDonnees ;

	// les entêtes de colonnes
	private final String[] lesTitres = {"id", "Nom", "membre", "photo"}; 
	/**
	 * Construit un ModeleEmploye à partir d'une liste de données
	 * @param lesDonnees Structure de données de type ArrayList
	 */
	public ModeleEmploye(ArrayList<Artiste> lesDonnees){
		this.lesDonnees=lesDonnees;	
	}
	/*3 méthodes de l'interface TableModel		
	 doivent être obligatoirement redéfinies*/
	/**
	 * Donne le nombre de lignes dans le modèle.
	 *  Un JTable utilise cette méthode pour déterminer le nombre de lignes qu'il 
	 *  doit afficher. 
	 * @return le nombre de lignes du modèle
	 */
	@Override
	public int getRowCount() {
		return lesDonnees.size();
	}
	/**
	 * Donne le nombre de colonnes dans le modèle.
	 *  Un JTable utilise cette méthode pour déterminer le nombre de colonnes qu'il 
	 *  doit créer et afficher par défaut.
	 * @return le nombre de colonnes du modèle
	 */
	@Override
	public int getColumnCount() {
		return lesTitres.length;
	}	
	/**
	 * Renvoie la valeur de la cellule à rowIndex et columnIndex 
	 *  @return la valeur de l'objet à la position spécifiée
	 *  @param rowIndex indice de la ligne
	 *  @param columnIndex indice de la colonne	
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0:
			return lesDonnees.get(rowIndex).getId();
		case 1:
			return lesDonnees.get(rowIndex).getNomArtiste();
		case 2:
			return lesDonnees.get(rowIndex).getMembre();
		case 3:
			return lesDonnees.get(rowIndex).getPhoto();
		
		
		default:
			return null;
		}
	}
	//autre méthode pour avoir le nom des colonnes, si non les colonnes sont nommées A,B,c
	
/**
 * Retourne le nom de la colonne à columnIndex. 
 * utilisée pour initialiser la colonne des nom d'en-tête de la table. 
 * Note: ce nom n'a pas besoin d'être unique, deux colonnes d'une table peuvent avoir le même nom. 
 *  @return le nom  de la colonne
 *  
 */
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	/**
	 * renvoie la classe des objets affichés dans la colonne.
	 * Cette méthode est nécessaires pour les renderers associés à des types particuliers comme boolean 
	 * Dans ce cas, il permet d’afficher les booléens dans une case à cocher
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex){
	
		  switch (columnIndex) {
	        case 0: return String.class;
	        case 1: return String.class;
	        case 2: return String.class;
	        case 3: return String.class;
	        default: throw new IllegalArgumentException(" index de colonne invalide: "+columnIndex);
		  }
	}

	
	
}

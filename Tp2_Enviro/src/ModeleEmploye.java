

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class ModeleEmploye extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
    //Structure de donn�es
	private ArrayList<Artiste> lesDonnees ;

	// les ent�tes de colonnes
	private final String[] lesTitres = {"id", "Nom", "membre", "photo"}; 
	/**
	 * Construit un ModeleEmploye � partir d'une liste de donn�es
	 * @param lesDonnees Structure de donn�es de type ArrayList
	 */
	public ModeleEmploye(ArrayList<Artiste> lesDonnees){
		this.lesDonnees=lesDonnees;	
	}
	/*3 m�thodes de l'interface TableModel		
	 doivent �tre obligatoirement red�finies*/
	/**
	 * Donne le nombre de lignes dans le mod�le.
	 *  Un JTable utilise cette m�thode pour d�terminer le nombre de lignes qu'il 
	 *  doit afficher. 
	 * @return le nombre de lignes du mod�le
	 */
	@Override
	public int getRowCount() {
		return lesDonnees.size();
	}
	/**
	 * Donne le nombre de colonnes dans le mod�le.
	 *  Un JTable utilise cette m�thode pour d�terminer le nombre de colonnes qu'il 
	 *  doit cr�er et afficher par d�faut.
	 * @return le nombre de colonnes du mod�le
	 */
	@Override
	public int getColumnCount() {
		return lesTitres.length;
	}	
	/**
	 * Renvoie la valeur de la cellule � rowIndex et columnIndex 
	 *  @return la valeur de l'objet � la position sp�cifi�e
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
	//autre m�thode pour avoir le nom des colonnes, si non les colonnes sont nomm�es A,B,c
	
/**
 * Retourne le nom de la colonne � columnIndex. 
 * utilis�e pour initialiser la colonne des nom d'en-t�te de la table. 
 * Note: ce nom n'a pas besoin d'�tre unique, deux colonnes d'une table peuvent avoir le m�me nom. 
 *  @return le nom  de la colonne
 *  
 */
	@Override
	public String getColumnName(int columnIndex) {
		return lesTitres[columnIndex];
	}
	/**
	 * renvoie la classe des objets affich�s dans la colonne.
	 * Cette m�thode est n�cessaires pour les renderers associ�s � des types particuliers comme boolean 
	 * Dans ce cas, il permet d�afficher les bool�ens dans une case � cocher
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

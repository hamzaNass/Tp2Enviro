
public class Album {

	String id;
	String titre;
	String genre;
	String annee;
	String image;
	String id_artiste;
	
	public Album(String id, String titre, String genre, String annee, String image, String id_artiste) {
		this.id = id;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.image = image;
		this.id_artiste = id_artiste;
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getAnnee() {
		return this.annee;
	}
	
	public String getImage() {
		return this.image;
	}
	
	public String getIdArtiste() {
		return this.id_artiste;
	}
}

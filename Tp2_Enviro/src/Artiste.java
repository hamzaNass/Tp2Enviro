
public class Artiste {

	String id;
	String nomArtiste;
	Boolean membre;
	String photo;
	
	public Artiste(String id, String nomArtiste, Boolean membre, String photo) {
	     this.id = id;
	     this.nomArtiste = nomArtiste;
	     this.membre = membre;
	     this.photo = photo;
	
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getNomArtiste() {
		return this.nomArtiste;
	}
	
	public Boolean getMembre() {
		return this.membre;
	}
	
	public String getPhoto() {
		return this.photo;
	}
}

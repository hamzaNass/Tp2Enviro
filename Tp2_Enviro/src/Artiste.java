
public class Artiste {

	String id;
	String nomArtiste;
	String membre;
	String photo;
	
	
	public Artiste(){
		
	}
	
	public Artiste(String id, String nomArtiste, String membre, String photo) {
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
	
	public String getMembre() {
		return this.membre;
	}
	
	public String getPhoto() {
		return this.photo;
	}
	
	
}

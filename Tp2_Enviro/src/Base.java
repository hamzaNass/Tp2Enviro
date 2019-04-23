import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Base {

	public static void main( String[] args ) {
		Connection connection = null;
		Statement statement = null;
		String conn = "jdbc:sqlite:c:/BD/data.sqlite";
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("ERREUR : Driver manquant.");
		}
		
		try {
			connection = DriverManager.getConnection(conn);
			
			statement = connection.createStatement();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("ERREUR 1: " + e);
		} 
		/*Artiste tabArtiste[] = {
				new Artiste("123", "Richard", true,"asdasd"),
				new Artiste("124", "Bertrand", false,"okay"),
				new Artiste("125", "Belzi", true,"hmmm")
		};
		
		try {
			connection = DriverManager.getConnection(conn);
			statement = connection.createStatement();
			
			for(Artiste a : tabArtiste) {
				statement.execute("INSERT INTO artiste VALUES ('" + a.getId() + "', '" + a.getNomArtiste() + "', '" + a.getMembre() + "', '" + a.getPhoto() + "')");
			}
			
		} catch (SQLException e) {
			System.out.println("ERREUR 3: " + e);
		}*/finally {
			try {
				if(statement != null)
					statement.close();
				if(connection != null)
					System.out.println("...");
					connection.close();
			} catch (SQLException e) {
				System.out.println("ERREUR 2: " + e);
			}
		}
	}

}

import java.sql.*;

public class MySqlConnection {
	private Connection conn;
	private boolean connected;
	
	
	public MySqlConnection(String databaseLocation, String databaseName, String databaseUsername, String databasePassword) {
		
		String connectionURL = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionURL = "jdbc:mysql://" + databaseLocation + ":3306/" + databaseName;
			conn = DriverManager.getConnection(connectionURL, databaseUsername, databasePassword);
			connected = true;
			
			System.err.println("Connected!");
		}catch(SQLException e) {
			System.err.println("SQL ERROR");
			connected = false;
		}catch(ClassNotFoundException e) {
			System.err.println("Class not found exception!");
			connected = false;
		}
	}
	
	public boolean connectionActive(){
        if(conn != null){
            return true;
        }
        else{
            return false;
        }
    }
	
	public boolean executeSQL(String execute) throws java.sql.SQLException {
        Statement stmt = conn.createStatement();
        boolean toReturn = stmt.execute(execute);

        //stmt.close();
        return toReturn;
    }
	
	public ResultSet executeQuery(String query) throws java.sql.SQLException {
        Statement stmt = conn.createStatement();
        System.err.println("Statement made.");
        ResultSet reset = stmt.executeQuery(query);
        System.err.println("ResultSet made.");

        //reset.close();
        //stmt.close();

        return reset;
    }
	
	public int executeSQLGettingID(String execute) throws java.sql.SQLException {
		System.err.println("Attempting to execute sql getting id");
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery(execute);
        System.err.println("ResultSet made.");

        int id = -1;
        while(results.next()) {
            String idString = results.getString(1);
            id = Integer.parseInt(idString);
        }

        System.err.println("Id is: " + id);

        //stmt.close();
        return id;
    }
	
}

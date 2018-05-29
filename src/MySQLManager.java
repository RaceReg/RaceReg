import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLManager {
	//Singleton
	private static MySQLManager manager;
	
	 //Class variables
    private static final String DATABASE_LOCATION = "jacksonportermysqldb.ck9qmzz9yyn6.us-west-2.rds.amazonaws.com";
    private static final String DATABASE_USERNAME = "raceregentry";
    private static final String DATABASE_PASSWORD = "rre2018";
    private static final String DATABASE_NAME = "racereg";
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_AFFILIATION = "Affiliation";
    private static final String TABLE_MEET = "Meet";
    private static final String TABLE_EVENTTYPE = "EventType";
    private static final String TABLE_PARTICIPANT = "Participant";
    private static final String TABLE_EVENT = "Event";
    private static final String TABLE_EVENTENTRY = "EventEntry";
    private static final String TABLE_RELAYPARTICIPANTENTRY = "RelayParticipantEntry";
    
    //Instance Variables
    MySqlConnection mysqlconnection;
    
    public MySQLManager() {
    	mysqlconnection = new MySqlConnection(MySQLManager.DATABASE_LOCATION, MySQLManager.DATABASE_NAME, MySQLManager.DATABASE_USERNAME, MySQLManager.DATABASE_PASSWORD);
    	if(mysqlconnection.connectionActive() == false) {
    		System.err.println("Connection couldn't be made.");
    	}
    	else {
    		System.err.println("Connection active!");
    	}
    }
    
    public static synchronized MySQLManager getInstance(){
        if(MySQLManager.manager == null){
        	MySQLManager.manager = new MySQLManager();
        }
        return MySQLManager.manager;
    }
    
    public boolean insertNewUser(String username, String password, String firstName, String lastName, String email, String phoneNumber) throws NoSuchAlgorithmException {
    	//Check to see if username is taken
    	String query = "SELECT count(*) FROM " + MySQLManager.TABLE_USERS + " WHERE " + MySQLManager.TABLE_USERS + ".username = '" + username + "';";
    	
    	System.err.println("QUERY TBE: " + query);
    	
    	try {
            ResultSet results = mysqlconnection.executeQuery(query); //get results from query
            int numberOfUsersWithUsername = -1;
            
            
            while(results.next()){ //Go until all of the rows have been read in
            	numberOfUsersWithUsername = results.getInt(1);
            	System.err.println("Number of users with this username: " + numberOfUsersWithUsername);
            }

            if(numberOfUsersWithUsername > 0){
                return false;
            }
            else {
                results.close();
            	
            	MessageDigest md = MessageDigest.getInstance("MD5");
        		byte[] messageDigest = md.digest(password.getBytes());
        		BigInteger number = new BigInteger(1, messageDigest);
        		String hashtext = number.toString(16);
        		while(hashtext.length() < 32) {
        			hashtext = "0" + hashtext;
        		}
            	
            	
            	String toExecute = "INSERT INTO " + MySQLManager.TABLE_USERS + " (" 
            	+ MySQLManager.TABLE_USERS + ".username, "
            	+ MySQLManager.TABLE_USERS + ".hashpass, "
            	+ MySQLManager.TABLE_USERS + ".`First Name`, "
            	+ MySQLManager.TABLE_USERS + ".`Last Name`, "
            	+ MySQLManager.TABLE_USERS + ".Email, "
            	+ MySQLManager.TABLE_USERS + ".PhoneNumber"
            	+ ") VALUES ('"
            	+ username + "', '"
            	+ hashtext + "', '"
            	+ firstName + "', '"
            	+ lastName + "', '"
            	+ email + "', '"
            	+ phoneNumber + "'"
            	+ ");";
            	
            	System.err.println("INSERT USER STATEMENT: " + toExecute);

            	
            	mysqlconnection.executeSQL(toExecute);           	
            	return true;
            }
            

        } catch (SQLException e) {
           	System.err.println("Error in checking if user is there OR in inserting user.");
            return false;
        }
    	
    }
    
}

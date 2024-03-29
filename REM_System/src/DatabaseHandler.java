import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;

//DatabaseHandler provides the communication between system and database and
	 //to create each property object supply information from database
public class DatabaseHandler {
	
	static Connection con;
	
	public DatabaseHandler(){
		
		try{
			
			con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/rem_system.db");
			
			System.out.println("Connection is successful !");
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
	}
	
	public ArrayList<Integer> GetAllPropertyIDs() throws SQLException{
		Statement st = con.createStatement();
		ArrayList<Integer> property_ids = new ArrayList<>();
		Integer property_id = null;
		String Query = "SELECT id FROM `properties`";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        property_id = ResultQuerySet.getInt("id");
	        property_ids.add(property_id);
		}
        return property_ids;
	}
	
	public static String GetTypeFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		String Type = null;
		String Query = "SELECT p_type FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Type = ResultQuerySet.getString("p_type");
		}
        return Type;
	}
	
	public static String GetStatusFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		String Status = null;
		String Query = "SELECT p_status FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Status = ResultQuerySet.getString("p_status");
		}
        return Status;
	}
	
	public static Integer GetYearFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		Integer year = null;
		
		String Query = "SELECT p_year FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        year = ResultQuerySet.getInt("p_year");
		}
        return year;
	}
	public static Integer GetMonthFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		Integer month = null;
		
		String Query = "SELECT p_month FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        month = ResultQuerySet.getInt("p_month");
		}
        return month;
	}
	public static Integer GetDayFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		Integer day = null;
		
		String Query = "SELECT p_day FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        day = ResultQuerySet.getInt("p_day");
		}
        return day;
	}
	
	public static String GetTitleFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		String Title = null;
		String Query = "SELECT p_title FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Title = ResultQuerySet.getString("p_title");
		}
        return Title;
	}
	
	public static String GetAddressFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		String Address = null;
		String Query = "SELECT p_address FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Address = ResultQuerySet.getString("p_address");
		}
        return Address;
	}
	public static Integer GetPriceFromID(int id) throws SQLException{
		Statement st = con.createStatement();
		Integer Price = null;
		String Query = "SELECT p_price FROM `properties` WHERE `id` = '" + id + "'";
		ResultSet ResultQuerySet = st.executeQuery(Query);
		
		while(ResultQuerySet.next())
		{
	        Price = ResultQuerySet.getInt("p_price");
		}
        return Price;
	}
	
	public static void DeleteProperty(int id) throws SQLException{
		
		Statement stmt = con.createStatement();
        String ClearQuery = "DELETE FROM `properties` WHERE `id` ='" + id + "'";
        stmt.executeUpdate(ClearQuery);
	}

}

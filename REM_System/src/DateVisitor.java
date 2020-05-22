import java.sql.SQLException;
import java.util.Calendar;

public class DateVisitor implements Visitor{
	
	Calendar calendar = Calendar.getInstance();
	
	int year = calendar.get(Calendar.YEAR);
	int month = (calendar.get(Calendar.MONTH)+1);
	
	public void Visit(Property property) throws SQLException{
		
		int property_year = property.getYear();
		int property_month = property.getMonth();
		
		if(year > property_year){
			DatabaseHandler.DeleteProperty(property.getID());
			System.out.println(property.getID()+ " has been deleted.");
		}
		else if((month-property_month) > 6){
			DatabaseHandler.DeleteProperty(property.getID());
			System.out.println(property.getID()+ " has been deleted.");
		}
	}

}

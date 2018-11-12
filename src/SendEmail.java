import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SendEmail  
{
   public static void main(String [] args)  {        
   }
   public void sendmail(String username,String time) {
	   try {
		   	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = con.createStatement();
			st.execute("USE test");
			ResultSet rs = st.executeQuery("SELECT * FROM people WHERE username='"+username+"'");
			String email = "test@gmail.com";
			while(rs.next())
				email = rs.getString("email");
			String s = "python D:/\"GitHub Repository\"/Personal-Planner-Java/src/mail.py " + email +" " + time;
			Process p = Runtime.getRuntime().exec(s);
			System.out.println(s);
		}
		catch(Exception e) {System.out.println(e);}
	}
}

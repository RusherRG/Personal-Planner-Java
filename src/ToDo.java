import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
	public void AddToDo(String username, String todo) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		String id = sdf.format(dt);
		try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = con.createStatement();
			st.execute("USE test");
			st.execute("INSERT INTO todo (username,id,time,todo,status) VALUE ('"+username+"','"+id+"','"+currentTime+"','"+todo+"','"+0+"')");
			System.out.println(' '+username+','+id+','+currentTime+','+todo+','+0);
		}
		catch(Exception ec) {System.out.println(ec);}
	}
	public void DisplayTasks(String username) {
		try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = con.createStatement();
			st.execute("USE test");
			ResultSet res = st.executeQuery("SELECT * FROM todo WHERE username = '"+username+"' && status = 0");
			while(res.next()) {
				System.out.println(res.getString("todo"));
			}
		}
		catch(Exception ec) {System.out.println(ec);}
	}
	public void DeleteTask(String username,int id) {
		
	}
}

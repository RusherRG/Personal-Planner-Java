import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;

public class ToDo {
	public static void main(String args[]) {
		ToDo td = new ToDo();
		td.DisplayTasks("RusherRG");
	}
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
			FileWriter fw = new FileWriter("D://GitHub Repository//Personal-Planner-Java//src//mail_content.txt");
			String task;
			while(res.next()) {
				task = res.getString("todo")+"\n";
				System.out.print(task);
				fw.write(task);
			}
			fw.close();
		}
		catch(Exception ec) {System.out.println(ec);}
	}
	public void DeleteTask(String username,int id) {
		
	}
}

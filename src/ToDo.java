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
			st.execute("INSERT INTO todo (username,time,todo,status) VALUE ('"+username+"','"+currentTime+"','"+todo+"','"+0+"')");
			System.out.println(' '+username+','+currentTime+','+todo+','+0);
		}
		catch(Exception ec) {System.out.println(ec);}
	}
	public void DisplayTasks(String username) {
		try {
			System.out.println(username);
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = con.createStatement();
			st.execute("USE test");
			ResultSet res = st.executeQuery("SELECT * FROM todo WHERE username = '"+username+"' && status = 0");
			FileWriter fw = new FileWriter("D://GitHub Repository//Personal-Planner-Java//src//mail_content.txt");
			String task;
			int id;
			while(res.next()) {
				task = res.getString("todo");
				id = res.getInt("id");
				System.out.print(task+" "+id+"\n");
				fw.write(task+" "+id+"\n");
			}
			fw.close();
		}
		catch(Exception ec) {System.out.println(ec);}
	}
	public void DeleteTask(String username,int id) {
		try{
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = c.createStatement();
			st.execute("USE test");
			st.execute("UPDATE todo SET status=-1 WHERE id="+id+" AND status=0");
		}catch(Exception exc){System.out.println(exc+"Delete");}
	}
	public void CompleteTask(String username,int id) {
		try{
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = c.createStatement();
			st.execute("USE test");
			st.execute("UPDATE todo SET status=1 WHERE id="+id+" AND status=0");
		}catch(Exception exc){System.out.println(exc+"Complete");}
	}
}

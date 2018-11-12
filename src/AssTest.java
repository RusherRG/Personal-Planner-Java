import java.util.Scanner;
public class AssTest {
	public static void main(String [] args) {
		System.out.println("Hey there! How may I help you?");
		String questions[] = {"What can you do? How can you help me?","Add a new task to ToDo","Remove a task from ToDo","Display my ToDo list","Set the Reminder time","Remove the Reminders"};
		String answers[] = {"Set up Reminders\nAdd tasks to your Todo list\nRemove tasks from your Todo list","What do you want to add?","Which task do you want to remove?\nMention the ID","These are your Tasks","Okay. At what time do you want the Reminders?","Okay. Sure"};
		Scanner sc = new Scanner(System.in);
		while(true) {
			int max = -1,ind = 0,it=0;
			String user = sc.nextLine();
			if((user.toLowerCase()).equals("stop"))
				break;
			for(String i:questions) {
				int count = 0;
				for(String j:i.split("\\s+")) {
					for(String k:user.split("\\s+")) {
						if((k.toLowerCase()).equals(j.toLowerCase())) {
							count++;
						}
					}
				}
				if(count>max) {
					max = count;
					ind = it;
				}
				it++;
			}
			System.out.println(answers[ind]);
			if(ind==1) {
				String act = sc.nextLine();
				new ToDo().AddToDo("RusherRG", act);
				System.out.println("Added to your ToDo list");
			}
			if(ind==2) {
				new ToDo().DisplayTasks("RusherRG");
				System.out.println("Enter the ID");
				int id = sc.nextInt();
				new ToDo().DeleteTask("RusherRG", id);
			}
			if(ind==3) {
				new ToDo().DisplayTasks("RusherRG");
			}
		}
	}
	public void speech(String username) {
		try {
			String s = "python D:/\"GitHub Repository\"/Personal-Planner-Java/src/test.py "+username;
			Process p = Runtime.getRuntime().exec(s);
			System.out.println(s);
		}
		catch(Exception e) {System.out.println(e);}
	}
}
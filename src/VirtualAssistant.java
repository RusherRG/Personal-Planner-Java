import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.FileWriter;

import javax.swing.Action;
import java.io.FileWriter;
import java.io.FileReader;

public class VirtualAssistant extends JFrame {

	String username;
	int action_done = 0;
	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirtualAssistant frame = new VirtualAssistant("RusherRG");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VirtualAssistant(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(10, 223, 357, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setAction(action);
		btnSend.setBounds(366, 223, 70, 40);
		contentPane.add(btnSend);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 86, 179, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	public void reply(String text) {
		if(action_done==2) {
			int id = Integer.parseInt(text);
			new ToDo().DeleteTask(username, id);
			try {
				FileWriter fw = new FileWriter("D://GitHub Repository//Personal-Planner-Java//src//msg.txt");
				fw.write("Task Deleted Successfully");
				fw.close();
			}
			catch(Exception exp) {System.out.println(exp);}
			action_done = 0;
			return;
		}
		if(action_done==1) {
			new ToDo().AddToDo(username, text);
			try {
				FileWriter fw = new FileWriter("D://GitHub Repository//Personal-Planner-Java//src//msg.txt");
				fw.write("Task Added Successfully");
				fw.close();
			}
			catch(Exception exp) {System.out.println(exp);}
			action_done = 0;
			return;
		}
		action_done = -1;
		String questions[] = {"What can you do? How can you help me?","Add a new task to ToDo","Remove a task from ToDo","Display my ToDo list","Set the Reminder time","Remove the Reminders"};
		String answers[] = {"Set up Reminders\nAdd tasks to your Todo list\nRemove tasks from your Todo list","What do you want to add?","Which task do you want to remove?","These are your Tasks","Okay. At what time do you want the Reminders?","Okay. Sure"};
		int max = -1,ind = 0,it=0;
		for(String i:questions) {
			int count = 0;
			for(String j:i.split("\\s+")) {
				for(String k:text.split("\\s+")) {
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
		try {
			FileWriter fw = new FileWriter("D://GitHub Repository//Personal-Planner-Java//src//msg.txt");
			if(ind==0) {
				fw.write(answers[ind]);
			}
			if(ind==1) {
				//String act = sc.nextLine();
				fw.write(answers[ind]);
				action_done = 1;
			}
			if(ind==2) {
				new ToDo().DisplayTasks(username);
				fw.write(answers[ind]+"\n");
				FileReader fr = new FileReader("D://GitHub Repository//Personal-Planner-Java//src//mail_content.txt");
				int c = fr.read();
				while(c!=-1) {
					fw.write((char)c);
					c = fr.read();
				}
				fr.close();
				fw.write("\nMention the ID");
				action_done = 2;
			}
			if(ind==3) {
				fw.write(answers[ind]+"\n");
				new ToDo().DisplayTasks(username);
				FileReader fr = new FileReader("D://GitHub Repository//Personal-Planner-Java//src//mail_content.txt");
				int c = fr.read();
				while(c!=-1) {
					fw.write((char)c);
					c = fr.read();
				}
				fr.close();
				action_done = 0;
			}
			fw.close();
		}
		catch(Exception exp) {System.out.println(exp);}
	}
	
	public void speech() {
		try {
			String s = "python D:/\"GitHub Repository\"/Personal-Planner-Java/src/test.py";
			Process p = Runtime.getRuntime().exec(s);
			System.out.println(s);
		}
		catch(Exception e) {System.out.println(e);}
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Send");
			putValue(SHORT_DESCRIPTION, "Send the message");
		}
		public void actionPerformed(ActionEvent e) {	
			reply(textField.getText());
			String msg = "";
			try {
				FileReader fr = new FileReader("D://GitHub Repository//Personal-Planner-Java//src//msg.txt");
				int c = fr.read();
				while(c!=-1) {
					msg += (char)c;
					c = fr.read();
				}
				fr.close();
			}
			catch(Exception exp) {System.out.println(exp);}
			textField_1.setText(msg);
			speech();
		}
	}
}

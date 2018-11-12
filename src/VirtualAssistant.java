import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.FileWriter;

import javax.swing.Action;
import java.io.FileWriter;
import java.io.FileReader;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;

public class VirtualAssistant extends JFrame {

	String username;
	int action_done = 0;
	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JTextArea textField_1;
	private JTextArea textArea;
	private JTextArea txtrHelloImAtom;

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
		setTitle("Atom - Your Virtual Assistant");
		this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 366);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String send = textField.getText();
				reply(send);
				textField.setText("");
				textArea.setText(send);
				textArea.setOpaque(true);
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
				textField_1.setOpaque(true);
				speech();
			}
		});
		textField.setBounds(10, 292, 340, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSend.setAction(action);
		btnSend.setBounds(360, 292, 75, 27);
		contentPane.add(btnSend);
		
		textField_1 = new JTextArea();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textField_1.setOpaque(false);
		textField_1.setLineWrap(true);
		textField_1.setEditable(false);
		textField_1.setForeground(Color.BLACK);
		textField_1.setBackground(new Color(192, 192, 192));
		textField_1.setBounds(10, 163, 288, 106);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Lucida Bright", Font.PLAIN, 15));
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setColumns(10);
		textArea.setBackground(Color.ORANGE);
		textArea.setBounds(192, 89, 243, 64);
		contentPane.add(textArea);
		
		txtrHelloImAtom = new JTextArea();
		txtrHelloImAtom.setText("Hello, I'm ATOM, your virtual assistant. How can I help you?");
		txtrHelloImAtom.setLineWrap(true);
		txtrHelloImAtom.setForeground(Color.BLACK);
		txtrHelloImAtom.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtrHelloImAtom.setEditable(false);
		txtrHelloImAtom.setColumns(10);
		txtrHelloImAtom.setBackground(Color.LIGHT_GRAY);
		txtrHelloImAtom.setBounds(10, 10, 288, 64);
		contentPane.add(txtrHelloImAtom);
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
		String questions[] = {"What can you do? How can you help me?","Add a new task to ToDo","Remove a task from ToDo","Display my ToDo list Show the tasks","Set the Reminder time","Remove the Reminders","Thanks","Hey","Are you really a Robot AI Computer Human",};
		String answers[] = {"I can : \nAdd tasks to your Todo list\nRemove tasks from your Todo list","What do you want to add?","Which task do you want to remove?","These are your Tasks","Okay. At what time do you want the Reminders?","Okay. Sure","You're Welcome :)","Hello "+username + ":)","Only as Human as you are :)"};
		if(text.toLowerCase().equals("close")) {
			dispose();
		}
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
			else if(ind==1) {
				//String act = sc.nextLine();
				fw.write(answers[ind]);
				action_done = 1;
			}
			else if(ind==2) {
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
			else if(ind==3) {
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
			else {
				fw.write(answers[ind]);
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
			String send = textField.getText();
			reply(send);
			textField.setText("");
			textArea.setText(send);
			textArea.setOpaque(true);
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
			textField_1.setOpaque(true);
			speech();
		}
	}
}

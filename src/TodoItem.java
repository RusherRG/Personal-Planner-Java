import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.SystemColor;

public class TodoItem extends JPanel{
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	JLabel lblTodoEntry;
	int id;
	JButton btnDelete;
	JButton btnDone;
	TodoItem(String todo, int id){
		setBackground(SystemColor.inactiveCaptionBorder);
	//JPanel panel_6 = new JPanel();
	this.id = id;
	this.setName("todo"+id);
	this.setSize(466, 21);
	//main_todo.add(panel_6);
	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	JLabel lblTodoEntry = new JLabel(todo);
	
	btnDone = new JButton("");
	btnDone.setAction(action);
	//btnDone.setIcon(new ImageIcon(Mainpage.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Strikethrough-Black.png")));
	btnDone.setToolTipText("Complete task");
	btnDone.setBackground(new Color(152, 251, 152));
	btnDone.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnDone.setVisible(false);
			btnDelete.setVisible(false);
			lblTodoEntry.setFont(new Font("Tahoma",Font.ITALIC,11));
			lblTodoEntry.setText("Task completed");
		}
	});
	add(btnDone);
	
	btnDelete = new JButton("");
	btnDelete.setAction(action_1);
	//btnDelete.setIcon(new ImageIcon(Mainpage.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
	btnDelete.setToolTipText("Delete task");
	btnDelete.setBackground(new Color(255, 0, 0));
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnDone.setVisible(false);
			btnDelete.setVisible(false);
			lblTodoEntry.setFont(new Font("Tahoma",Font.ITALIC,11));
			lblTodoEntry.setText("Task deleted");
		}
	});
	add(btnDelete);
	
	Component rigidArea_1 = Box.createRigidArea(new Dimension(10, 20));
	add(rigidArea_1);
	
	//JLabel lblTodoEntry = new JLabel(todo);
	add(lblTodoEntry);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Complete task");
		}
		public void actionPerformed(ActionEvent e) {
			try{
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
				Statement st = c.createStatement();
				st.execute("USE test");
				st.execute("UPDATE todo SET status=1 WHERE id="+id+" AND status=0");
			}catch(Exception exc){System.out.println(exc+"Complete");}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Delete task");
		}
		public void actionPerformed(ActionEvent e) {
			
			try{
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
				Statement st = c.createStatement();
				st.execute("USE test");
				st.execute("UPDATE todo SET status=-1 WHERE id="+id+" AND status=0");
				
			}catch(Exception exc){System.out.println(exc+"Delete");}
		}
	}
}

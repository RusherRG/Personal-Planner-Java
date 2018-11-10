import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JToggleButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

public class Mainpage extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	String username;
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private JPanel panel_6;
	private JPanel main_todo;
	private JPanel To_do = new JPanel();
	private JTextArea txtrTodo;
	private JTable table;
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	JSpinner spinner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage("user");
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
	public Mainpage(String username) {
		setBackground(Color.WHITE);
		this.username = username;
		System.out.println(username);
		setTitle("Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.menu);
		tabbedPane.addTab("Home\r\n", null, panel, null);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Assistant");
		btnNewButton.setAction(action_1);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(400, 465, 85, 80);
		panel.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 483, 126);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblHelloUser = new JLabel("Hello "+username);
		lblHelloUser.setBounds(10, 11, 473, 104);
		panel_4.add(lblHelloUser);
		lblHelloUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloUser.setFont(new Font("Calibri", Font.PLAIN, 40));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(SystemColor.scrollbar);
		panel_5.setLayout(null);
		panel_5.setBounds(10, 148, 483, 306);
		panel.add(panel_5);
		
		JLabel lblNotifications = new JLabel("Day Overview");
		lblNotifications.setBackground(SystemColor.activeCaption);
		lblNotifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifications.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNotifications.setBounds(10, 11, 473, 50);
		panel_5.add(lblNotifications);
		
		//JPanel panel_2 = new JPanel();
		To_do.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		To_do.setBackground(SystemColor.menu);
		tabbedPane.addTab("To-do", null, To_do, null);
		tabbedPane.setEnabledAt(1, true);
		To_do.setLayout(null);
		
		JButton button = new JButton("Assistant");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Calibri", Font.PLAIN, 11));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(418, 465, 85, 80);
		To_do.add(button);
		
		txtrTodo = new JTextArea();
		txtrTodo.setBackground(Color.LIGHT_GRAY);
		txtrTodo.setText("Todo");
		txtrTodo.setBounds(100, 465, 308, 41);
		To_do.add(txtrTodo);
		
		
		
		JPanel main_todo = new JPanel();
		main_todo.setBackground(SystemColor.menu);
		main_todo.setBounds(10, 40, 483, 414);
		To_do.add(main_todo);
		main_todo.setLayout(null);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	main_todo.repaint();
			}
		});
		btnAdd.setAction(action_2);
		btnAdd.setBounds(10, 465, 85, 41);
		To_do.add(btnAdd);
		
		try {
	        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = c.createStatement();
			st.execute("USE test");
			ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status=0");
			int i=0;
			while(rs.next()){
				String entry = rs.getString("todo");
				int id = rs.getInt("id");
				TodoItem td = new TodoItem(entry,id);
				td.setBounds(0,21*i,466,21);
				main_todo.add(td);
				i++;
				System.out.println(entry+"\t"+id);
			}
			//System.out.println(' '+username+','+currentTime+','+todo+','+0);
		}
		catch(Exception ec) {System.out.println(ec+"Init");}
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(467, 0, 16, 443);
		main_todo.add(scrollBar);
		
		JButton btnRefresh = new JButton("Refresh");
		//btnRefresh.setAction(action_4);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				try{
					//main_todo = (JPanel)(getParent().getParent().getParent());
					main_todo.removeAll();
					main_todo.setBackground(SystemColor.menu);
					main_todo.setLayout(null);
					JScrollBar scrollBar1 = new JScrollBar();
					scrollBar1.setBounds(467, 0, 16, 443);
					main_todo.add(scrollBar1);
					
					//main_todo = new JPanel();
					//main_todo.setBounds(10, 40, 483, 414);
					//panel_2.add(main_todo);
					//main_todo.setLayout(null);
				        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
						Statement st = c.createStatement();
						st.execute("USE test");
						ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status=0");
						int j=0;
						while(rs.next()){
							String entry = rs.getString("todo");
							int id = rs.getInt("id");
							TodoItem td = new TodoItem(entry,id);
							td.setBounds(0,21*j,466, 21);
							main_todo.add(td);
							j++;
						}
						//System.out.println(' '+username+','+currentTime+','+todo+','+0);
				}catch(Exception ex){System.out.println(ex+"Refresh");}
				System.out.println("Refresh");
				new ToDo().DisplayTasks(username);
			}
		});
		//btnRefresh.setIcon(new ImageIcon(Mainpage.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnRefresh.setToolTipText("Click and then reopen tab to refresh");
		btnRefresh.setBounds(378, 11, 100, 23);
		To_do.add(btnRefresh);
		
		
		Date date = new Date();
		SpinnerDateModel sm = 
		new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		spinner = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		spinner.setEditor(de);
		spinner.setBounds(21, 13, 85, 20);
		To_do.add(spinner);
		
		JButton btnSetTime = new JButton("Set Time");
		btnSetTime.setAction(action_5);
		btnSetTime.setBounds(116, 12, 85, 21);
		To_do.add(btnSetTime);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBorder(null);
		tabbedPane.addTab("Tasks done", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 36, 479, 404);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.menu);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_1.addTab("Today\r\n", null, panel_7, null);
		panel_7.setLayout(null);
		try {
	        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = c.createStatement();
			st.execute("USE test");
			ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status=1 AND time>CURDATE()-1");
			int i=0;
			while(rs.next()){
				String entry = rs.getString("todo");
				int id = rs.getInt("id");
				DoneItem done = new DoneItem(entry,id);
				done.setBounds(10,11+21*i,430,21);
				panel_7.add(done);
				i++;
			}
			//System.out.println(' '+username+','+currentTime+','+todo+','+0);
		}
		catch(Exception ec) {System.out.println(ec);}
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(447, 11, 17, 354);
		panel_7.add(scrollBar_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.menu);
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane_1.addTab("Past", null, panel_8, null);
		panel_8.setLayout(null);
		
		try {
	        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = c.createStatement();
			st.execute("USE test");
			ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status=1 AND time<CURDATE()");
			int i=1;
			while(rs.next()){
				String entry = rs.getString("todo");
				int id = rs.getInt("id");
				java.sql.Date d = rs.getDate("time");
				PastItem done = new PastItem(entry,id,d);
				done.setBounds(10,11+21*i,430,21);
				panel_8.add(done);
				i++;
			}
			//System.out.println(' '+username+','+currentTime+','+todo+','+0);
		}
		catch(Exception ec) {System.out.println(ec);}
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(447, 11, 17, 354);
		panel_8.add(scrollBar_2);
		
		JLabel lblTask = new JLabel("Task");
		lblTask.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTask.setBounds(155, 11, 39, 21);
		panel_8.add(lblTask);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(377, 11, 60, 21);
		panel_8.add(lblDate);
		
		JButton button_1 = new JButton("Refresh");
		//button_1.setIcon(new ImageIcon(Mainpage.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		button_1.setToolTipText("Click and then reopen tab to refresh");
		button_1.setBounds(378, 11, 100, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				panel_7.removeAll();
				panel_8.removeAll();
				panel_7.setBackground(SystemColor.menu);
				panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_7.setLayout(null);
				try {
			        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
					Statement st = c.createStatement();
					st.execute("USE test");
					ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status=1 AND time>CURDATE()-1");
					int i=0;
					while(rs.next()){
						String entry = rs.getString("todo");
						int id = rs.getInt("id");
						DoneItem done = new DoneItem(entry,id);
						done.setBounds(10,11+21*i,430,21);
						panel_7.add(done);
						i++;
					}
					//System.out.println(' '+username+','+currentTime+','+todo+','+0);
				}
				catch(Exception ec) {System.out.println(ec);}
				
				JScrollBar scrollBar_1 = new JScrollBar();
				scrollBar_1.setBounds(447, 11, 17, 390);
				panel_7.add(scrollBar_1);
				
				//refresh for past panel_8
				panel_8.setBackground(SystemColor.menu);
				panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel_8.setLayout(null);
				
				try {
			        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
					Statement st = c.createStatement();
					st.execute("USE test");
					ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status=1 AND time<CURDATE()");
					int i=0;
					while(rs.next()){
						String entry = rs.getString("todo");
						int id = rs.getInt("id");
						java.sql.Date d = rs.getDate("time");
						PastItem done = new PastItem(entry,id,d);
						done.setBounds(10,11+21*i,430,21);
						panel_8.add(done);
						i++;
					}
					//System.out.println(' '+username+','+currentTime+','+todo+','+0);
				}
				catch(Exception ec) {System.out.println(ec);}
				JScrollBar scrollBar_2 = new JScrollBar();
				scrollBar_2.setBounds(447, 11, 17, 354);
				panel_8.add(scrollBar_2);
			}
		});
		panel_2.add(button_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.menu);
		tabbedPane.addTab("Reminders", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnAssistant = new JButton("Assistant");
		btnAssistant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAssistant.setAction(action);
		btnAssistant.setForeground(Color.BLACK);
		btnAssistant.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnAssistant.setBackground(SystemColor.activeCaption);
		btnAssistant.setBounds(405, 465, 80, 80);
		panel_1.add(btnAssistant);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(SystemColor.menu);
		tabbedPane.addTab("Schedule", null, panel_3, null);
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(10, 11, 493, 384);
		panel_3.add(table);
		
		JButton btnEdit = new JButton("Save schedule");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEdit.setBounds(10, 406, 136, 36);
		panel_3.add(btnEdit);
		tabbedPane.setEnabledAt(4, true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Assistant");
			putValue(SHORT_DESCRIPTION, "Dont ask silly questions :)");
		}
		public void actionPerformed(ActionEvent e) {
			VirtualAssistant assist = new VirtualAssistant(username);
			assist.setVisible(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Add todo");
			putValue(SHORT_DESCRIPTION, "Add data to todo table");
		}
		public void actionPerformed(ActionEvent e) {
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			String todo = txtrTodo.getText();
			try {
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
				Statement st = con.createStatement();
				st.execute("USE test");
				st.execute("INSERT INTO todo (username,time,todo,status) VALUE ('"+username+"','"+currentTime+"','"+todo+"','"+0+"')");
				System.out.println(' '+username+','+currentTime+','+todo+','+0);
			}
			catch(Exception ec) {System.out.println(ec);}
			new ToDo().DisplayTasks(username);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Delete");
			putValue(SHORT_DESCRIPTION, "Delete item and set status -1");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Refresh");
			putValue(SHORT_DESCRIPTION, "Refresh list");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Set Time");
			putValue(SHORT_DESCRIPTION, "Set time for Reminders");
		}
		public void actionPerformed(ActionEvent e) {
			Date date = (Date)spinner.getValue();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            String time = format.format(date);
            System.out.println(time);
            new ToDo().DisplayTasks(username);
            new SendEmail().sendmail(username, time);
		}
	}
}

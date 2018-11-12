import java.awt.SystemColor;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PastItem extends JPanel{
	JCheckBox checkBox;
	int id;
	PastItem(String done,int id, Date date){
		//setBackground(SystemColor.inactiveCaptionBorder);
		//JPanel panel_9 = new JPanel();
		//setBackground(SystemColor.inactiveCaptionBorder);
		setSize(430, 21);
		this.id=id;
		setLayout(null);
		checkBox = new JCheckBox(done);
		checkBox.setBounds(0, 0, 331, 21);
		//checkBox.setBackground(SystemColor.inactiveCaptionBorder);
		checkBox.setForeground(SystemColor.desktop);
		checkBox.setSelected(true);
		checkBox.setEnabled(false);
		add(checkBox);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String pastDate = sdf.format(date);
		
		JLabel lblNewLabel = new JLabel(pastDate);
		lblNewLabel.setBounds(337, 0, 93, 21);
		add(lblNewLabel);
	}
}

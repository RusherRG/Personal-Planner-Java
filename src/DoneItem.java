import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DoneItem extends JPanel{
	JCheckBox checkBox;
	int id;
	DoneItem(String done,int id){
		//setBackground(SystemColor.inactiveCaptionBorder);
		//JPanel panel_9 = new JPanel();
		//setBackground(SystemColor.inactiveCaptionBorder);
		setSize(430, 21);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.id=id;
		checkBox = new JCheckBox(done);
		//checkBox.setBackground(SystemColor.inactiveCaptionBorder);
		checkBox.setForeground(SystemColor.desktop);
		checkBox.setSelected(true);
		checkBox.setEnabled(false);
		add(checkBox);
	}
}

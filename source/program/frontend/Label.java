package program.frontend;

import javax.swing.JLabel;

public class Label {

	public JLabel setLabel(String type, String message, int x, int y) {
		JLabel label = new JLabel(message);
		if (type == "msg") {
			label.setSize(150, 25);
		}
		if (type == "time") {
			label.setSize(80, 25);
		}
		label.setLocation(x, y);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVisible(true);
		return label;
	}

}

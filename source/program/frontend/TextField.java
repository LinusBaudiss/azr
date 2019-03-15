package program.frontend;

import javax.swing.JTextField;

public class TextField {

	public JTextField setTextField(int x, int y) {
		JTextField textField = new JTextField();
		textField.setSize(80, 25);
		textField.setLocation(x, y);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setVisible(true);
		return textField;
	}

}

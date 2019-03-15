package program.frontend;

import javax.swing.JButton;

public class Button {

	public JButton setButton(int x, int y) {
		JButton button = new JButton("Arbeitszeit berechnen");
		button.setSize(250, 25);
		button.setLocation(x, y);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVisible(true);
		return button;
	}

}



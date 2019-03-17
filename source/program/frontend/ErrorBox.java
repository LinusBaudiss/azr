package program.frontend;

import javax.swing.JOptionPane;

public class ErrorBox {
	
	private ErrorBox() {}

	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

}

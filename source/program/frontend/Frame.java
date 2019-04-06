package program.frontend;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import program.backend.Logic;
import program.exceptions.StartTimeInTheFutureException;
import program.exceptions.StartTimeNotPossibleException;
import program.exceptions.TimeFailureException;

public class Frame {

	private Label l = new Label();
	private JLabel label1 = l.setLabel("time", "", 195, 75);
	private JLabel label2 = l.setLabel("time", "", 195, 125);
	private JLabel label3 = l.setLabel("time", "", 195, 175);

	private TextField tFs = new TextField();
	private JTextField textField = tFs.setTextField(195, 25);

	private Button b = new Button();
	private JButton button = b.setButton(25, 225);

	private Logic logic = null;

	private Timer timer;
	private long actualTime = 0;

	private ActionListener buttonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			timer.stop();
			String errBox = "ErrorBox";
			try {
				logic = new Logic(textField.getText());
				label1.setText(logic.calculateTimePauseInclusive(8));
				label2.setText(logic.calculateTimePauseInclusive(10));
				timer.start();
			} catch (StartTimeNotPossibleException ex1) {
				clearLabels();
				ErrorBox.infoBox(
						ex1.getMessage()
								+ " Möglich sind Zeiteingaben von 6 bis 20 Uhr! Das Eingabeformat ist (HH:MM)!",
						errBox);
			} catch (StartTimeInTheFutureException ex2) {
				clearLabels();
				ErrorBox.infoBox(ex2.getMessage() + " Das Eingabeformat ist (HH:MM)!", errBox);
			} catch (TimeFailureException ex3) {
				String[] message = ex3.getMessage().split("-");
				ErrorBox.infoBox("Hinweis! Die " + message[0] + " Stunden können um " + message[1]
						+ " Stunden nicht erreicht werden!", errBox);
				if (message[0].compareTo("8") == 0) {
					label1.setText(message[2]);
				}
				label2.setText(message[2]);
				timer.start();
			}
		}
	};

	private ActionListener timeListener = new ActionListener() {

		/*
		 * Diese Methode beinhaltet einen Bug.
		 * Dies liegt an dem Wechsel zwischen Sommer- und Winterzeit.
		 * Hotfix:
		 * Wenn Winterzeit ist muss folgende Code Zeile benutzt werden
		 * int actualHours = (int) (actualTime / 1000 / 60 / 60 % 24 + 1);
		 * Bei Sommerzeit wiederum
		 * int actualHours = (int) (actualTime / 1000 / 60 / 60 % 24 + 2);
		 */ 
		@Override
		public void actionPerformed(ActionEvent e) {
			actualTime = System.currentTimeMillis();
			int actualHours = (int) (actualTime / 1000 / 60 / 60 % 24 + 2);
			int actualMinutes = (int) (actualTime / 1000 / 60 % 60);
			label3.setText(logic.updateFlexTime(actualHours, actualMinutes));
		}
	};

	public Frame() {
		addComponents(initFrame());
		timer = new Timer(1, timeListener);
	}

	public JFrame initFrame() {
		JFrame frame = new JFrame();
		Dimension d = frame.getToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Arbeitszeitrechner");
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setLocation((int) (d.getWidth() - frame.getWidth()) / 2, (int) ((d.getHeight() - frame.getHeight()) / 2));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		return frame;
	}

	public JFrame addComponents(JFrame frame) {
		frame.add(l.setLabel("msg", "Zeit des Kommens", 25, 25));
		frame.add(l.setLabel("msg", "8 Stunden", 25, 75));
		frame.add(label1);
		frame.add(l.setLabel("msg", "10 Stunden", 25, 125));
		frame.add(label2);
		frame.add(l.setLabel("msg", "Verbleibende Arbeitszeit", 25, 175));
		frame.add(label3);
		frame.add(textField);
		button.addActionListener(buttonListener);
		frame.add(button);
		return frame;
	}

	public void clearLabels() {
		label1.setText("");
		label2.setText("");
		label3.setText("");
	}

}

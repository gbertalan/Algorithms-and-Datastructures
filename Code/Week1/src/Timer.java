import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer {

	private JFrame frame = new JFrame("Check");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int sc_width = (int) screenSize.getWidth();
	private int sc_height = (int) screenSize.getHeight();

	private String message = "Set a message";
	private double minutes = 0.01;

	public Timer() {

		JPanel panel = new JPanel();

		Color color = randomLightColor();
		frame.getContentPane().setBackground(color);
		panel.setBackground(color);

		createTextField(panel, message, 15);

		createLabel(panel, "     ");
		createLabel(panel, "Sleep: ");

		JTextField textfield = new JTextField();
		textfield.setText(Double.toString(minutes));
		textfield.setColumns(3);
		panel.add(textfield);

		createLabel(panel, "minute(s)    ");

		JButton button = new JButton("Okay");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okayPressed();
			}

			protected void okayPressed() {
				minutes = Double.parseDouble(textfield.getText());
				Color color = randomLightColor();
				frame.getContentPane().setBackground(color);
				panel.setBackground(color);
				try {
					sleep();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});
		panel.add(button);

		JButton button2 = new JButton("Exit");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(button2);

		frame.getContentPane().setLayout(new FlowLayout());
		frame.add(panel);
		frame.setSize(500, 50);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setLocation((sc_width / 2) - 250, (sc_height / 2) - 25);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));

	}

	private Color randomLightColor() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		if(r<0.6f) r = 0.6f;
		if(g<0.6f) g = 0.6f;
		if(b<0.6f) b = 0.6f;
		Color randomColor = new Color(r, g, b);
		return randomColor;
	}

	private void sleep() throws InterruptedException {

		frame.setVisible(false);
		Thread.sleep((int) (minutes * 60000));
		frame.setVisible(true);

	}

	private void createTextField(JPanel parent, String text, int columns) {
		JTextField textfield = new JTextField();
		textfield.setText(text);
		textfield.setColumns(columns);
		parent.add(textfield);
	}

	private void createLabel(JPanel parent, String text) {
		JLabel label = new JLabel(text);
		parent.add(label);
	}

}

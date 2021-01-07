import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ProgressCanvas extends JPanel {
	int i = 0;
	String dots = "";
	Dimension dimension;

	public ProgressCanvas(Dimension dimension) {
		this.dimension = dimension;
	}

	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color niceGreen = new Color(0, 220, 0);
		g.setColor(niceGreen);
		g.fillRect(0, 1, MyClass.minutesPassed, 50);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, dimension.width - 1, dimension.height - 1);

		g.drawString("Minutes: " + Integer.toString(MyClass.minutesPassed) + " / 480", 10, ((dimension.height / 3) * 2) + 5);
//		g.drawString("Seconds: " + Integer.toString(MyClass.secondsPassed) + " / 28800", 10, ((dimension.height / 3) * 2) + 5);

		if (MyClass.secondsPassed > 0) {

//			g.drawString("Minutes: " + Integer.toString(MyClass.minutesPassed) + " / 480", 10,
//					(dimension.height / 3) + 5);

			if (i % 3 == 0) {
				dots = ".";
			} else if (i % 3 == 1) {
				dots = "..";
			} else if (i % 3 == 2) {
				dots = "...";
			}
			g.drawString("Running" + dots, 10, ((dimension.height / 3)) + 5);
		}

		if (MyClass.secondsPassed > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		++i;
		repaint();
	}
}
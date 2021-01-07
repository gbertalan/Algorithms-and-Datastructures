import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ShapedPane extends JPanel {

	public ShapedPane() {

		setOpaque(false);
		setLayout(new GridBagLayout());

		JButton button = new JButton("Close");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(button);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // To change body of generated methods, choose Tools | Templates.
		Graphics2D g2d = (Graphics2D) g.create();
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(hints);
		g2d.setColor(getBackground());
		g2d.fill(new Ellipse2D.Float(0, 0, getWidth(), getHeight()));
		g2d.dispose();
	}
}

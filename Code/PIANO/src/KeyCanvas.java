import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class KeyCanvas extends JPanel {
	
	BufferedImage img = null;
	
	int xPos = 0;
	int yPos = 0;
	int imageWidth = 100;
	int imageHeight = 100;
	
	public KeyCanvas() {
		try {
//	        img = ImageIO.read(new File("/image/background.png"));
			img = ImageIO.read(this.getClass().getResource("image/background.png"));
	    } catch (IOException e) {
	    	System.out.println("Hiba fajlolvasaskor");
	    }
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int keyboardWidth = this.getWidth();
		int keyboardHeight = this.getHeight();

		Color niceGreen = new Color(0, 220, 0);
		g.setColor(niceGreen);
		g.fillRect(0, 1, keyboardWidth, keyboardHeight);

		int j = 0;
		for (int i = 0; i < keyboardWidth; i = i + (keyboardWidth / 88)) {

			
				g.setColor(Color.WHITE);
				g.fillRoundRect(j, 3, keyboardWidth / 52, keyboardHeight - 5, 5, 5);
				g.setColor(Color.BLACK);
				g.drawRoundRect(j, 3, keyboardWidth / 52, keyboardHeight - 5, 5, 5);
			
			j= j + (keyboardWidth / 52);
		}

		
		g.drawImage(img, xPos, yPos, imageWidth, imageHeight, null);
		
		
		g.setColor(Color.BLACK);

		g.drawString("Minutes: ", 10, 100);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}

}

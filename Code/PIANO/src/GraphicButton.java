/**
 * 
 * Ez egy jo otlet lesz csinalni egy ilyen API-t magamnak, de legjobb lenne azt a kodot hasznalni,
 * amit mar kimentettem magamnak a masik gepre (pc). A canvas-os kodra gondolok.
 * 
 * Ezzel az a gond, h lerontja a kep minoseget.
 * Egy masik gond lehet az animalas.
 * 
 */














import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

import javax.swing.JPanel;

public class GraphicButton extends JPanel {
	
	private Dimension dimension;
	private BufferedImage buttonImage;
	private BufferedImage activeButton;
//	private BufferedImage argbImage;

	public GraphicButton(int locationX, int locationY, int width, int height, BufferedImage buttonImage, BufferedImage activeButton) {
		
		this.dimension = new Dimension(width, height);
		this.buttonImage = buttonImage;

		this.activeButton = activeButton;
		this.setBounds(locationX, locationY, width, height);
		
		
	}
	
	@Override
	public Dimension getPreferredSize() {
        return this.dimension;
    }
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Color niceGreen = new Color(0, 220, 0);
        g.setColor(niceGreen);
//        g.fillRect(0, 0, dimension.width, dimension.height);
        
        
        
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(hints);
		
        if (buttonImage != null) {
            g2d.drawImage(buttonImage, 0, 0, this);
        }
        g2d.dispose();
        
        g.setColor(Color.BLACK);
//        g.drawRect(0, 0, dimension.width, dimension.height);

    }
	
}

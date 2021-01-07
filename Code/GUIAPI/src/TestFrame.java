import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class TestFrame {
	
	BufferedImage buttonImage = null;
	
	public TestFrame() {
		
		JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        
		try {
			
			buttonImage = ImageIO.read(this.getClass().getResource("resources/background.png"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		GraphicButton b1 = new GraphicButton(50, 50, 100, 50, buttonImage, buttonImage);
		frame.getContentPane().add(b1);
		
		
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
	}
}

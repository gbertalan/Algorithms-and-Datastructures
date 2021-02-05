import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class GraphicalInterface implements KeyListener {

	BufferedImage buttonImage = null;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	KeyCanvas keyCanvas = new KeyCanvas();

	private int[] keyArray = { KeyEvent.VK_CONTROL, KeyEvent.VK_Z, KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_V,
			KeyEvent.VK_B, KeyEvent.VK_N, KeyEvent.VK_M, KeyEvent.VK_COMMA, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH,
			KeyEvent.VK_SHIFT, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F,
			KeyEvent.VK_G, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_SEMICOLON,
			KeyEvent.VK_COLON, KeyEvent.VK_TAB, KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_R,
			KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U, KeyEvent.VK_I, KeyEvent.VK_O, KeyEvent.VK_P,
			KeyEvent.VK_BRACELEFT, KeyEvent.VK_BACK_QUOTE, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4,
			KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_0,
			KeyEvent.VK_MINUS };

	private boolean[] keyIsDown = new boolean[48];

	public GraphicalInterface() {

		JFrame frame = new JFrame("Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		try {

			buttonImage = ImageIO.read(this.getClass().getResource("image/background.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GraphicButton b1 = new GraphicButton(50, 50, 100, 50, buttonImage, buttonImage);
		//frame.getContentPane().add(b1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(132, 10, 1, 78);
		frame.getContentPane().add(separator_1);
		
		

		frame.addKeyListener(this);

//		frame.setLocationRelativeTo(null);
		frame.setLocation(0, 0);
		frame.setSize(screenSize.width, 500);
		frame.setVisible(true);
		
		keyCanvas.setSize(frame.getWidth(), frame.getWidth()/10);
		
		frame.getContentPane().add(keyCanvas);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < keyArray.length; i++) {
			if (e.getKeyCode() == keyArray[i] && keyIsDown[i] == false) {
				keyIsDown[i] = true;
				System.out.println(keyArray[i]);
				try {
					Player player = new Player();
					player.play(i + 20);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < keyArray.length; i++) {
			if (e.getKeyCode() == keyArray[i] && keyIsDown[i] == true) {
				keyIsDown[i] = false;

			}
		}

	}

}

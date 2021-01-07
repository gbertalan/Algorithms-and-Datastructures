import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShapedWindow {

    public static void main(String[] args) {
        new ShapedWindow();
    }

    public ShapedWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                    try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                JWindow frame = new JWindow();
                frame.setBackground(new Color(0, 0, 0, 0));
                frame.setContentPane(new ShapedPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setAlwaysOnTop(true);
            }
        });
    }
}
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MyClass {

	protected boolean running = false;
	private int progressValue = 0;
	Dimension progressBarSize = new Dimension(480, 51);
	ProgressCanvas progressCanvas = new ProgressCanvas(progressBarSize);

	static int minutesPassed = 0;
	static int secondsPassed = 0;

	static JLabel lblNewLabel;

	public MyClass() throws IOException {

		Worker worker = new Worker();

		System.setProperty("sun.java2d.opengl", "true");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int sc_width = (int) screenSize.getWidth();
		int sc_height = (int) screenSize.getHeight();

		JFrame frame = new JFrame("EightCount");
		
		frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("resources/background.jpg")))));

		JButton startButton = new JButton("Start");
		startButton.setBackground(Color.GRAY);
		startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JButton stopButton = new JButton("Stop");
		stopButton.setBackground(Color.GRAY);
		stopButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		Icon icon = new ImageIcon("resources/start1.png");

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				running = true;
				startButton.setEnabled(false);
				stopButton.setEnabled(true);

				System.out.println("running: " + running);

//				doWork();

				worker.execute();
			}
		});
		startButton.setBounds(24, 24, 85, 51);
		frame.getContentPane().add(startButton);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(132, 10, 1, 78);
		frame.getContentPane().add(separator_1);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize((int) 680, (int) 140);
		frame.setUndecorated(false);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocation((sc_width / 10), (sc_height / 10));
		frame.getContentPane().setLayout(null);

		progressCanvas.setBounds(158, 24, progressBarSize.width, progressBarSize.height);
		frame.getContentPane().add(progressCanvas);

	}

	protected void doWork() {
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				// Here not in the EDT
				for (int i = 0; i < 28800; i++) {
					// Simulates work
					Thread.sleep(1000);
					publish(i); // published values are passed to the #process(List) method
				}
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// chunks are values retrieved from #publish()
				// Here we are on the EDT and can safely update the UI
//                progressTextField.setText(chunks.get(chunks.size() - 1).toString());
				int number = chunks.get(chunks.size() - 1);
				System.out.println(number);
				secondsPassed = number;
			}

			@Override
			protected void done() {
				// Invoked when the SwingWorker has finished
				// We are on the EDT, we can safely update the UI
//                progressTextField.setText("Done");
				System.out.println("Done");
			}
		};
		worker.execute();
	}

	public static void createFile() {
		try {
			File myObj = new File("filename.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String textToWrite) {
		try {
			FileWriter myWriter = new FileWriter("filename.txt");
			myWriter.write(textToWrite);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void readFromFile() {
		try {
			File myObj = new File("filename.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void writeData() {
		Workbook wb = new HSSFWorkbook();
		// Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");

		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((short) 0);
		// Create a cell and put a value in it.
		Cell cell = row.createCell(0);
		cell.setCellValue(1);

		// Or do it on one line.
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
		row.createCell(3).setCellValue(true);

		// Write the output to a file
		try {
			FileOutputStream fileOut = new FileOutputStream("workbook.xls");

			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void readData() {
		try {
			File file = new File("workbook.xls");
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;

			int rows; // No of rows
			rows = sheet.getPhysicalNumberOfRows();

			int cols = 0; // No of columns
			int tmp = 0;

			// This trick ensures that we get the data properly even if it doesn't start
			// from first few rows
			for (int i = 0; i < 10 || i < rows; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					tmp = sheet.getRow(i).getPhysicalNumberOfCells();
					if (tmp > cols)
						cols = tmp;
				}
			}

			for (int r = 0; r < rows; r++) {
				row = sheet.getRow(r);
				if (row != null) {
					for (int c = 0; c < cols; c++) {
						cell = row.getCell((short) c);
						if (cell != null) {
							// Your code here
							System.out.println(cell.getNumericCellValue());
						}
					}
				}
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

	class Worker extends SwingWorker<Void, Integer> {

		int counter = 0;

		@Override
		protected Void doInBackground() throws Exception {
			// Here not in the EDT
			for (int i = secondsPassed; i < 28800; i++) {
				// Simulates work
				Thread.sleep(1000);
				publish(i); // published values are passed to the #process(List) method
			}
			return null;
		}

		@Override
		protected void process(List<Integer> chunk) {

			// get last result
			Integer counterChunk = chunk.get(chunk.size() - 1);

//            System.out.println("Workerclass: " + counterChunk);
//            lblNewLabel.setText(counterChunk.toString());
			secondsPassed = counterChunk;
			if ((secondsPassed) % 60 == 0 && secondsPassed > 10) {
				++minutesPassed;
			}
		}

		@Override
		protected void done() {
			// Invoked when the SwingWorker has finished
			// We are on the EDT, we can safely update the UI
			System.out.println("Done");
		}

	}
}

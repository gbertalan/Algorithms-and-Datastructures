import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DeleteRowNumbers {

	public static void main(String[] args) {

		File file = new File("input.java"); // create File object to read from
		Scanner scanner;
		OutputStreamWriter writer;
		try {
			scanner = new Scanner(file);

			writer = new OutputStreamWriter(new FileOutputStream("output.java"), StandardCharsets.UTF_8);

			while (scanner.hasNextLine()) { // while there is a next line
				String line = scanner.nextLine(); // line = that next line

				// do something with that line
				String newLine = "";

				// replace a character
				for (int i = 0; i < line.length(); i++) {
					if (Character.isDigit(line.charAt(i)) && i < 2) { // or anything other character you chose

					} else {
						if (line.charAt(i) == '∗') {
							newLine += '*';
						} else
							newLine += line.charAt(i);
					}
				}

				newLine = newLine + "\n";
				// print to another file.
//				writer.println(line);
				writer.append(newLine);

			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

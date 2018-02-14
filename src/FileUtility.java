import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtility {

	public Scanner RequestForValidFile(Scanner scanObject) {
		String fileName = "C:\\chaitanya\\Rowan\\Data Structures And Algorithm\\Lab2_ListLab\\src\\SongList.txt";

		File file = new File(fileName);
		try {
			Scanner readFile = new Scanner(file);
			return readFile;
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name " + fileName);
			return null;
		}
	}
}

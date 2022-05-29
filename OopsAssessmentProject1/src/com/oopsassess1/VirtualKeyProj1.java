package com.oopsassess1;

//Guneet Pal Singh
// LockedMe.com / Project Phase 1

//package com.company;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
/**
 * This class allows users to find, create and delete files from the file
system.
 */
public class VirtualKeyProj1 {
	static File folder = new File("E://LockmeProj1");
	// Just one scanner is used along the application
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		//Boolean to identify if the loop continues or not
		boolean bExit = false;
		// Option Selected
		Integer iResponse = 0;
		System.out.println("------------------------------------------------------");
		System.out.println("-------------Welcome to Lockme.com First Project-------------");
		System.out.println("------------------------------------------------------");
		System.out.println("------------ Designed by Guneet Pal Singh --------------");
		System.out.println("--------------------------------------------------------");
		// Exits when user selects option 5
		while (!bExit) {
			// The menu is painted on screen
			menu();
			try {
				// User input is read
				iResponse = Integer.parseInt(scanner.nextLine());
				PrintMessage(" > Selected: " + iResponse);
				// Choose the option selected by user
				switch (iResponse) {
				case 1: {
					//All files are painted on screen
					Random random = new Random();
					int rn = random.nextInt(6) + 1;
					switch (rn) {
					case 1:
						// Get all files using a for loop
						getAllFiles_forLoop();
						break;
					case 2:
						// Get all files using a while loop
						getAllFiles_while();
						break;
					case 3:
						// Get all files using a for each loop
						getAllFiles_forEachLoop();
						break;
					case 4:
						// Get all files using an iterator of a linkedlist
						getAllFiles_Iterator();
						break;
					case 5:
						// Get all files using an iterator of a linkedlist
						getAllFiles_LambdaExpression();
						break;
					case 6:
						// Get all files using the Enumeration Interface
						getAllFiles_EnumerationInterface();
						break;
					}
					break;
				}
				case 2: {
					createFile();
					break;
				}
				case 3: {
					deleteFile();
					break;
				}
				case 4: {
					searchFiles();
					break;
				}
				case 5: {
					//Exit the program
					bExit = true;
					break;
				}
				default: {
					bExit = true;
				}
				}
			}catch(NumberFormatException e){
				PrintMessage("Please print only numbers");
			}
		}
	}
	/**
	 * Get All files using a for loop
	 */
	public static void getAllFiles_forLoop() {
		//System.out.println("---> getAllFiles_forLoop");
		//Name of files are stored in an array
		File[] listOfFiles = folder.listFiles();
		//We use an Arraylist to contain the list of files
		List<File> alListOfFiles = new ArrayList<File>();
		Collections.addAll(alListOfFiles, listOfFiles);
		//Read the Arraylist using a for loop with the name of the files1
		try {
			for (int i = 0; i < alListOfFiles.size(); i++) {
				System.out.println(alListOfFiles.get(i));
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("Error: file not found");
		}
	}
	/**
	 * Get all files using a while loop and a linkedlist
	 */
	public static void getAllFiles_while() {
		//System.out.println("---> getAllFiles_while");
		File[] listOfFiles = folder.listFiles();
		LinkedList<File> llListOfFiles = new LinkedList<File>();
		//Get the list into the linkedlist
		Collections.addAll(llListOfFiles, listOfFiles);
		int counter = 0;
		//Traverse the linkedlist
		while (llListOfFiles.size() > counter) {
			System.out.println(llListOfFiles.get(counter));
			counter++;
		}
	}
	/**
	 * Get all the files using a for each loop
	 */
	public static void getAllFiles_forEachLoop() {
		//System.out.println("---> getAllFiles_forEachLoop");
		File[] listOfFiles = folder.listFiles();
		//Use a simplified loop
		for (File myFile : listOfFiles) {
			System.out.println(myFile.getName());
		}
	}
	/**
	 * Get all the files using a lambda expression
	 */
	public static void getAllFiles_LambdaExpression() {
		//System.out.println("---> getAllFiles_LambdaExpression");
		File[] listOfFiles = folder.listFiles();
		List<File> alListOfFiles = new ArrayList<>();
		Collections.addAll(alListOfFiles, listOfFiles);
		//The lambda expression get the file and prints it
		alListOfFiles.forEach((file) -> {
			System.out.println(file.getName());
		});
	}
	/**
	 * Get all files using the enumeration interface
	 */
	public static void getAllFiles_EnumerationInterface() {
		//System.out.println("---> getAllFiles_EnumerationInterface");
		File[] listOfFiles = folder.listFiles();
		List<File> alListOfFiles = new ArrayList<>();
		Collections.addAll(alListOfFiles, listOfFiles);
		//Use the interface to iterate through the list elements
		Enumeration<File> e = Collections.enumeration(alListOfFiles);
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement().getName());
		}
	}
	/**
	 * Return all files from directory
	 */
	public static void getAllFiles_Iterator() {
		//System.out.println("---> getAllFiles_Iterator");
		//Name of files are stored in an array
		File[] listOfFiles = folder.listFiles();
		//We use an Arraylist to contain the list of files
		List<File> alListOfFiles = new ArrayList<File>();
		Collections.addAll(alListOfFiles, listOfFiles);
		LinkedList<File> llListOfFiles = new LinkedList<>(alListOfFiles);
		//Read the Arraylist using an iterator with the name of the files
		try {
			Iterator<File> alListOfFilesIterator = llListOfFiles.iterator();
			while (alListOfFilesIterator.hasNext()) {
				System.out.println(alListOfFilesIterator.next());
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("Error: file not found");
		}
	}
	/**
	 * A file is deleted
	 *
	 * @param scannerdelete
	 */
	public static void deleteFile() {
		try {
			//Read the name of the file to delete
			System.out.println("Write the name of the file you want to delete:");
			File fileToDelete = new File(folder + "//" +
					scanner.nextLine());
			//On success
			if (fileToDelete.delete()) {
				PrintMessage("File deleted successfully.");
			} else {
				//On error
				PrintMessage("There was an error deleting the file");
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("There was an error deleting the file");
		}
	}
	/**
	 * Search for a specific file
	 */
	public static void searchFiles() {
		try {
			System.out.println("Write the name of the file you want to find:");
			File fileTofind = new File(folder + "//" +
					scanner.nextLine());
			// If the file existes
			if (fileTofind.exists()) {
				PrintMessage("File exists");
			} else {
				//If not a message is sent
				PrintMessage("File does not exist");
			}
			//On error an exception is raised
		} catch (Exception e) {
			PrintMessage("There was an error searching the file.");
		}
	}
	
	public static void createFile() {
		FileWriter writer = null;
		try {
			//Creating the file
			System.out.println("Please enter name of file");
			File newFile = new File(folder + "//" + scanner.nextLine());
			writer = new FileWriter(newFile);
			//Writing contents of file.
			System.out.println("Enter some data to be added in file");
			writer.write(scanner.nextLine());
			writer.close();
			PrintMessage("File created successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void menu() {
		System.out.println(" 1. Display all the files");
		System.out.println(" 2. Add a new file ");
		System.out.println(" 3. Delete a file ");
		System.out.println(" 4. Search a file ");
		System.out.println(" 5. Exit ");
		System.out.println("");
		System.out.println(" Select your choice");
	}
	static void PrintMessage(String message){
		System.out.println(" -----------------------------");
		System.out.println(" " + message);
		System.out.println(" -----------------------------");
	}
}
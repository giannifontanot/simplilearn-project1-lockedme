/**
 * Gianni Fontanot
 * MS FSD DEC 2021 Cohort 1
 * LockedMe.com / Project Phase 1
 */

package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

/**
 * This class allows users to find, create and delete files from the file system.
 */
public class LockMe {
    static File folder = new File("C:\\Users\\giann\\Documents\\CODE\\Simplilearn-Java\\COURSE 2-Implementing" +
            " " +
            "OOPS Using Java with Data Structures and Beyond\\7-Project\\out\\production\\7-Project\\com\\company");

    // Just one scanner is used along the application
    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    ;

    /**
     * Main Class.
     * No arguments are used
     *
     * @param args
     */
    public static void main(String[] args) {
        //Boolean to identify if the loop continues or not
        boolean bExit = false;
        // Option Selected
        Integer iResponse = 0;
        // Exits when user selects option 5
        while (!bExit) {
            // The menu is painted on screen
            menu();
            // User input is read
            iResponse = Integer.parseInt(scanner.nextLine());
            System.out.println(" -----------------------------");
            System.out.println(" > Selected: " + iResponse);
            System.out.println(" -----------------------------");
            // Choose the option selected by user
            switch (iResponse) {
                case 1: {
                    //All files are painted on screen
                    getAllFiles();
                    break;
                }
                case 2: {
                    //User defines name and contents of a new file
                    createFile(scanner);
                    break;
                }
                case 3: {
                    //User chooses a file to delete
                    deleteFile(scanner);
                    break;
                }
                case 4: {
                    //Determine is a file exists
                    searchFiles(scanner);
                    break;
                }
                case 5: {
                    //Exit the program
                    bExit = true;
                    break;
                }
                default: {
                    //On error the program ends
                    bExit = true;
                }
            }
        }
    }

    /**
     * Return all files from directory
     */
    public static void getAllFiles() {
        //Name of files are stored in an array
        File[] listOfFiles = folder.listFiles();
        //Read the array with the name of the files
        try {
            if (listOfFiles != null && listOfFiles.length > 0) {
                for (var myFile : listOfFiles) {
                    System.out.println(myFile.getName());
                }
            }
            //On error an exception is raised
        } catch (Exception e) {
            System.out.println("Error: no file found");
        }
    }

    /**
     * A file is deleted
     *
     * @param scannerdelete
     */
    public static void deleteFile(Scanner scannerdelete) {
        try {
            //Read the name of the file to delete
            System.out.println("Write the name of the file you want to delete:");
            File fileToDelete = new File(folder + "//" + scannerdelete.nextLine());
            //On success
            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully");
            } else {
                //On error
                System.out.println("'There was an error deleting the file.'");
            }
        //On error an exception is raised
        } catch (Exception e) {
            System.out.println("There was an error deleting the file");
        }
    }

    /**
     * Search for a specific file
     */
    public static void searchFiles(Scanner scannerSearch) {
        try {
            //Name of the file to find
            System.out.println("Write the name of the file you want to find:");
            File fileTofind = new File(folder + "//" + scannerSearch.nextLine());
            // If the file existes
            if (fileTofind.exists()) {
                System.out.println("File exists");
            } else {
                //If not a message is sent
                System.out.println("'File does not exist'");
            }
            //On error an exception is raised
        } catch (Exception e) {
            System.out.println("There was an error searching for the file");
        }
    }

    /**
     * User creates a new file
     * @param scannerCreate
     */
    public static void createFile(Scanner scannerCreate) {

        //Writer object to use
        FileWriter writer = null;
        try {
            //Read the name of the file to create
            System.out.println("What is the name of your new file?");
            File newFile = new File(folder + "//" + scannerCreate.nextLine());
            writer = new FileWriter(newFile);
            //Read the contents of the file to create
            System.out.println("And the contents of your file are...");
            writer.write(scannerCreate.nextLine());
            writer.close();
            System.out.println("File created successfully");
            //On error an exception is raised
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The menu is painted on screen
     */
    public static void menu() {
        System.out.println("\n");
        System.out.println("****************************************************");
        System.out.println("************* Welcome to LockMe.com ****************");
        System.out.println("****************************************************");
        System.out.println("*********** Designed by Gianni Fontanot ************");
        System.out.println("****************************************************");
        System.out.println("           1) Display all the files");
        System.out.println("           2) Add a new file ");
        System.out.println("           3) Delete a file ");
        System.out.println("           4) Search a file ");
        System.out.println("           5) Exit ");
        System.out.println("");
        System.out.println(" > Select an option...");
    }
}

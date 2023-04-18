//I started by preparing the program to read the input from input.txt file, display it, and show the menu options to the user.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class assignment3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);//Get input from the user
        String input = "input.txt";
        String cipher = Read(input);//Read the text from input.txt ->read function
        
        // Print the cipher text
        System.out.println("Cipher Text:");
        System.out.println(cipher);
        
        // Analysis code will be here
        
  
     
        
        // Menu options
        while (true) {
            System.out.println("Option:");
            System.out.println("1) Take replace rule");
            System.out.println("2) Exit");
            System.out.print("Option> ");
            String choose = scanner.nextLine();
            
            if (choose.equals("1")) {
                System.out.print("Enter replacement rule-> ");
                String replacement = scanner.nextLine();
                
                 //Replacement code will be here
            } 
            
            else if (choose.equals("2")) {
            break;
            } 
            
            else {
                System.out.println("Invalid option, please try again!! \n");
            }
        }
        System.out.println("Bye!!");
        scanner.close();
    }

    // Read Function
    private static String Read(String inputfile) {
        String inputtext = "";
        try {
            Scanner scanner = new Scanner(new File(inputfile));
            while (scanner.hasNextLine()) {
                inputtext =inputtext + scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
        return inputtext;
    }

}

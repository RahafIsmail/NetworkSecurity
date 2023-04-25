//I modified the code, now we would be able to see the cipher text in each time the user will enter the replacement rule, also i counted the analysis for both the cipher text and the plain text.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class assignment3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);//Get input from the user
        String input = "input.txt";
        String cipher = Read(input);//Read the text from input.txt ->read function
        
        // Print the cipher text
        System.out.println("Cipher Text:");
        System.out.println(cipher);
        
 
        // Menu options
        while (true) {
            
        //ANALYSIS
        int[] letter_Counter = Analysis(cipher);
        // Print the letter frequency analysis
        System.out.println("Analysis:");
        for (int i = 0; i < 26; i++) {// Iterate over each letter
            char letter = (char) ('A' + i);// we will use it to print the letter count.
            System.out.print(letter + "->" + letter_Counter[i] + ", ");
        }
       System.out.println("\n");
            
            
            System.out.println("Option:");
            System.out.println("1) Take replace rule");
            System.out.println("2) Exit");
            System.out.print("Option> ");
            String choose = scanner.nextLine();
            
            if (choose.equals("1")) {
                System.out.print("Enter replacement rule-> ");
                String replacement = scanner.nextLine();                
                
               // Split the replacement rule 
               String[] split = replacement.split(",");

               // Loop through each replacement 
               for (int i = 0; i < split.length; i++) {
                 String[] value = split[i].split(":");
                 char beginning = value[0].charAt(0);
                 char end = value[1].charAt(0);                 
                 
                if (Character.isUpperCase(beginning)&&Character.isLowerCase(end)) {
                  System.out.println("\nCipher Text:");
                  System.out.println(cipher);
                  
                  //ANALYSIS
                  // Print the letter frequency analysis
                  System.out.println("\nAnalysis:");
                    for (int ii = 0; ii < 26; ii++) {// Iterate over each letter
                     char letter = (char) ('A' + ii);// we will use it to print the letter count.
                     System.out.print(letter + "->" + letter_Counter[ii] + ", ");
        }
                                         System.out.print("\n");

        
                     cipher = cipher.replace(beginning, end);
               } else {
                 System.out.println("Warning!! please make sure that your replacement rule format is correct!");
               return; // End the program
                  }
              
         
}
                // Print the new plain text
                System.out.println("\nPlain text:"+"\n"+ cipher+"\n");
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
    
    //Analysis Function
    private static int[] Analysis(String text) {
        int[] counter = new int[26];
         //In Java, characters are represented by their ASCII code.
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toUpperCase(text.charAt(i));// Convert the character to uppercase
            if (ch >= 'A' && ch <= 'Z') {// Check if the character is a letter between 'A' and 'Z'
            // Calculate the index of the corresponding letter in the counter array
            // by subtracting the ASCII value of 'A' from the ASCII value of the character
            // and increment the counter for that letter in the letterCounts array
            counter[ch - 'A']++;

            }
        }
        return counter;
    }

}

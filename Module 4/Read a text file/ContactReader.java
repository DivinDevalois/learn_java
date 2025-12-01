// ContactReader.java
// This program reads contact information from a file and displays it in a formatted way

// Step 1: Import necessary packages for file I/O operations
// Hint: You'll need classes from java.io or java.nio.file packages
// You'll also need Scanner for user input

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContactReader {
    public static void main(String[] args) {
        // Step 2: Create a Scanner object to read user input

        Scanner sc = new Scanner(System.in);

        // Step 3: Prompt the user to enter the file name containing contacts
        // Example: "Enter the name of the contacts file:"

        System.out.println("Enter the name of the contacts file:");

        // Step 4: Read the file name entered by the user
        String fileName = sc.nextLine();

        try {
            // Step 5: Create a FileReader or similar object to read the file
            // Hint: You can use FileReader, BufferedReader, or Files class

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Step 6: Read the file line by line
            // Hint: Use a loop to process each line

            String line;

            int contactCount = 0;

            while ((line = reader.readLine()) != null) {
                // S'assurer que la ligne n'est ni vide ni un espace blanc
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Step 7: Analyser chaque ligne pour extraire le nom et le numéro de téléphone
                // On suppose le format est "Nom:Téléphone"
                if (line.contains(":")) {
                    String[] parts = line.split(":", 2); // Limiter à 2 pour gérer les noms contenant des ':'

                    String name = parts[0].trim();
                    String phone = parts.length > 1 ? parts[1].trim() : "N/A";

                    // Step 8: Afficher les informations de contact de manière formatée
                    System.out.printf("Contact: %-25s | Téléphone: %s%n", name, phone);

                    contactCount++; // Incrémenter le compteur
                } else {
                    // Gérer les lignes qui ne correspondent pas au format attendu
                    System.out.println("[Attention] Ligne ignorée (format incorrect): " + line);
                }
            }

            // Step 7: Parse each line to extract name and phone number
            // Hint: Use String methods like split() to separate by colon

            // Step 8: Display the contact information in a formatted way
            // Example: "Contact: John Doe | Phone: +1-555-123-4567"

            // Step 9: Close the file reader when done

        } catch (FileNotFoundException e) {
            // Handle case where the file doesn't exist
            System.err.println("Error: File not found - " + fileName);
            System.err.println("Please check the file name and path and try again.");
        } catch (IOException e) {
            // Handle other I/O errors that may occur during reading
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected errors
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            sc.close();

            // Step 11 (Bonus): Afficher le nombre total de contacts lus
            System.out.println("\n--- Résumé ---");
        }
    }
}

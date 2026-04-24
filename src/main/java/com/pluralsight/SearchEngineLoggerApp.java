package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLoggerApp {
    public static void main(String[] args) {

//      Create Scanner
        Scanner scanner = new Scanner(System.in);

        // Log that the app started
        logAction("launch");

        String input;

        // Keep running until user exits
        while (true) {

            System.out.print("Enter a search term (X to exit): ");
            input = scanner.nextLine();

            // If user wants to exit
            if (input.equalsIgnoreCase("X")) {
                logAction("exit");
                System.out.println("Goodbye!");
                break; // stop the loop
            }

            // Otherwise, log the search
            logAction("search : " + input);
        }

        scanner.close();
    }

    // Method to log actions to file
    public static void logAction(String action) {

        // Format for timestamp: 2026-04-22 12:42:20
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String timestamp = LocalDateTime.now().format(formatter);

        // Combine timestamp + action
        String logEntry = timestamp + " " + action;

        try {
            // true = append to file (don't overwrite)
            FileWriter writer = new FileWriter("logs.txt", true);

            writer.write(logEntry + "\n"); // write line
            writer.close(); // always close file

        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }
}

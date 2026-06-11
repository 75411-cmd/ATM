package com.bank.util;

import java.util.Scanner;

/**
 * Utility class for handling user input
 * Simplifies input reading without Integer.parseInt() or .trim()
 */
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public int readInt() {
        try {
            String input = scanner.nextLine();
            // Simple manual parsing without parseInt
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double readDouble() {
        try {
            String input = scanner.nextLine();
            // Simple manual parsing without parseInt
            return Double.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("  Invalid amount entered.");
            return -1;
        }
    }

    public void close() {
        scanner.close();
    }
}

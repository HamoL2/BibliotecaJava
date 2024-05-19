/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

// Java Program to Illustrate Student Class
// to take Input from the Cliente and related Information
 
// Importing required classes
import java.util.Scanner;
 
// Class
public class Cliente {
 
    // Class member variables
    String NomeCliente;
    String RegNum;
 
    Libro[] LibriInPrestito = new Libro[3];
    public int ContaLibri = 0; 
 
    // Creating object of Scanner class to
    // take input from user
    Scanner input = new Scanner(System.in);
 
    // Constructor
    public Cliente()
    {
        // Print statement
        System.out.println("Inserisci il tuo nome per la registrazione:");
 
        // This keywords refers to current instance
        this.NomeCliente = input.nextLine();
 
        // Print statement
        System.out.println("Inserisci la password:");
        this.RegNum = input.nextLine();
    }
}

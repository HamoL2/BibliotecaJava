/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;
 
// Importing required classes
import java.util.Scanner;
 
// Class
public class Libro {
 
    // Class data members
    public int sNo;
    public String TitoloLibro;
    public String AutoreLibro;
    public int QuantitàLibri;
    public int QuantitàCopieLibri;
 
    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);
 
    // Method
    // To add Libro details
    public Libro()
    {
        // Display message for taking input later
        // taking input via
        // nextInt() and nextLine() standard methods
        System.out.println("Inserisci il numero seriale del libro:");
        this.sNo = input.nextInt();
        input.nextLine();
 
        System.out.println("Inserisci il titolo del libro:");
        this.TitoloLibro = input.nextLine();
 
        System.out.println("Inserisci il nome dell'autore:");
        this.AutoreLibro = input.nextLine();
 
        System.out.println("Inserisci la quantità di libri:");
        this.QuantitàLibri = input.nextInt();
        QuantitàCopieLibri = this.QuantitàLibri;
    }
}

// Java Program to Illustrate Application CLass
// To Create The Menu For the Program
 
package biblioteca;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.*;

// Class
public class Biblioteca {
 
    // Main driver method
    public static void main(String[] args)
    {
    	//Creo la finestra per l'interfaccia grafica
    	
    	JFrame finestra = new JFrame("Biblioteca");
    	finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	finestra.setSize(1000, 1000);
    	finestra.setVisible(true);
    	
    	//Creo un pannello
    	
    	JPanel pannello = new JPanel();
    	finestra.add(pannello);
        
    	//Jlabel è un etichetta di testo che serve appunto per mostrare del testo sull applicazione.
    	JLabel titoloInterfaccia = new JLabel("Benvenuti nella nostra biblioteca");
    	titoloInterfaccia.setBounds(650, 20, 10, 200);
    	// Font serve per dare uno stile ad una frase o ad una parola
    	Font aspetto = new Font ("Serif" , Font.PLAIN , 25);
    	titoloInterfaccia.setFont(aspetto);
    	pannello.add(titoloInterfaccia);
    	
    	JLabel sottotitoloOpzioni = new JLabel("Seleziona una tra le seguenti opzioni: ");
    	sottotitoloOpzioni.setBounds(320 , 10 , 40 , 25);
    	pannello.add(sottotitoloOpzioni);
    	
    	
        // Creating object of Scanner class
        // to take input from user
        Scanner input = new Scanner(System.in);
 
        // Displaying menu
        System.out.println(
            "********************Benvenuto nella nostra Biblioteca!********************");
        System.out.println(
            "                  Seleziona una tra le seguenti opzioni:               ");
        System.out.println(
            "**********************************************************************");
 
        // Creating object of Libro class
        Libri ob = new Libri();
        // Creating object of Clienti class
        Clienti obStudent = new Clienti();
 
        int choice;
        int searchChoice;
 
        // Creating menu
        // using do-while loop
        do {
 
            ob.Menu();
            choice = input.nextInt();
 
            // Switch case
            switch (choice) {
 
                // Case
            case 1:
                Libro b = new Libro();
                ob.AggiungiLibro(b);
                break;
 
                // Case
            case 2:
                ob.AumentaLibri();
                break;
 
            // Case
            case 3:
 
                System.out.println(
                    " press 1 to Search with Book Serial No.");
                System.out.println(
                    " Press 2 to Search with Book's Author Name.");
                searchChoice = input.nextInt();
 
                // Nested switch
                switch (searchChoice) {
 
                    // Case
                case 1:
                    ob.RicercaSNo();
                    break;
 
                    // Case
                case 2:
                    ob.searchByAuthorName();
                }
                break;
 
                // Case
            case 4:
                ob.MostraLibri();
                break;
 
                // Case
            case 5:
                Cliente s = new Cliente();
                obStudent.AggiungiCliente(s);
                break;
 
                // Case
            case 6:
                obStudent.MostraClienti();
                break;
 
                // Case
            case 7:
                obStudent.PrendiLibro(ob);
                break;
 
                // Case
            case 8:
                obStudent.RestituisciLibro(ob);
                break;
 
                // Default case that will execute for sure
                // if above cases does not match
            default:
 
                // Print statement
                System.out.println("ENTER BETWEEN 0 TO 8.");
            }
 
        }
 
        // Checking condition at last where we are
        // checking case entered value is not zero
        while (choice != 0);
    }
}

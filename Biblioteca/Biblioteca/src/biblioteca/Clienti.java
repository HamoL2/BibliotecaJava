/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Scanner;
 
// Class
public class Clienti {
 
    // Creating objects of Scanner and Clienti class
    Scanner input = new Scanner(System.in);
    Cliente theStudents[] = new Cliente[50];
 
    public static int conta = 0;
 
    // Method 1
    // To add Libri
    public void AggiungiCliente(Cliente s)
    {
        for (int i = 0; i < conta; i++) {
 
            if (s.RegNum.equalsIgnoreCase(theStudents[i].RegNum)) {
 
                // Print statement
                System.out.println(
                    "Student of Reg Num " + s.RegNum
                    + " è già esistente.");
 
                return;
            }
        }
 
        if (conta <= 50) {
            theStudents[conta] = s;
            conta++;
        }
    }
 
    // Method 2
    // Displaying all Clienti
    public void MostraClienti()
    {
        // Printing Cliente name and
        // corresponding registered number
        System.out.println("Nome Cliente\t\tNumero Registrato");
        for (int i = 0; i < conta; i++) {
 
            System.out.println(theStudents[i].NomeCliente
                               + "\t\t"
                               + theStudents[i].RegNum);
        }
    }
 
    // Method 3
    // To check the Student
    public int isStudent()
    {
        // Display message only
        System.out.println("Inserisci il numero registrato:");
 
        String regNum = input.nextLine();
 
        for (int i = 0; i < conta; i++) {
 
            if (theStudents[i].RegNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }
 
        // Print statements
        System.out.println("Cliente non registrato.");
        System.out.println("Registrati.");
 
        return -1;
    }
 
    // Method 4
    // To remove the Libro
    public void PrendiLibro(Libri libro)
    {
        int ClienteIndice = this.isStudent();
 
        if (ClienteIndice != -1) {
            System.out.println("Prendi in prestito");
 
            libro.MostraLibri();
            Libro b = libro.PrendiLibro();
 
            System.out.println("Prendi in prestito");
            if (b != null) {
 
                if (theStudents[ClienteIndice].ContaLibri
                    <= 5) {
 
                    System.out.println("Aggiungi un Libro");
                    theStudents[ClienteIndice].LibriInPrestito
                        [theStudents[ClienteIndice]
                             .ContaLibri]
                        = b;
                    theStudents[ClienteIndice].ContaLibri++;
 
                    return;
                }
                else {
 
                    System.out.println(
                        "Il Cliente non può prendere più di 5 libri.");
                    return;
                }
            }
            System.out.println("Libro non disponibile.");
        }
    }
 
    // Method 5
    // To add the Libro
    public void RestituisciLibro(Libri libro)
    {
        int ClienteIndice = this.isStudent();
        if (ClienteIndice != -1) {
 
            // Printing credentials corresponding to Cliente
            System.out.println(
                "S.No\t\t\tNome Libro\t\t\tNome Autore");
 
            Cliente C = theStudents[ClienteIndice];
 
            for (int i = 0; i < C.ContaLibri; i++) {
 
                System.out.println(
                    C.LibriInPrestito[i].sNo + "\t\t\t"
                    + C.LibriInPrestito[i].TitoloLibro + "\t\t\t"
                    + C.LibriInPrestito[i].AutoreLibro);
            }
 
            // Display message only
            System.out.println(
                "Inserisci il numero seriale del libro da prendere in prestito:");
 
            int sNo = input.nextInt();
 
            for (int i = 0; i < C.ContaLibri; i++) {
                if (sNo == C.LibriInPrestito[i].sNo) {
                    libro.RestituisciLibro(C.LibriInPrestito[i]);
                    C.LibriInPrestito[i] = null;
 
                    return;
                }
            }
 
            System.out.println("Book of Serial No " + sNo
                               + "Non trovato");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Scanner;

// CLass
public class Libri {

    // Class data members
    Libro[] Libreria = new Libro[50];
    public static int conta;

    Scanner input = new Scanner(System.in);

    // Method 1
    //  To compare Libri
    public int compareBookObjects(Libro b1, Libro b2) {

        // If Libro name matches
        if (b1.TitoloLibro.equalsIgnoreCase(b2.TitoloLibro)) {

            // Printing Libro exists
            System.out.println(
                    "Il nome di questo libro è gia esistente.");
            return 0;
        }

        // if Libro serial matches
        if (b1.sNo == b2.sNo) {

            // Print Libro exists
            System.out.println(
                    "Il numero seriale di questo libro è gia esistente.");

            return 0;
        }
        return 1;
    }

    // Method 2
    // To add Libro
    public void AggiungiLibro(Libro b) {

        for (int i = 0; i < conta; i++) {

            if (this.compareBookObjects(b, this.Libreria[i])
                    == 0) {
                return;
            }
        }

        if (conta < 50) {

            Libreria[conta] = b;
            conta++;
        } else {

            System.out.println(
                    "Spazio insufficiente per aggiungere altri libri.");
        }
    }

    // Method 3
    // To search Libro by serial number
    public void RicercaSNo() {

        // Display message
        System.out.println(
                "\t\t\t\tCERCA DAL NUMERO SERIALE\n");

        // Class data members
        int sNo;
        System.out.println("Inserisci il numero seriale del libro:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println(
                "Numero Seriale\t\tNome\t\tAutore\t\tQuantità Disponibile\t\tQuantità Totale");

        for (int i = 0; i < conta; i++) {
            if (sNo == Libreria[i].sNo) {
                System.out.println(Libreria[i].sNo + "\t\t"
                        + Libreria[i].TitoloLibro + "\t\t"
                        + Libreria[i].AutoreLibro + "\t\t"
                        + Libreria[i].QuantitàCopieLibri + "\t\t"
                        + Libreria[i].QuantitàLibri);
                flag++;
                return;
            }
        }
        if (flag == 0) {
            System.out.println("Numero Libri per Numero Seriale "
                    + sNo + " Trovato.");
        }
    }

    // Method 4
    // To search author by name
    public void searchByAuthorName() {

        // Display message
        System.out.println(
                "\t\t\t\tRICERCA PER AUTORE");

        input.nextLine();

        System.out.println("Inserisci nome dell'autore:");
        String NomeAutore = input.nextLine();

        int flag = 0;

        System.out.println(
                "S.No\t\tNome\t\tAutore\t\tQuantità Disponibile\t\tQuantità Totale");

        for (int i = 0; i < conta; i++) {

            // if author matches any of its Libro
            if (NomeAutore.equalsIgnoreCase(Libreria[i].AutoreLibro)) {

                // Print below corresponding credentials
                System.out.println(Libreria[i].sNo + "\t\t"
                        + Libreria[i].TitoloLibro + "\t\t"
                        + Libreria[i].AutoreLibro + "\t\t"
                        + Libreria[i].QuantitàCopieLibri + "\t\t"
                        + Libreria[i].QuantitàLibri);
                flag++;
            }
        }

        // Else no Libro matches for author
        if (flag == 0) {
            System.out.println("No Books of " + NomeAutore
                    + " Found.");
        }
    }

    // Method 5
    // To display all Libri
    public void MostraLibri() {

        System.out.println("\t\t\t\tMOSTRA TUTTI I LIBRI\n");
        System.out.println(
                "S.No\t\tNome\t\tAutore\t\tQuantità Disponibile\t\tQuantità Totale");

        for (int i = 0; i < conta; i++) {

            System.out.println(Libreria[i].sNo + "\t\t"
                    + Libreria[i].TitoloLibro + "\t\t"
                    + Libreria[i].AutoreLibro + "\t\t"
                    + Libreria[i].QuantitàCopieLibri + "\t\t"
                    + Libreria[i].QuantitàLibri);
        }
    }

    // Method 6
    // To edit the Libro
    public void AumentaLibri() {

        System.out.println(
                "\t\t\t\tAUMENTI QUANTITA LIBRI\n");
        System.out.println("Inserisci il numero seriale del libro:");

        int sNo = input.nextInt();

        for (int i = 0; i < conta; i++) {

            if (sNo == Libreria[i].sNo) {

                // Display message
                System.out.println(
                        "Inserisci il numero dei libri aggiunti:");

                int QuantitàAgg = input.nextInt();
                Libreria[i].QuantitàLibri += QuantitàAgg;
                Libreria[i].QuantitàCopieLibri += QuantitàAgg;

                return;
            }
        }
    }

    // Method 7
    // To create menu
    public void Menu() {

        // Displaying menu
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 Aggiungi un nuovo Libro.");
        System.out.println("Press 0 Arrivederci!.");
        System.out.println(
                "Press 2 Aumenta quantità dei libri.");
        System.out.println("Press 3 Ricerca Libro.");
        System.out.println("Press 4 Mostra tutti i Libri.");
        System.out.println("Press 5 Registra nuovo Cliente.");
        System.out.println(
                "Press 6 Mostra tutti i Clienti registrati.");
        System.out.println("Press 7 Prendi in prestito un libro. ");
        System.out.println("Press 8 Restituisci il libro");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    // Method 8
    // To search the library
    public int Disponibilie(int sNo) {

        for (int i = 0; i < conta; i++) {
            if (sNo == Libreria[i].sNo) {
                if (Libreria[i].QuantitàCopieLibri > 0) {

                    System.out.println(
                            "Libro è disponibile.");
                    return i;
                }
                System.out.println("Libro NON è disponibile");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number "
                + " Disponibile in Biblioteca.");
        return -1;
    }

    // Method 9
    // To remove the Libro from the library
    public Libro PrendiLibro() {

        System.out.println(
                "Inserisci il numero seriale del Libro da prendere in prestito.");
        int sNo = input.nextInt();

        int LibroIndice = Disponibilie(sNo);

        if (LibroIndice != -1) {
            Libreria[LibroIndice].QuantitàCopieLibri--;
            return Libreria[LibroIndice];
        }
        return null;
    }

    // Method 10
    // To add the Book to the Library
    public void RestituisciLibro(Libro b) {
        for (int i = 0; i < conta; i++) {
            if (b.equals(Libreria[i])) {
                Libreria[i].QuantitàCopieLibri++;
                return;
            }
        }
    }
}

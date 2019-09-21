/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd4o;

import com.db4o.*;
import java.util.Scanner;

/**
 *
 * @author erick
 */
public class BD4O {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ObjectContainer db = Db4o.openFile("/home/erick/Documents/dbase.yap");
        System.out.println("Lista de nuestros libros\n 1. Para agregar Libros\n2. Mostrar libros");
        //addData(db);
        //getBooks(db);       
        int number;
        String name;
        number = in.nextInt();

        if (number == 1) {
            System.out.print("Ingresa Nombre del libro");
            name = in.nextLine();
            name = in.nextLine();
            addNewBook(name, db);
        }
        if (number == 2) {
            getBooks(db);
        }

        db.close();
    }

    private static void getBooks(ObjectContainer base) {
        Book book = new Book(null);
        ObjectSet result = base.get(book);
        System.out.println("Tenemos " + result.size() + "Libros");
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    private static void addNewBook(String name, ObjectContainer base) {
        Book book = new Book(name);     
       
        base.set(book);
    }

    private static void addData(ObjectContainer base) {
        Book b1 = new Book("Harry Potter");
        Book b2 = new Book("Biblia");
        Book b3 = new Book("Mi lucha");
        Book b4 = new Book("Como ganar amigos");
        Book b5 = new Book("Las 21 leyes del liderazgo");
        Book b6 = new Book("Hakuna Matata");
        Book b7 = new Book("Cancion de hielo y fuego");

        Author a1 = new Author("Jose Perez", "USA");
        Author a2 = new Author("Jose Perez", "Bolivia");
        Author a3 = new Author("Jose Perez", "Argentina");

        //Agregando sus libros a los autores
        a1.AddBook(b1);
        a1.AddBook(b2);
        a1.AddBook(b3);
        a2.AddBook(b4);
        a2.AddBook(b5);
        a3.AddBook(b6);
        a3.AddBook(b7);

        //Agregando autores a sus libros
        b1.setAuthor(a1);
        b2.setAuthor(a1);
        b3.setAuthor(a1);
        b4.setAuthor(a2);
        b5.setAuthor(a2);
        b6.setAuthor(a3);
        b7.setAuthor(a3);

        base.set(a1);
        base.set(a2);
        base.set(a3);

    }
}

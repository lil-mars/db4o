/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd4o;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Author {
    private String name;
    private String city;
    private List books;
    public Author(String name,String city){
        this.name = name;
        this.city = city;
        this.books = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the books
     */
    public List getBooks() {
        return books;
    }
    
    public void AddBook(Book book){
        this.books.add(book);
    }

    /**
     * @param books the books to set
     */
     
}

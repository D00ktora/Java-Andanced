/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 9:06
 */
package P15_00IteratorsAndComparatorsLab;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<Book> {
        private int counter;

        public LibIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter <= books.length - 1;
        }

        @Override
        public Book next() {
            Book book = books[counter];
            this.counter++;
            return book;
        }
    }
}

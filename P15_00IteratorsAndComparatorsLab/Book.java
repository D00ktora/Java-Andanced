/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 25.3.2023 г.
 * Time: 8:57
 */
package P15_00IteratorsAndComparatorsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(String... authors) {
        if (authors.length > 0) {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        } else {
            this.authors = new ArrayList<>();
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        setAuthors(authors);
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.getTitle());

        if (result == 0) {
            result = Integer.compare(this.year, o.getYear());
        }
        return result;
    }
}

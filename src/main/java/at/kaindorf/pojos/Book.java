package at.kaindorf.pojos;

import at.kaindorf.xml.AuthorList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.ToString;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:10<br>
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlElement(name = "bookId")
    private int id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "url")
    private URI url;
    @XmlElement(name = "price")
    private double price;
    @XmlElement(name = "isbn")
    private String isbn;
    @XmlElement(name = "authorlist")
    private AuthorList authorList;

    private Publisher publisher;

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public URI getUrl() {
        return url;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (Double.compare(book.price, price) != 0) return false;
        if (!Objects.equals(title, book.title)) return false;
        if (!Objects.equals(url, book.url)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }

    public AuthorList getAuthorList() {
        return authorList;
    }
}

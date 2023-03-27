package at.kaindorf.pojos;

import at.kaindorf.xml.BookList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.net.URI;
import java.util.Objects;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:10<br>
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Publisher {
    @XmlElement(name = "publisherId")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "url")
    private URI url;
    @XmlElement(name = "booklist")
    private BookList bookList;

    public BookList getBookList() {
        return bookList;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (!Objects.equals(name, publisher.name)) return false;
        return Objects.equals(url, publisher.url);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}

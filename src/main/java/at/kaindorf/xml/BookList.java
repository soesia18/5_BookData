package at.kaindorf.xml;

import at.kaindorf.pojos.Book;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:28<br>
 */

@Getter
public class BookList {
    @XmlElement(name = "book")
    @XmlJavaTypeAdapter(BookAdapter.class)
    private List<Book> bookList;
}

package at.kaindorf.xml;

import at.kaindorf.pojos.Book;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 11:08<br>
 */

public class BookAdapter extends XmlAdapter<Book, Book> {
    @Override
    public Book unmarshal(Book book) throws Exception {
        return XML_Access.getInstance().getBook(book);
    }

    @Override
    public Book marshal(Book book) throws Exception {
        return book;
    }
}

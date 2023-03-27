package at.kaindorf.xml;

import at.kaindorf.pojos.Author;
import at.kaindorf.pojos.Book;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:37<br>
 */

public class AuthorAdapter extends XmlAdapter<Author, Author> {
    @Override
    public Author unmarshal(Author author) throws Exception {
        return XML_Access.getInstance().getAuthor(author);
    }

    @Override
    public Author marshal(Author author) throws Exception {
        return author;
    }
}

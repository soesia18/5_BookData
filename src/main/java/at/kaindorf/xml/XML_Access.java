package at.kaindorf.xml;

import at.kaindorf.pojos.Author;
import at.kaindorf.pojos.Book;
import at.kaindorf.pojos.Publisher;
import jakarta.xml.bind.JAXB;
import org.apache.commons.collections4.ListUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:15<br>
 */

public class XML_Access {
    private static XML_Access instance;

    private List<Publisher> publishers = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    private XML_Access() {
    }

    public static synchronized XML_Access getInstance() {
        if (instance == null) {
            instance = new XML_Access();
        }
        return instance;
    }

    public List<Publisher> loadbooks() {
        File file = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "books.xml").toFile();
        Books books = JAXB.unmarshal(file, Books.class);
        List<Publisher> publishers = new ArrayList<>();

        for (PublisherList publisherList: books.getPublisherLists()) {
            publishers.addAll(publisherList.getPublisherList());
        }

        return publishers;
    }

    public Book getBook (Book book) {
        if (books.contains(book)) {
            System.out.println("Book already exists");
            return books.get(books.indexOf(book));
        } else {
            books.add(book);
            book.getAuthorList().getAuthorList().forEach(author -> author.addBook(book));
            return book;
        }
    }

    public Author getAuthor (Author author) {
        if (authors.contains(author)) {
            System.out.println("Author already exists");
            return authors.get(authors.indexOf(author));
        } else {
            authors.add(author);
            return author;
        }
    }

    public Publisher getPublisher (Publisher publisher) {
        if (publishers.contains(publisher)) {
            System.out.println("Publisher already exists");
            return publishers.get(publishers.indexOf(publisher));
        } else {
            publishers.add(publisher);
            publisher.getBookList().getBookList().forEach(book -> book.setPublisher(publisher));
            return publisher;
        }
    }
}

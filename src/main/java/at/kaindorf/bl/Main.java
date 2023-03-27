package at.kaindorf.bl;

import at.kaindorf.pojos.Author;
import at.kaindorf.pojos.Book;
import at.kaindorf.pojos.Publisher;
import at.kaindorf.xml.XML_Access;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:09<br>
 */

public class Main {
    public static void main(String[] args) {
        List<Publisher> publishers = XML_Access.getInstance().loadbooks();
        System.out.println("[1]: " + publishers.stream().map(Publisher::getName).sorted(Comparator.naturalOrder()).collect(Collectors.joining(", ")));
        System.out.println("[2]: " + publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).mapToDouble(Book::getPrice).average().orElse(0.0d));
        System.out.println("[3]: " + publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).mapToDouble(Book::getPrice).sum());
        System.out.println("[4]: " + publishers.stream().collect(Collectors.toMap(Publisher::getName, publisher -> publisher.getBookList().getBookList().stream().sorted(Comparator.comparing(o -> o.getPublisher().getName())).collect(Collectors.toList()))));
        System.out.println("[5]: " + publishers.stream().collect(Collectors.toMap(Publisher::getName, publisher -> publisher.getBookList().getBookList().stream().flatMap(book -> book.getAuthorList().getAuthorList().stream()).collect(Collectors.toList()))));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Amount of Authors: ");
        int amount = scanner.nextInt();

        System.out.println("[6]: " + publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).filter(book -> book.getAuthorList().getAuthorList().size() == amount).toList());
        System.out.println("[7]: " + publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).filter(book -> book.getUrl().toString().isEmpty()).toList());
        publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).filter(book -> book.getPrice() > 30).forEach(book -> book.setPrice(book.getPrice() - 5));
        System.out.println("[8]: ");
        System.out.println("[9]: " + publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).flatMap(book -> book.getAuthorList().getAuthorList().stream()).filter(author -> publishers.stream().flatMap(publisher -> publisher.getBookList().getBookList().stream()).flatMap(book -> book.getAuthorList().getAuthorList().stream()).filter(author1 -> author1.equals(author)).count() >= 2).distinct().map(Author::getLastName).toList());

        IntStream.range(1, publishers.size() + 1).forEach(i -> publishers.get(i - 1).setId(i));
        System.out.println("[10]: ");

    }
}

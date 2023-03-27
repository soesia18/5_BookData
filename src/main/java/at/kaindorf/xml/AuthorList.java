package at.kaindorf.xml;

import at.kaindorf.pojos.Author;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;

import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:30<br>
 */

@Getter
public class AuthorList {
    @XmlElement(name = "author")
    @XmlJavaTypeAdapter(AuthorAdapter.class)
    private List<Author> authorList;
}

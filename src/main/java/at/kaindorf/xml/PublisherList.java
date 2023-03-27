package at.kaindorf.xml;

import at.kaindorf.pojos.Publisher;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:11<br>
 */

@Getter
public class PublisherList {
    @XmlElement(name = "publisher")
    @XmlJavaTypeAdapter(PublisherAdapter.class)
    private List<Publisher> publisherList = new ArrayList<>();
}

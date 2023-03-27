package at.kaindorf.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 09:10<br>
 */

@Getter
@XmlRootElement(name = "books")
public class Books {
    @XmlElement(name = "publisherlist")
    private List<PublisherList> publisherLists;
}

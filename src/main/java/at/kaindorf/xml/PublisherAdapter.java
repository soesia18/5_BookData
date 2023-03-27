package at.kaindorf.xml;

import at.kaindorf.pojos.Publisher;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> BookData<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 22. März 2023<br>
 * <b>Time:</b> 11:23<br>
 */

public class PublisherAdapter extends XmlAdapter<Publisher, Publisher> {
    @Override
    public Publisher unmarshal(Publisher publisher) throws Exception {
        return XML_Access.getInstance().getPublisher(publisher);
    }

    @Override
    public Publisher marshal(Publisher publisher) throws Exception {
        return publisher;
    }
}

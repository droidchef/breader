package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "item", strict = false)
public class Item {

    @Element(name = "guid")
    private Guid guid;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "link")
    private String link;

    @Attribute(name = "height", required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/", prefix = "media")
    private int height;

    @Attribute(name = "width", required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/", prefix = "media")
    private int width;

    @Attribute(name = "url", required = false)
    @Namespace(reference = "http://search.yahoo.com/mrss/", prefix = "media")
    private String url;

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

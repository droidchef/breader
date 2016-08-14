package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "item", strict = false)
@NamespaceList({
        @Namespace(reference="http://purl.org/dc/elements/1.1/", prefix = "dc"),
        @Namespace(reference = "http://purl.org/rss/1.0/modules/content/", prefix = "content"),
        @Namespace(reference = "http://www.w3.org/2005/Atom", prefix = "atom"),
        @Namespace(reference = "http://search.yahoo.com/mrss/", prefix = "media")
})
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

    @Element(name = "thumbnail")
    private Thumbnail thumbnail;

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

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Item{" +
                "guid=" + guid +
                ", pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }



}

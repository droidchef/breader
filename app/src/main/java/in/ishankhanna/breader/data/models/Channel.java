package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ishan Khanna
 */
@Root(name = "channel")
public class Channel {

    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "link")
    private String link;

    @Element(name = "lastBuildDate")
    private String lastBuildDate;

    @ElementList(name = "item", inline = true)
    private List<Item> items = new ArrayList<>();

    @Element(name = "image")
    private Image image;

    @Element(name = "generator")
    private String generator;

    @Element(name = "copyright")
    private String copyright;

    @Element(name = "language")
    private String language;

    @Element(name = "ttl")
    private long ttl;

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

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", items=" + items +
                ", image=" + image +
                ", generator='" + generator + '\'' +
                ", copyright='" + copyright + '\'' +
                ", language='" + language + '\'' +
                ", ttl=" + ttl +
                '}';
    }
}

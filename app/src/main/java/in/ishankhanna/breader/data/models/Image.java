package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "image")
public class Image {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

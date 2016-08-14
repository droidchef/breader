package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "thumbnail")
public class Thumbnail {

    @Attribute(name = "height")
    private int height;

    @Attribute(name = "width")
    private int width;

    @Attribute(name = "url")
    private String url;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "height=" + height +
                ", width=" + width +
                ", url='" + url + '\'' +
                '}';
    }
}


package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "guid")
public class Guid {

    private String content;

    @Attribute(name = "isPermaLink", required = true)
    private boolean permaLink;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPermaLink() {
        return permaLink;
    }

    public void setPermaLink(boolean permaLink) {
        this.permaLink = permaLink;
    }
}

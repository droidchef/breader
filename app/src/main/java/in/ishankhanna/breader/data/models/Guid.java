package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "guid")
public class Guid {

    private String content;

    @Attribute(required = true)
    private boolean isPermaLink;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPermaLink() {
        return isPermaLink;
    }

    public void setPermaLink(boolean permaLink) {
        isPermaLink = permaLink;
    }
}

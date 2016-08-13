package in.ishankhanna.breader.data.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "rss")
public class Rss {

    @Element(name = "channel")
    private Channel channel;

    @Attribute(name = "version")
    private String version;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

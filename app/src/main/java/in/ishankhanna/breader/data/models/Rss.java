package in.ishankhanna.breader.data.models;

/**
 * @author Ishan Khanna
 */
public class Rss {

    private Channel channel;

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

    @Override
    public String toString() {
        return "Rss{" +
                "channel=" + channel +
                ", version='" + version + '\'' +
                '}';
    }
}

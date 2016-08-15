package in.ishankhanna.breader.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * @author Ishan Khanna
 */
@Root(name = "thumbnail")
public class Thumbnail implements Parcelable {

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


    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.height);
        dest.writeInt(this.width);
        dest.writeString(this.url);
    }

    public Thumbnail() {}

    protected Thumbnail(Parcel in) {
        this.height = in.readInt();
        this.width = in.readInt();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Thumbnail> CREATOR = new Parcelable.Creator<Thumbnail>
            () {
        @Override
        public Thumbnail createFromParcel(Parcel source) {return new Thumbnail(source);}

        @Override
        public Thumbnail[] newArray(int size) {return new Thumbnail[size];}
    };
}


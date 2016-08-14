package in.ishankhanna.breader.data.local;

import in.ishankhanna.breader.data.models.Rss;

/**
 * @author Ishan Khanna
 */
public interface DataHelper {

    void addFeed(Rss rssFeed);

    Rss getFeed();

    int getFeedItemCount();

    boolean hasData();

    long feedLastUpdatedAt();

    void setFeedItemCount(int itemCount);

    void setFeedLastUpdatedAt(long feedLastUpdatedAt);

}

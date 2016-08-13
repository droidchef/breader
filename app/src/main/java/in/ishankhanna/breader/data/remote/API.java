package in.ishankhanna.breader.data.remote;

import in.ishankhanna.breader.data.models.Rss;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

/**
 * @author Ishan Khanna
 */
public class API {

    private static final String API_BASE_URL = "http://feeds.bbci.co.uk/";

    public static NewsFeedService newsFeedService;

    static {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        newsFeedService = retrofit.create(NewsFeedService.class);

    }

    public interface NewsFeedService {

        @GET("news/rss.xml")
        Call<Rss> getRssFeed();

    }


}

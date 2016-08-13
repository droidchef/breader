package in.ishankhanna.breader.ui.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import in.ishankhanna.breader.R;
import in.ishankhanna.breader.data.models.Rss;
import in.ishankhanna.breader.data.remote.API;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Call<Rss> channelCall = API.newsFeedService.getRssFeed();

        channelCall.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                if (response.isSuccessful()) {
                    System.out.println("Here");
                    System.out.println(response.body());
                } else {
                    System.out.println("OR Here");
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.e(TAG, "Channel Sync Failed", t);
            }
        });


    }
}

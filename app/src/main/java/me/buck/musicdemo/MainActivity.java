package me.buck.musicdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import me.buck.musicdemo.api.ApiUtils;
import me.buck.musicdemo.api.bean.BannerListResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiUtils.musicApi().getBanner().enqueue(new Callback<BannerListResult>() {
            @Override
            public void onResponse(Call<BannerListResult> call, Response<BannerListResult> response) {
                BannerListResult body = response.body();
                if (body != null && body.isSuccess()) {
                    Log.d(TAG, "onResponse: isSuccess");
                    Log.d(TAG, "onResponse: " + body.toJson());
                } else {
                    Log.d(TAG, "onResponse: failed");
                }
            }

            @Override
            public void onFailure(Call<BannerListResult> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: failed");
            }
        });

    }
}

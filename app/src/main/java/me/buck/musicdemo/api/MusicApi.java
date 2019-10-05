package me.buck.musicdemo.api;

import me.buck.musicdemo.api.bean.BannerListResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MusicApi {


    @GET("/banner?type=1")
    Call<BannerListResult> getBanner();
}

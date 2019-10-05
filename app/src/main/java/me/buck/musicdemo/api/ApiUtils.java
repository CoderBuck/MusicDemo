package me.buck.musicdemo.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {


    private static Retrofit sRetrofit ;

    private static MusicApi sMusicApi = retrofit().create(MusicApi.class);

    public static MusicApi musicApi() {
        return sMusicApi;
    }

    public static Retrofit retrofit() {
        if (sRetrofit == null) {
            createRetrofit();
        }
        return sRetrofit;
    }


    private static void createRetrofit() {
        if (sRetrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
    }
}

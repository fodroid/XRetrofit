package me.shihao.xretrofitdemo.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shihao on 2017/8/24.
 */

public interface GankService {

    @GET("data/{type}/{number}/{page}")
    Observable<GankResults> getGankData(@Path("type") String type, @Path("number") int number, @Path("page") int page);

}

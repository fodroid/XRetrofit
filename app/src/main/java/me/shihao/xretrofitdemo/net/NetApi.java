package me.shihao.xretrofitdemo.net;


import me.shihao.xretrofit.XApi;

/**
 * Created by wanglei on 2016/12/9.
 */

public class NetApi {
    private static final String API_BASE_URL = "http://gank.io/api/";

    private static GankService gankService;

    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (NetApi.class) {
                if (gankService == null) {
                    gankService = XApi.getInstance().getRetrofit(API_BASE_URL).create(GankService.class);
                }
            }
        }
        return gankService;
    }

}

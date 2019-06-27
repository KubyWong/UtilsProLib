package com.bluetree.utilspro.http;

import android.text.TextUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static final String BASE_URL = "https://api.apiopen.top/";
    private static Retrofit rf1;
    private static BytePayApiService allApiInCompany;

    /**
     * 默认使用公司的域名
     * @return
     */
    public static Retrofit getMyRetrofit() {
        if (rf1 == null) {
            rf1 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return rf1;
    }

    /**
     * 所有接口
     * @return
     */
    public static BytePayApiService getAllApiInCompany() {
        if (allApiInCompany == null) {
            allApiInCompany = getMyRetrofit().create(BytePayApiService.class);
        }
        return allApiInCompany;
    }


    /**
     * 创建自定义的
     * @param url
     * @return
     */
    public static Retrofit getMyRetrofit(String url) {
        if(TextUtils.isEmpty(url)) return getMyRetrofit();
        Retrofit rf = new Retrofit.Builder()
                .baseUrl(url)
                .build();
        return rf;
    }

}

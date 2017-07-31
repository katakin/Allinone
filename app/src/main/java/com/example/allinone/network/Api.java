package com.example.allinone.network;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by katakin on 21/07/17.
 */

public interface Api {
    @GET("{url}")
    Observable<ResponseBody> getRequest(
            @Path(value = "url", encoded = true) String url,
            @QueryMap Map<String, String> queryParams
    );

    @FormUrlEncoded
    @POST("{url}")
    Observable<ResponseBody> postRequest(
            @Path(value = "url", encoded = true) String url,
            @FieldMap Map<String, String> queryParams
    );
}

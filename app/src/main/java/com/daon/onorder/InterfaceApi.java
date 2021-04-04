package com.daon.onorder;

import com.daon.onorder.Model.MenuModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InterfaceApi {

    @FormUrlEncoded
    @POST("user")
    Call<JsonObject> postuser(@Field("email") String email, @Field("username") String username, @Field("password") String password);

    @GET("category")
    Call<JsonArray> getCategory(@Query("storecode") String code);

    @GET("menu")
    Call<JsonArray> getMenu(@Query("storecode") String code);

    @GET("menu")
    Call<JsonArray> getData(@Query("storecode") String code);

    @FormUrlEncoded
    @POST("service")
    Call<JsonObject> postService(@Field("storecode") String code, @Field("tableno") String tableno, @Field("service_body") String body, @Field("time") String time);

    @FormUrlEncoded
    @POST("cardresponse")
    Call<JsonObject> postCardresponse(@Field("classification") String classification, @Field("telegramtype") String telegramtype, @Field("dptid") String dptid, @Field("enterpriseinfo") String enterpriseinfo, @Field("fulltextnum") String fulltextnum,
                                      @Field("status") String status, @Field("authdate") String authdate, @Field("message1") String message1, @Field("message2") String message2,
                                      @Field("authnum") String authnum, @Field("franchiseid") String franchiseid, @Field("issuecode") String issuecode, @Field("cardname") String cardname,
                                      @Field("purchasecode") String purchasecode, @Field("purchasename") String purchasename, @Field("remain") String remain, @Field("point1") String point1,
                                      @Field("point2") String point2, @Field("point3") String point3, @Field("notice1") String notice1, @Field("notice2") String notice2, @Field("cardtype") String cardtype,
                                      @Field("cardno") String cardno, @Field("swmodelnum") String swmodelnum, @Field("readermodelnum") String readermodelnum, @Field("vantr") String vantr,
                                      @Field("cardbin") String cardbin);

    @FormUrlEncoded
    @POST("payment")
    Call<JsonObject> payment(@Field("storecode") String storecode, @Field("classification") String classification, @Field("telegramtype") String telegramtype, @Field("dptid") String dptid, @Field("enterpriseinfo") String enterpriseinfo, @Field("fulltextnum") String fulltextnum,
                                      @Field("status") String status, @Field("authdate") String authdate, @Field("message1") String message1, @Field("message2") String message2,
                                      @Field("authnum") String authnum, @Field("franchiseid") String franchiseid, @Field("issuecode") String issuecode, @Field("cardname") String cardname,
                                      @Field("purchasecode") String purchasecode, @Field("purchasename") String purchasename, @Field("remain") String remain, @Field("point1") String point1,
                                      @Field("point2") String point2, @Field("point3") String point3, @Field("notice1") String notice1, @Field("notice2") String notice2, @Field("cardtype") String cardtype,
                                      @Field("cardno") String cardno, @Field("swmodelnum") String swmodelnum, @Field("readermodelnum") String readermodelnum, @Field("vantr") String vantr, @Field("cardbin") String cardbin);


    @FormUrlEncoded
    @POST("order")
    Call<JsonObject> postOrder(@Field("storecode") String storecode, @Field("tableno") String tableno, @Field("menuno") String menuno, @Field("price") String price,
                           @Field("count") String count, @Field("totprice") String totprice, @Field("paytype") String paytype, @Field("menuname") String menuname, @Field("order_time") String order_time, @Field("auth_num") String autnnum,
                               @Field("auth_date") String auth_date, @Field("vantr") String vantr, @Field("cardbin") String cardbin);

    @FormUrlEncoded
    @POST("login")
    Call<JsonObject> LoginService(@Field("id") String id, @Field("pass") String pass, @Field("fcm") String fcm);

}

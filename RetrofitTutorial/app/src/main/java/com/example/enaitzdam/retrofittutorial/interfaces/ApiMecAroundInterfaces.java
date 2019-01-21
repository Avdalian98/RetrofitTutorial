package com.example.enaitzdam.retrofittutorial.interfaces;

import com.example.enaitzdam.retrofittutorial.responses.Averias;
import com.example.enaitzdam.retrofittutorial.responses.Marcas;
import com.example.enaitzdam.retrofittutorial.responses.ResponseAverias;
import com.example.enaitzdam.retrofittutorial.responses.ResponseMarcas;
import com.example.enaitzdam.retrofittutorial.responses.ResponseNuevaAveria;
import com.example.enaitzdam.retrofittutorial.responses.ResponseLogin;
import com.example.enaitzdam.retrofittutorial.responses.ResponseRegister;
import com.example.enaitzdam.retrofittutorial.responses.ResponseTalleres;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiMecAroundInterfaces {

    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseLogin> doLogin(@Field("email") String email,
                                @Field("password") String password);

    @GET("averia/lista")
    Call<ResponseAverias> getAverias(@Query("X-API-KEY") String key);

    @GET("datamaster/data")
    Call<ResponseMarcas> getMarcas(@Query("X-API-KEY") String key);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ResponseRegister> doRegister(@Field("nombre") String nombre,
                                      @Field("password") String password,
                                      @Field("email") String email);

    @FormUrlEncoded
    @POST("averia/nueva")
    Call<ResponseAverias> doRegisterAveria(@Query("X-API-KEY") String key,
                                           @Field("titulo") String titulo,
                                           @Field("descripcion") String descripcion,
                                           @Field("marca") String marca,
                                           @Field("modelo") String modelo);

    @GET("taller/lista")
    Call<ResponseTalleres> getTalleres(@Query("X-API-KEY") String key);



}

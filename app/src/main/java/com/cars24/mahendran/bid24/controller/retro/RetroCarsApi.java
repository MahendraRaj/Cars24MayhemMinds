package com.cars24.mahendran.bid24.controller.retro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetroCarsApi {


    @GET("/cars24/cars/")
    Call<RetroGetCarsListResponse> getCarsList(@Query("session-id") String session,
                                                @Query("start-time") String startTime);

    @POST("/cars24/cars/bid/")
    Call<RetroResponse> bidCar(@Query("session-id") String session,
                                      @Body RetroRequest retroRequest);

    @DELETE("/cars24/cars/delete/")
    Call<RetroResponse> deleteCar(@Query("session-id") String session, @Query("car-id") String carId);

    @PUT("/cars24/cars/update/")
    Call<RetroResponse> updateDetails( @Query("session-id") String session,
                                         @Body RetroRequest retroUpdateEpochRequest);

}

package com.example.dogproject.retrofitService;

import com.example.dogproject.DTO.MemberDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {
    @FormUrlEncoded
    @POST("memberJoin")
    Call<ResponseBody> signUpRequest(@Field("objJson") String objJson);

    @FormUrlEncoded
    @POST("memberLogin")
    Call<ResponseBody> signInRequest(@Field("objJson2") String objJson2);
}

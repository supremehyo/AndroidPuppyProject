package com.example.dogproject.retrofitService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRetrofit {
    private  static NetRetrofit outInstance = new NetRetrofit();
    public static NetRetrofit getInstance(){ // 싱글톤으로 만들어줌.
        return outInstance;
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.235:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build(); // 스프링 서버에 연결하고 레트로핏 초기화

    RetrofitService service = retrofit.create(RetrofitService.class);

    public RetrofitService getService(){// 싱글톤으로 만들어줌. 다른데서 이 함수를 호출하면 여기서
        //만든 retfrofit service 를 사용할 수 있게 됌.
        return service;
    }
}

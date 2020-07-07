package com.example.dogproject.model;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.dogproject.DTO.MemberDTO;
import com.example.dogproject.MainActivity2;
import com.example.dogproject.contract.MemberContract;
import com.example.dogproject.retrofitService.NetRetrofit;
import com.example.dogproject.retrofitService.RetrofitService;
import com.google.gson.Gson;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MemberModel {


    int result;
    int result2;

        MemberContract.Presenter presenter;
        RetrofitService retrofitService;
        public MemberModel(MemberContract.Presenter presenter){
            this.presenter = presenter;
        }



        //비동기 구현

        public  int saveData(String id , String password){
            MemberDTO dto = new MemberDTO();
            dto.setUserId(id);
            try{
                MessageDigest md =MessageDigest.getInstance("SHA-256");// 비밀번호 암호화 추가 07-07 by 효석
                md.update(password.getBytes());

                byte byteData[] = md.digest();

                StringBuffer sb = new StringBuffer();
                for(int i=0; i<byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
                }

                String retVal = sb.toString();
                dto.setPassword(retVal);//암호화한 비밀번호를 객체에 넣음

            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            Gson gson = new Gson();
            String objJson = gson.toJson(dto); // DTO 객체를 json 으로 변환
            Log.v("json" , objJson);

            //gson을 담아서 보냄
            final Call<ResponseBody> signup =  NetRetrofit.getInstance().getService().signUpRequest(objJson);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ///  MemberDTO dto2 = new MemberDTO();
                        //  Log.v("res" ,dto2.getUserId()); // 여기에 회원가입할때 넣어준 id가 넘어오는걸 확인했음.
                        if(signup.execute().body().string().equals("1")){//로그인이 제대로 됐을때
                            result =1;
                        }
                        else{// 로그인에 실패했을때
                            result=0;
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return result;
        }


        //아래는 로그인 정보가 맞는지 체크하는 함수
        public int LoginDataCheck(String id, String password){

            MemberDTO dto = new MemberDTO();
            dto.setUserId(id);
            try{
                MessageDigest md =MessageDigest.getInstance("SHA-256");// 비밀번호 암호화
                md.update(password.getBytes());

                byte byteData[] = md.digest();

                StringBuffer sb = new StringBuffer();
                for(int i=0; i<byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
                }

                String retVal = sb.toString();
                dto.setPassword(retVal);//암호화한 비밀번호를 객체에 넣음

            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }

            Gson gson = new Gson();
            String objJson = gson.toJson(dto); // DTO 객체를 json 으로 변환
            Log.v("json" , objJson);
            final Call<ResponseBody> signIn = NetRetrofit.getInstance().getService().signInRequest(objJson); //로그인 요청
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ///  MemberDTO dto2 = new MemberDTO();
                        //  Log.v("res" ,dto2.getUserId()); // 여기에 회원가입할때 넣어준 id가 넘어오는걸 확인했음.
                        if(signIn.execute().body().string().equals("1")){//로그인이 제대로 됐을때

                            result2 =1;
                        }
                        else{// 로그인에 실패했을때
                            result2=0;
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(result2);
            return result2;
        }




}

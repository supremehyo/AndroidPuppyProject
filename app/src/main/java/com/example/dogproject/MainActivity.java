package com.example.dogproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogproject.contract.MemberContract;
import com.example.dogproject.presenter.MemberPresenter;

public class MainActivity extends AppCompatActivity  implements  MemberContract.View{

    MemberContract.Presenter memberpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberpresenter =new MemberPresenter(this);
        goJoin();
        goLogin();

    }

   /* private void preAutoLogin(){
        if(longsharedPreferences.getString("id" ,"")==null && longsharedPreferences.getString("pass","") ==null){
            //로그인 한적이 없을때

        }
        else{ // 로그인 한적이 있을때

        }

    }*/

    private void goJoin(){
        // 회원가입 버튼 클릭시 가입 요청
        findViewById(R.id.memberJoin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() ,JoinActivity.class);
                startActivity(intent);
            }
        });
    }

    private void goLogin(){
        findViewById(R.id.memberLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() ,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    // view 함수들 구현
    @Override
    public void goMainView(int check){//join이 되고나면 메인으로 보내줘야하니까

    }
    @Override
    public  void showResult(String result){

    }

    @Override
    public void goMainView2(int check){

    }

}
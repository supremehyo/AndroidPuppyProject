package com.example.dogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dogproject.contract.MemberContract;
import com.example.dogproject.presenter.MemberPresenter;

public class LoginActivity extends AppCompatActivity implements  MemberContract.View {

    MemberContract.Presenter memberpresenter;
    String id;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memberpresenter =new MemberPresenter(this);

        initListener();
    }

    private void initListener(){
        findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = ((EditText)findViewById(R.id.editInputA)).getText().toString();
                password = ((EditText)findViewById(R.id.editInputB)).getText().toString();
                memberpresenter.memberLogin(id, password); //여기서 id 랑 string 을 반환한다면

                //여기서 프리팹에 저장이 가능함.
            }
        });
    }



    // view 함수들 구현
    @Override
    public void goMainView(int check){//join이 되고나면 메인으로 보내줘야하니까
        // check는 회원가입이 정상적으로 됐을때 1로 넘어온다. 1이 아니면 이동하지 않고 그냥 이함수는 끝난다.
        if(check==1){

            Intent intent = new Intent(getApplicationContext() ,MainActivity2.class);//Join 대신 main2activtiy 로 가야함
            startActivity(intent);
        }
        else if(check ==0){
            Toast.makeText(LoginActivity.this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public  void showResult(String result){

    }

    @Override
    public void goMainView2(int check){

    }
}
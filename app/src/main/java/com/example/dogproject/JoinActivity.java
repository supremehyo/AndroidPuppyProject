package com.example.dogproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.dogproject.contract.MemberContract;
import com.example.dogproject.presenter.MemberPresenter;


public class JoinActivity extends AppCompatActivity implements  MemberContract.View{

    MemberContract.Presenter memberpresenter;
    String inputA;
    String inputB;
    int to;
    int to2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        memberpresenter =new MemberPresenter(this); // 뷰와 프레젠터를 연결하는 부분
        // Interface MemberContract.View을 implement 하였기에 this로
        // MemberPresenter 생성자의 파라미터에 넣을 수 있습니다.

        initListener();


    }

    private void initListener(){
        // 회원가입 버튼 클릭시 가입 요청
        findViewById(R.id.btnResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputA = ((EditText)findViewById(R.id.editInputA)).getText().toString();
                inputB = ((EditText)findViewById(R.id.editInputB)).getText().toString();
                memberpresenter.memberJoin(inputA, inputB);
            }
        });
    }
   /* @Override
    public void showResult(boolean result){
        if(result == true){
            ((TextView)findViewById(R.id.txtResult)).setText("가입성공");
        }
        else{
            ((TextView)findViewById(R.id.txtResult)).setText("가입실패");
        }

    }*/

   @Override
    public void goMainView(int check){//join이 되고나면 메인으로 보내줘야하니까

   }
   @Override
    public  void showResult(String result){

   }
   @Override
    public void goMainView2(int check){
       // check는 회원가입이 정상적으로 됐을때 1로 넘어온다. 1이 아니면 이동하지 않고 그냥 이함수는 끝난다.
       if(check==1){

           Intent intent = new Intent(getApplicationContext() ,MainActivity2.class);//Join 대신 main2activtiy 로 가야함
           startActivity(intent);
       }
       else if(check ==0){
           Toast.makeText(JoinActivity.this, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
       }
   }
}
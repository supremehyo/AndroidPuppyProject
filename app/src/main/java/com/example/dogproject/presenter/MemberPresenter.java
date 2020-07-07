package com.example.dogproject.presenter;


import com.example.dogproject.LoginActivity;
import com.example.dogproject.contract.MemberContract;
import com.example.dogproject.model.MemberModel;

public class MemberPresenter implements MemberContract.Presenter {//여기를 기준으로 직접 연결을 시도하는게 여기 implements가 된다.
    //View와의 통신을 위해서
    // 프레젠터는 모델과 뷰를 둘다 관리하는 중간 단계다. 뷰에서 데이터를 받아와서 처리하고 다시 뷰를 업데이트 하기도하고
    // 모델로 데이터를 보내서 처리하게 하기도 한다.
    MemberContract.View memberView;
    MemberModel memberModel;
    public MemberPresenter(MemberContract.View view){ // View로 받아온다. 물론 이 뷰의 자료형은 컨트렉트에서 먼저 만들어둔것
        //view 연결
        memberView = view; // view 액티비티에서 연결된 View 가 여기에 담긴다. 즉 프레젠터에서도 view와연결이 된 상황

        //model 연결
        memberModel = new MemberModel(this); // 여기는 프레젠터에서 모델로 직접연결을 하는 부분 //this는 implements MemberContract.Presenter\
        //를 해줬기 때문에 프레젠터를 저기로 넘길 수 있는 것.

    }
    @Override
    public void memberJoin(String id, String password) {

        memberView.goMainView2(memberModel.saveData(id, password)); // //2020-07-04 여기에 로그인된 메인화면으로 넘어가는 코드가 있어야함.
    } // 뷰에서 넘어준 데이터를 위임받아서 계산하고 다시 뷰로 업데이트 시켜주고 있음

    @Override
    public void memberLogin(String id , String password){

            memberView.goMainView(memberModel.LoginDataCheck(id, password));
            // 먼저 모델에서 데이터를 체크하고 그 데이터가 true(=1) 이라면 gomainview 에서 1을 받고 1일때 로그인된 화면으로 intent 하는거


    }



}

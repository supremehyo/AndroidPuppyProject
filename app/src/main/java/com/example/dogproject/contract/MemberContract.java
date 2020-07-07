package com.example.dogproject.contract;

public interface MemberContract {


    /**
     *  mvp
     */
    interface View{
        // View 회원가입이 성공했는지 안했는지 알려줌
        void showResult(String result);
        void goMainView(int check);
        void goMainView2(int check);

    }

    interface Presenter {
        // View에서 입력한 정보로 회원가입 요청
        void memberJoin(String id, String password);
        void memberLogin(String id, String password);


    }

}

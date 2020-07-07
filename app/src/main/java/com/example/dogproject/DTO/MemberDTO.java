package com.example.dogproject.DTO;

public class MemberDTO {


        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private String userId;
        private  String password;

        public MemberDTO() {

        }



}

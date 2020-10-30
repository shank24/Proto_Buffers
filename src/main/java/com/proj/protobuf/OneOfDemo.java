package com.proj.protobuf;

import com.proj.models.Credentials;
import com.proj.models.EmailCredentials;
import com.proj.models.PhoneOTP;

public class OneOfDemo {
    public static void main(String[] args) {

        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("nobody@gmail.com")
                .setPassword("admin123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(1231231231)
                .setCode(7677)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();

        login(credentials);
    }

    private  static  void login (Credentials credentials){

        switch (credentials.getModeCase()){
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;

            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }


    }
}

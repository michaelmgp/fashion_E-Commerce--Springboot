package com.example.fashionecommerce_springbootproject.exeptions;

public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String msg){
        super(msg) ;
    }

}

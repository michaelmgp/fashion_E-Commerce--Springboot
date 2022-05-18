package com.example.fashionecommerce_springbootproject.exeptions;

public class CustomException extends IllegalArgumentException{

    public CustomException(String msg){
        super(msg);
    }
}

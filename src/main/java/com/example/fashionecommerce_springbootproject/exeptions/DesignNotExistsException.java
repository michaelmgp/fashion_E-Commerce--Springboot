package com.example.fashionecommerce_springbootproject.exeptions;

public class DesignNotExistsException extends IllegalArgumentException {
    public DesignNotExistsException(String msg) {
        super(msg);
    }
}

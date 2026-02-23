package com.example.jwt_test.exception;

public class MemberConfictException extends RuntimeException{
    public MemberConfictException(){}
    public MemberConfictException(String msg){
        super(msg);
    }
}
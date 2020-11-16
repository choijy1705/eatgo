package kr.co.junyoung.eatgo.application;

public class PasswordWrongException extends RuntimeException{

    PasswordWrongException(){
        super("Password is wrong");
    }
}

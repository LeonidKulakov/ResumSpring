package ru.kulakov.ResumeSpring.exception;

import java.util.Date;

public class AppException{
    private int status;
    private String message;
    private Date date;

    public AppException(int status, String message) {
        this.status = status;
        this.message = message;
        this.date = new Date();
    }
}

package ru.kulakov.ResumeSpring.exception;

public class BlogNotFoundException extends Exception{
    public BlogNotFoundException(String message) {
        super(message);
    }
}

package com.example.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterReturning("execution(* com.example.book.service.BookService.borrowBook(..))")
    public void logBorrow() {
        System.out.println("A book has been borrowed.");
    }

    @AfterReturning("execution(* com.example.book.service.BookService.returnBook(..))")
    public void logReturn() {
        System.out.println("A book has been returned.");
    }
}

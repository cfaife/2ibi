package com.twoibi.exception;

import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicatedCountryNameException.class)
    @ResponseBody
    ErrorInfo hadleDuplicationName(HttpServletRequest request, Exception ex){
        return  new ErrorInfo(request.getRequestURL().toString(),ex);
    }
}

package com.twoibi.exception;

public class DuplicatedCountryNameException extends  RuntimeException{

    public DuplicatedCountryNameException(String duplicatedName){
        super("There is a country created with this name:"+ duplicatedName);
    }

}

package com.example.teachers.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
    NOT_EXIST("OBJECT NOT EXIST INTO THE DATABASE"),
    EXIST("OBJECT ALREADY EXIST INTO THE DATABASE"),
    EMPTY("INTERNAL SERVER DATABASE IS EMPTY OR CORRUPTED"),
    FAILED("FAILED TO DELETE DUE TO SERVERS STABILITY"),

    NOT_FOUND("NOT FOUND COURSE ENTITY OR COURSE SERVICE IS DOWN"),

    SERVICE("FROM COURSE SERVICE");


    private final String EXCEPTION_MESSAGE;


}
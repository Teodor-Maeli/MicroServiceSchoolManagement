package com.example.courses.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
    NOT_EXIST("OBJECT NOT EXIST INTO THE DATABASE"),
    EXIST("OBJECT ALREADY EXIST INTO THE DATABASE"),
    EMPTY("INTERNAL SERVER DATABASE IS EMPTY OR CORRUPTED"),
    TEACHER_NON_ASSIGNED("TEACHER HAS NO COURSES ASSIGNED YET"),
    FEIGN_404("CANNOT CONNECT TO DEPENDABLE SERVICE OR TEACHER DOESN'T EXIST AT ALL");



    private final String ExceptionMessage;

}
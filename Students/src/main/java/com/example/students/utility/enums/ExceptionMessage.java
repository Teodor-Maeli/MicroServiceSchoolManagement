package com.example.students.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {
    NOT_EXIST ("OBJECT NOT EXIST INTO THE DATABASE OR CANNOT ACCESS THE DATABASE "),
    EXIST ("OBJECT ALREADY EXIST INTO THE DATABASE"),
    EMPTY ("INTERNAL SERVER DATABASE IS EMPTY OR CORRUPTED"),
    DELETED("DELETED SUCCESSFULLY - DID NOT FOUND IN ENROLLMENTS OR SERVICE IS DOWN!");



    private final String ExceptionMessage;

}
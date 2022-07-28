package com.example.courses.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    DELETED("ENTITY WAS SUCCESSFULLY DELETED FROM ALL DATABASES");


    private final String Message;

}

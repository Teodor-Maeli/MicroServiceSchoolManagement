package com.example.enrollments.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionMessage {

    INVALID_GRADE ("GRADES TO BE BETWEEN 2 AND 6."),
    NON_ENROLL ("STUDENT/COURSE NON-EXISTENT OR NOT ASSIGNED"),
    NO_COURSE_ENROLLS("NO ENROLLS WITH SUCH COURSE NAME"),
    FEIGN_404("CANNOT CONNECT TO DEPENDABLE SERVICE OR STUDENT/COURSE NOT EXIST AT ALL."),
    EXIST("STUDENT ALREADY ENROLLED INTO THE SAME COURSE"),
    DELETED("DELETED SUCCESSFULLY"),
    DEPENDABLE_SERVICE("SERVICE/DATA IS CORRUPTED - NOT FOUND DATA FOR DESERIALIZATION"),
    SERVICES("ERROR - COURSE SERVICE");

    private final String ExceptionMessage;

}
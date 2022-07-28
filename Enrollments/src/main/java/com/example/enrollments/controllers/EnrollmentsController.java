package com.example.enrollments.controllers;


import com.example.enrollments.dto.Response;
import com.example.enrollments.service.ServiceImpl.EnrollmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping(value = "/enrollments")
@AllArgsConstructor
public class EnrollmentsController {

    private final EnrollmentServiceImpl SERVICE;


    @GetMapping(value = "/all")
    List<Response> getAll() {
        return SERVICE.getAll();
    }

    @GetMapping(value = "/{id}")
    List<Response> getByStudentId(@PathVariable Long id) {
            return SERVICE.getStudentEnrollments(id);
    }


    @PostMapping(value = "enroll/{cId}/{sId}")
    Response assignStudentToCourse(@PathVariable Long cId, @PathVariable Long sId) {
            return SERVICE.assignStudentToCourse(cId, sId);
    }

    @PostMapping(value = "/grade/{cId}/{sId}/{grade}")
    Response gradeToStudentInCourse(@PathVariable Long cId, @PathVariable Long sId, @PathVariable double grade) {
            return SERVICE.addGrade(cId, sId, grade);
    }


    @GetMapping(value = "/average/student/{id}")
    HashMap<String, Double> studentTotalAverage(@PathVariable Long id) {
            return SERVICE.studentTotalAverage(id);
    }


    @GetMapping(value = "/average/courses/{id}")
    HashMap<String, Double> coursesTotalAverage(@PathVariable Long id){
            return SERVICE.courseTotalAverage(id);
    }

    @GetMapping(value = "/average/all")
    TreeMap<String, TreeMap<String,Double>> getAllAvg(){
        return SERVICE.showAllGroupedByCourse();
    }


    @DeleteMapping(value = "/{id}")
    String deleteCourse(@PathVariable Long id){
            return SERVICE.deleteEnrolment(id);
    }


}

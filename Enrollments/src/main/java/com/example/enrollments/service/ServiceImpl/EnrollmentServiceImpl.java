package com.example.enrollments.service.ServiceImpl;

import com.example.enrollments.client.CourseFeignClient;
import com.example.enrollments.client.StudentFeignClient;
import com.example.enrollments.dto.Response;
import com.example.enrollments.entity.Enrollment;
import com.example.enrollments.mapper.MapperImpl.EnrollmentMapperImpl;
import com.example.enrollments.repository.EnrollmentRepository;
import com.example.enrollments.service.EnrollmentService;
import com.example.enrollments.utility.Exceptions.InvalidGradeException;
import com.example.enrollments.utility.Exceptions.ObjectAlreadyEnrolledException;
import com.example.enrollments.utility.Exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.example.enrollments.utility.enums.ExceptionMessage.*;


@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService<Response> {


    EnrollmentRepository repository;
    EnrollmentMapperImpl mapper;
    StudentFeignClient studentClient;
    CourseFeignClient courseClient;

    @Override
    public List<Response> getStudentEnrollments(Long id) throws ObjectNotFoundException {
        if (repository.existsByStudentId(id)) {
            return mapper.allEntityToResponse(repository.findAllByStudentId(id).get());
        } else if (repository.existsByCourseId(id)) {
            return mapper.allEntityToResponse(repository.findAllByCourseId(id).get());
        } else throw new ObjectNotFoundException(NON_ENROLL.getExceptionMessage());
    }


    @Override
    public Response assignStudentToCourse(Long cId, Long sId) throws ObjectNotFoundException, ObjectAlreadyEnrolledException {
        try {
            courseClient.getCourse(cId);
            String name = studentClient.getStudentName(sId);
            if (!repository.existsByCourseIdAndStudentId(cId, sId)) {
                return mapper.entityToResponse(repository.save(Enrollment.builder()
                        .courseId(cId)
                        .studentName(name)
                        .studentId(sId)
                        .build()));
            } else throw new ObjectAlreadyEnrolledException(EXIST.getExceptionMessage());
        } catch (FeignException e) {
            throw new ObjectNotFoundException(FEIGN_404.getExceptionMessage());
        }
    }


    @Override
    public List<Response> getAll() {
        return mapper.allEntityToResponse(repository.findAll());
    }

    @Override
    public Response addGrade(Long cId, Long sId, double grade) throws ObjectNotFoundException, InvalidGradeException {
        Enrollment enrollment = repository.findByCourseIdAndStudentId(cId, sId).orElseThrow(
                () -> new ObjectNotFoundException(NON_ENROLL.getExceptionMessage()));
        if (grade >= 2 && grade <= 6) {
            enrollment.getGrades().add(grade);
            return mapper.entityToResponse(repository.save(enrollment));
        } else throw new InvalidGradeException(INVALID_GRADE.getExceptionMessage());
    }

    @Override
    public HashMap<String, Double> courseTotalAverage(Long cId) throws ObjectNotFoundException {
        HashMap<String, Double> map = new HashMap<>();

        List<Enrollment> enrollment = repository.findAllByCourseId(cId).orElseThrow(
                () -> new ObjectNotFoundException(NO_COURSE_ENROLLS.getExceptionMessage()));

        Double average = enrollment
                .stream()
                .filter(e -> !e.getGrades().isEmpty())
                .mapToDouble(e -> e.getGrades()
                        .stream()
                        .mapToDouble(grade -> grade)
                        .average()
                        .orElseThrow())
                .average()
                .orElseThrow();

        map.put(courseClient.getName(cId), average);
        return map;
    }

    @Override
    public HashMap<String, Double> studentTotalAverage(Long sId) throws ObjectNotFoundException {
        HashMap<String, Double> map = new HashMap<>();

        List<Enrollment> enrollment = repository.findAllByStudentId(sId).orElseThrow(
                () -> new ObjectNotFoundException(NON_ENROLL.getExceptionMessage()));

        Double average = enrollment.stream()
                .filter(e -> !e.getGrades().isEmpty())
                .mapToDouble(e -> e.getGrades()
                        .stream()
                        .mapToDouble(grade -> grade)
                        .average()
                        .orElseThrow())
                .average().
                orElseThrow();

        map.put(studentClient.getStudentName(sId), average);
        return map;

    }


    @Override
    public TreeMap<String, TreeMap<String, Double>> showAllGroupedByCourse() {
        List<Enrollment> enrollments = repository.findAll().stream().filter(e -> !e.getGrades().isEmpty()).collect(Collectors.toList());

        TreeMap<String, TreeMap<String, Double>> map = new TreeMap<>();

        while (!enrollments.isEmpty()) {
            Double average = enrollments.get(0).getGrades()
                    .stream()
                    .mapToDouble(g -> g)
                    .average()
                    .orElse(0.0);

            String courseName = courseClient.getName(enrollments.get(0).getCourseId());
            String studentName = studentClient.getStudentName(enrollments.get(0).getStudentId());
            map.putIfAbsent(courseName, new TreeMap<>());
            map.get(courseName).put(studentName, average);

            enrollments.remove(0);
        }
        return map;

    }


    @Transactional
    public String deleteEnrolment(Long id) throws ObjectNotFoundException {
        if (repository.existsByCourseId(id)) {
            repository.deleteAllByCourseId(id);
            return DELETED.getExceptionMessage();
        } else if (repository.existsByStudentId(id)) {
            repository.deleteAllByStudentId(id);
            return DELETED.getExceptionMessage();
        } else throw new ObjectNotFoundException(NON_ENROLL.getExceptionMessage());
    }
}

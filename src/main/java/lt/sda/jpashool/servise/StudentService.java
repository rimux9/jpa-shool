package lt.sda.jpashool.servise;


import lt.sda.jpashool.model.Student;
import lt.sda.jpashool.model.StudentDTO;
import lt.sda.jpashool.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student registerNewStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSurname(studentDTO.getSurname());
        student.setAge(studentDTO.getAge());
        student.setCity(studentDTO.getCity());
        student.setGroupName(studentDTO.getGroupName());
        studentRepo.save(student);
        return student;
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student findByNameAndSurname(String name, String surname) {
        return studentRepo.findStudentByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
    }

    public List<Student> findByLanguage(String programmingLanguage) {
        return studentRepo.findAllByGroupNameStartsWithIgnoreCase(programmingLanguage);
    }

    public List<Student> findByLanguageAndRemote(String programmingLanguage) {
        return studentRepo.findAllByGroupNameStartsWithIgnoreCase(programmingLanguage + "remote");
    }

    public Map<String, List<Student>> findGroupedByCity() {
//        List<Student> studentList = studentRepository.findAll();
//        Map<String, List<Student>> stringListMap = new HashMap<>();
//        for (Student student : studentList) {
//            String city = student.getCity();
//            List<Student> getCurrentStudentsByCity = stringListMap.getOrDefault(city, new ArrayList<>());
//            getCurrentStudentsByCity.add(student);
//            stringListMap.put(city, getCurrentStudentsByCity);
//        }
//        return stringListMap;
        return studentRepo.findAll().stream()
                .collect(Collectors.groupingBy(Student::getCity));

    }
}
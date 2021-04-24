package lt.sda.jpashool.controller;


import lt.sda.jpashool.model.Student;
import lt.sda.jpashool.model.StudentDTO;
import lt.sda.jpashool.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody StudentDTO studentDTO){
        return studentService.registerNewStudent(studentDTO);
    }
    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }


    @GetMapping(value = "/find")
    public Student findByNameAndSurname(@RequestParam String name, @RequestParam String surname){
        return studentService.findByNameAndSurname(name, surname);
    }

    @GetMapping(value = "/findByLanguage")
    public List<Student> findByLanguage(@RequestParam String programmingLanguage) {
        return studentService.findByLanguage(programmingLanguage);
    }
    @GetMapping(value = "/findByRemote")
    public List<Student> findByRemote(@RequestParam String programmingLanguage) {
        return studentService.findByLanguageAndRemote(programmingLanguage);
    }
    @GetMapping(value = "/findGrouped")
    public Map<String, List<Student>> findStudentsGroupedByCity() {
        return studentService.findGroupedByCity();
    }

}

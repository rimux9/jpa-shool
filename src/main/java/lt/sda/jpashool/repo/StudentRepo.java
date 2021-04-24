package lt.sda.jpashool.repo;


import lt.sda.jpashool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    public Student findStudentByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);

    List<Student> findAllByGroupNameStartsWithIgnoreCase(String programmingLanguage);
    List<Student> findAllByCity(String city);
}

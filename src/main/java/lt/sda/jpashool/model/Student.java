package lt.sda.jpashool.model;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
/**
 * Užduotis:
 * 1. Užregistruoti studentą per endpoint (gražinti visą info su nauju jam priskirtu ID);
 * 2. Gražinti visus studentus;
 * 3. Gražinti studentą pagal vardą ir pavardę;

* 4. Gražinti visus studentus pagal programvimo kalbą:
 * 5. Gražinti visus studentus pagal programavimo kalbą ir kurie yra Remote
 * 6. Gražinti visus studentus sugrupuotus pagal miestą. vilnius: [ student1,student2], kaunas: [],..
 */

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    // eg. JavaRemote1/JavaRemote2/PythonRemote1/PythonNotRemote1/JavaNotRemote1
    private String groupName;
}



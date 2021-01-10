package bdbt.jednostka_akademicka;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
import bdbt.jednostka_akademicka.jezyk.JezykDAO;
import bdbt.jednostka_akademicka.student.Student;
import bdbt.jednostka_akademicka.student.StudentDAO;
import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import bdbt.jednostka_akademicka.uczelnia.UczelniaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentTest {

    private StudentDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ORA3.ELKA.PW.EDU.PL:1521:ORA3INF");
        dataSource.setUsername("MRUTKOW4");
        dataSource.setPassword("mrutkow4");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new StudentDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){
        List<Student> listaStudentow = dao.list();
        assertTrue(!listaStudentow.isEmpty());
    }



    @Test
    void testSave(){
        Student student = new Student("Adam","Nie","00211204614","123","M", "01-11-2000","tak","111118111","twoj","taaa",16,1);
        dao.save(student);
    }

    @Test
    void update()
    {
        Student student = new Student();
        student.setImie("bbb");
        student.setNazwisko("taaak");
        student.setPesel("00211794614");
        student.setNrIndeksu("1263");
        student.setPlec("K");
        student.setDataUrodzenia("01-11-2000");
        student.setEmail("000000");
        student.setNrTelefonu("120312");
        student.setStopienStudiow("erwerw");
        student.setKierunekStudiow("efdewfwf");
        student.setNrUczelni(18);
        student.setNrAdresu(3);
        dao.update(student);





    }






    @Test
    void testGet(){
        dao.get(1);
    }


    @Test
    void testDelete(){
        dao.delete(1);
    }
}

package bdbt.jednostka_akademicka;

import bdbt.jednostka_akademicka.dziekanat.Dziekanat;
import bdbt.jednostka_akademicka.dziekanat.DziekanatDAO;
import bdbt.jednostka_akademicka.student.Student;
import bdbt.jednostka_akademicka.student.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DziekanatTest {
    private DziekanatDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ORA3.ELKA.PW.EDU.PL:1521:ORA3INF");
        dataSource.setUsername("MRUTKOW4");
        dataSource.setPassword("mrutkow4");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new DziekanatDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){
        List<Dziekanat> listaDziekanatow = dao.list();
        assertTrue(listaDziekanatow.isEmpty());
    }



    @Test
    void testSave(){
        Dziekanat dziekanat = new Dziekanat(1,302,"693289444","Sekcja od spraw ciebie",3);
        dao.save(dziekanat);
    }

    @Test
    void update()
    {
        Student student = new Student();
        student.setImie("aaaa");
        student.setNazwisko("taaak");
        student.setPesel("00211704614");
        student.setNrIndeksu("123");
        student.setPlec("K");
        student.setDataUrodzenia("01-jun-2000");
        student.setEmail("000000");
        student.setNrTelefonu("120312");
        student.setStopienStudiow("erwerw");
        student.setKierunekStudiow("efdewfwf");
        student.setNrUczelni(18);
        student.setNrAdresu(3);
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

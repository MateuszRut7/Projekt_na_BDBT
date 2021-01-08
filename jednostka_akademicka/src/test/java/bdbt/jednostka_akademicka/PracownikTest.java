package bdbt.jednostka_akademicka;

import bdbt.jednostka_akademicka.pracownik.Pracownik;
import bdbt.jednostka_akademicka.pracownik.PracownikDAO;
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
public class PracownikTest {
    private PracownikDAO dao;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ORA3.ELKA.PW.EDU.PL:1521:ORA3INF");
        dataSource.setUsername("MRUTKOW4");
        dataSource.setPassword("mrutkow4");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownikDAO(new JdbcTemplate(dataSource));

    }

    @Test
    void testList(){
        List<Pracownik> listaPracownikow = dao.list();
        assertTrue(listaPracownikow.isEmpty());
    }



    @Test
    void testSave(){
        Pracownik pracownik = new Pracownik("aaa","aaaa","01-jun-1990","K","00211204666","01-jun-2000","01-jun-2010","693289443","aaa",18,3,3,3);
        dao.save(pracownik);
    }






    @Test
    void testGet(){
        dao.get(6);
    }


    @Test
    void testDelete(){
        dao.delete(1);
    }
}

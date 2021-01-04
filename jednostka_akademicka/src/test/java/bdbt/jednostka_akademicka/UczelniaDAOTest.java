package bdbt.jednostka_akademicka;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
import bdbt.jednostka_akademicka.jezyk.JezykDAO;
import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import bdbt.jednostka_akademicka.uczelnia.UczelniaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UczelniaDAOTest {

    private UczelniaDAO dao1;
    private JezykDAO dao2;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ORA3.ELKA.PW.EDU.PL:1521:ORA3INF");
        dataSource.setUsername("MRUTKOW4");
        dataSource.setPassword("mrutkow4");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao1 = new UczelniaDAO(new JdbcTemplate(dataSource));
        dao2 = new JezykDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void testList(){
        List<Uczelnia> listaUczelni = dao1.list();
        assertTrue(listaUczelni.isEmpty());
    }

    @Test
    void testList2(){
        List<Jezyk> listajezykow = dao2.list();
        assertTrue(!listajezykow.isEmpty());
    }

    @Test
    void testSave(){
        Uczelnia uczelnia = new Uczelnia(0,"Nazwa","Politechnika","Prywatna",0);
        dao1.save(uczelnia);
    }

    /* dziala
    @Test
    void testSave2(){
        Jezyk jezyk = new Jezyk(0,"00","Jezyk");
        dao2.save(jezyk);
    }

    */


    @Test
    void testGet(){
        fail("Not yet");
    }

    @Test
    void testUpdate(){
        fail("Not yet");
    }

    @Test
    void testDelete(){
        fail("Not yet");
    }
}

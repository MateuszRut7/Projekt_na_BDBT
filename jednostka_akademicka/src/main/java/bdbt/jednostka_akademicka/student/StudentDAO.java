package bdbt.jednostka_akademicka.student;

import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> list() {
        String sql = "SELECT * FROM STUDENCI";
        List<Student> ListaStudentow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Student.class));
        return ListaStudentow;
    }

    public void save(Student student){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("studenci").usingColumns("Imie","Nazwisko","PESEL","Nr_indeksu","Plec","Data_urodzenia","Email","Nr_telefonu","Stopien_studiow","Kierunek_studiow","Nr_uczelni","Nr_adresu","nr_uzytkownika");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(student);
        insertActor.execute(param);
    }

    public Student get(int nrStudenta) {
        String sql = "SELECT * FROM STUDENCI WHERE NR_STUDENTA = ?";
        Object[] args = {nrStudenta};
        Student student = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Student.class));
        return student;
    }



    public void update(Student student) {
        String sql = "UPDATE STUDENCI SET IMIE=:imie,NAZWISKO=:nazwisko,PESEL=:pesel,NR_INDEKSU=:nrIndeksu,PLEC=:plec,DATA_URODZENIA=:dataUrodzenia,EMAIL=:email,NR_TELEFONU=:nrTelefonu,STOPIEN_STUDIOW=:stopienStudiow,KIERUNEK_STUDIOW=:kierunekStudiow,NR_UCZELNI=:nrUczelni, NR_ADRESU=:nrAdresu,NR_UZYTKOWNIKA=:nrUzytkownika WHERE NR_STUDENTA=:nrStudenta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(student);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM STUDENCI WHERE  NR_STUDENTA = ?";
        jdbcTemplate.update(sql, id);
    }

}

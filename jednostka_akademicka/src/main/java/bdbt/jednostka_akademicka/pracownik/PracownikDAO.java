package bdbt.jednostka_akademicka.pracownik;


import bdbt.jednostka_akademicka.student.Student;
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
public class PracownikDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list() {
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownik> ListaPracownikow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return ListaPracownikow;
    }

    public void save(Pracownik pracownik){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("Imie","Nazwisko","Data_urodzenia","Plec","PESEL","Data_zatrudnienia","Data_zwolnienia","Nr_telefonu","Email","Nr_uczelni","Nr_wydzialu","Nr_adresu","Nr_stanowiska","nr_uzytkownika");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    public Pracownik get(int nrPracownika) {
        String sql = "SELECT * FROM PRACOWNICY WHERE NR_PRACOWNIKA = ?";
        Object[] args = {nrPracownika};
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }



    public void update(Pracownik pracownik) {
        String sql = "UPDATE PRACOWNICY SET IMIE=:imie,NAZWISKO=:nazwisko,DATA_URODZENIA=:dataUrodzenia,PLEC=:plec,PESEL=:pesel,DATA_ZATRUDNIENIA=:dataZatrudnienia,DATA_ZWOLNIENIA=:dataZwolnienia,NR_TELEFONU=:nrTelefonu,EMAIL=:email,NR_UCZELNI=:nrUczelni,NR_WYDZIALU=:nrWydzialu, NR_ADRESU=:nrAdresu,NR_STANOWISKA=:nrStanowiska, NR_UZYTKOWNIKA=:nrUzytkownika WHERE NR_PRACOWNIKA=:nrPracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM PRACOWNICY WHERE  NR_PRACOWNIKA = ?";
        jdbcTemplate.update(sql, id);
    }
}

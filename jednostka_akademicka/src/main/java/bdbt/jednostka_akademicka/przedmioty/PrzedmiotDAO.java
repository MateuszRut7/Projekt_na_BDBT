package bdbt.jednostka_akademicka.przedmioty;

import bdbt.jednostka_akademicka.dziekanat.Dziekanat;
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
public class PrzedmiotDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PrzedmiotDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Przedmiot> list() {

        String sql = "SELECT * FROM PRZEDMIOTY";
        List<Przedmiot> ListaPrzedmiotow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Przedmiot.class));

        return ListaPrzedmiotow;
    }

    public void save(Przedmiot przedmiot){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("przedmioty").usingColumns("Nazwa","Liczba_godzin","ECTS","Nr_pracownika","Nr_instytutu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(przedmiot);
        insertActor.execute(param);
    }


    public Przedmiot get(int nrPrzedmiotu) {
        String sql = "SELECT * FROM PRZEDMIOTY WHERE NR_PRZEDMIOTU = ?";
        Object[] args = {nrPrzedmiotu};
        Przedmiot przedmiot = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Przedmiot.class));
        return przedmiot;
    }



    public void update(Przedmiot przedmiot) {
        String sql = "UPDATE PRZEDMIOTY SET NAZWA=:nazwa, LICZBA_GODZIN=:liczbaGodzin , ECTS=:ECTS, NR_PRACOWNIKA=:nrPracownika,NR_INSTYTUTU=:nrInstytutu WHERE NR_PRZEDMIOTU=:nrPrzedmiotu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(przedmiot);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM PRZEDMIOTY WHERE  NR_PRZEDMIOTU = ?";
        jdbcTemplate.update(sql, id);
    }

}
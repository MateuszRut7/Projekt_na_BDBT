package bdbt.jednostka_akademicka.wynagrodzenie;

import bdbt.jednostka_akademicka.wydzial.Wydzial;
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
public class WynagrodzenieDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WynagrodzenieDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wynagrodzenie> list() {
        String sql = "SELECT * FROM WYNAGRODZENIA ";
        List<Wynagrodzenie> listaWynagrodzen = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));
        return listaWynagrodzen;
    }

    public void save(Wynagrodzenie wynagrodzenie){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("wynagrodzenia").usingColumns("Data_wynagrodzenia","Kwota_pod","Kwota_dod","Nr_pracownika");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
        insertActor.execute(param);
    }

    public Wynagrodzenie get(int nrWynagrodzenia) {
        String sql = "SELECT * FROM WYNAGRODZENIA WHERE NR_WYNAGRODZENIA = ?";
        Object[] args = {nrWynagrodzenia};
        Wynagrodzenie wynagrodzenie = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Wynagrodzenie.class));
        return wynagrodzenie;
    }



    public void update(Wynagrodzenie wynagrodzenie) {
        String sql = "UPDATE WYNAGRODZENIA SET DATA_WYNAGRODZENIA=:dataWynagrodzenia, KWOTA_POD=:kwotaPod, KWOTA_DOD=:kwotaDod, NR_PRACOWNIKA=:nrPracownika WHERE NR_WYNAGRODZENIA=:nrWynagrodzenia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM WYNAGRODZENIA WHERE  NR_WYNAGRODZENIA = ?";
        jdbcTemplate.update(sql, id);
    }

}
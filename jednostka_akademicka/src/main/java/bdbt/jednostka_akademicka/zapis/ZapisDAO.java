package bdbt.jednostka_akademicka.zapis;


import bdbt.jednostka_akademicka.wynagrodzenie.Wynagrodzenie;
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
public class ZapisDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZapisDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zapis> list() {
        String sql = "SELECT * FROM ZAPISY ";
        List<Zapis> listaZapisow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Zapis.class));
        return listaZapisow;
    }

    public void save(Zapis zapis){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("zapisy").usingColumns("Nr_studenta","Nr_przedmiotu","Ocena_koncowa");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zapis);
        insertActor.execute(param);
    }

    public Zapis getByPrzedmiot(int nrPrzedmiotu) {
        String sql = "SELECT * FROM ZAPISY WHERE NR_WYNAGRODZENIA = ?";
        Object[] args = {nrPrzedmiotu};
        Zapis zapis = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Zapis.class));
        return zapis;
    }



    public void update(Zapis zapis) {
        String sql = "UPDATE ZAPISY SET NR_STUDENTA=:nrStudenta, OCENA_KONCOWA=:ocenaKoncowa  WHERE NR_WYNAGRODZENIA=:nrWynagrodzenia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zapis);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ZAPISY WHERE  NR_STUDENTA = ?";
        jdbcTemplate.update(sql, id);
    }

}
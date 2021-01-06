package bdbt.jednostka_akademicka.wydzial;


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
public class WydzialDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WydzialDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wydzial> list() {
        String sql = "SELECT * FROM WYDZIALY ";
        List<Wydzial> listaWydzialow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Wydzial.class));
        return listaWydzialow;
    }

    public void save(Wydzial wydzial){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("wydzialy").usingColumns("Nazwa","Nr_uczelni","Nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wydzial);
        insertActor.execute(param);
    }

    public Wydzial get(int nrWydzialu) {
        String sql = "SELECT * FROM WYDZIALY WHERE NR_WYDZIALU = ?";
        Object[] args = {nrWydzialu};
        Wydzial wdzial = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Wydzial.class));
        return wdzial;
    }



    public void update(Wydzial wydzial) {
        String sql = "UPDATE WYDZIALY SET NAZWA=:nazwa, NR_UCZELNI=:nrUczelni, NR_ADRESU=:nrAdresu WHERE NR_WYDZIALU=:nrWydzialu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wydzial);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM WYDZIALY WHERE  NR_WYDZIALU = ?";
        jdbcTemplate.update(sql, id);
    }

}
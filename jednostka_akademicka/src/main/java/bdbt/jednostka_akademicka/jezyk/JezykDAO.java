package bdbt.jednostka_akademicka.jezyk;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
@Transactional
public class JezykDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JezykDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Jezyk> list() {

        String sql = "SELECT * FROM JEZYKI";
        List<Jezyk> ListaJezykow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Jezyk.class));

        return ListaJezykow;
    }

    public void save(Jezyk jezyk){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("jezyki").usingColumns("Kod_jezyka","Nazwa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(jezyk);
        insertActor.execute(param);
    }


    public Jezyk get(int nrJezyka) {
        String sql = "SELECT * FROM JEZYKI WHERE NR_JEZYKA = ?";
        Object[] args = {nrJezyka};
        Jezyk jezyk = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Jezyk.class));
        return jezyk;
    }



    public void update(Jezyk jezyk) {
        String sql = "UPDATE JEZYKI SET KOD_JEZYKA=:kodJezyka, NAZWA=:nazwa WHERE NR_JEZYKA=:nrJezyka";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(jezyk);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM JEZYKI WHERE  NR_JEZYKA = ?";
        jdbcTemplate.update(sql, id);
    }

}
package bdbt.jednostka_akademicka.jezyk;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        insertActor.withTableName("JEZYKI").usingColumns("Kod_jezyka","Nazwa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(jezyk);
        insertActor.execute(param);
    }

    public Jezyk get(int id){
        return null;
    }

    public void update (Uczelnia uczelnie){

    }

    public void delete (int id){

    }

}
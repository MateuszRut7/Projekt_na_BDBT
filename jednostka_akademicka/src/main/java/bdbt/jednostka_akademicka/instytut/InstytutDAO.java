package bdbt.jednostka_akademicka.instytut;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
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
public class InstytutDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public InstytutDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Instytut> list() {

        String sql = "SELECT * FROM INSTYTUTY";
        List<Instytut> ListaInstytuty = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Instytut.class));

        return ListaInstytuty;
    }

    public void save(Instytut instytut){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("instytuty").usingColumns("Nazwa","Nr_wydzialu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(instytut);
        insertActor.execute(param);
    }


    public Instytut get(int nrInstytutu) {
        String sql = "SELECT * FROM INSTYTUTY WHERE NR_INSTYTUTU = ?";
        Object[] args = {nrInstytutu};
        Instytut instytut = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Instytut.class));
        return instytut;
    }



    public void update(Instytut instytut) {
        String sql = "UPDATE INSTYTUTY SET NAZWA=:nazwa, NR_WYDZIALU=:nrWydzialu WHERE NR_INSTYTUTU=:nrInstytutu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(instytut);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM INSTYTUTY WHERE  NR_INSTYTUTU = ?";
        jdbcTemplate.update(sql, id);
    }
}

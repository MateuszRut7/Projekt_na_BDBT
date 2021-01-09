package bdbt.jednostka_akademicka.dziekanat;


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
public class DziekanatDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DziekanatDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Dziekanat> list() {

        String sql = "SELECT * FROM BIURA_DZIEKANATU";
        List<Dziekanat> ListaDziekanatow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Dziekanat.class));

        return ListaDziekanatow;
    }

    public void save(Dziekanat dziekanat){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("biura_dziekanatu").usingColumns("Pokoj","Nr_telefonu","Sekcja","Nr_wydzialu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dziekanat);
        insertActor.execute(param);
    }


    public Dziekanat get(int nrDziekanatu) {
        String sql = "SELECT * FROM BIURA_DZIEKANATU WHERE NR_BIURA_DZIEKANATU = ?";
        Object[] args = {nrDziekanatu};
        Dziekanat dziekanat = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Dziekanat.class));
        return dziekanat;
    }



    public void update(Dziekanat dziekanat) {
        String sql = "UPDATE BIURA_DZIEKANATU SET POKOJ=:pokoj, NR_TELEFONU=:nrTelefonu , SEKCJA =:sekcja, NR_WYDZIALU=:nrWydzialu WHERE NR_BIURA_DZIEKANATU=:nrBiuraDziekanatu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dziekanat);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM BIURA_DZIEKANATU WHERE  NR_BIURA_DZIEKANATU = ?";
        jdbcTemplate.update(sql, id);
    }

}
package bdbt.jednostka_akademicka.naukowi;


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
public class NaukowyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public NaukowyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Naukowy> list() {

        String sql = "SELECT * FROM NAUKOWO_DYDAKTYCZNI";
        List<Naukowy> ListaNaukowych = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Naukowy.class));

        return ListaNaukowych;
    }

    public void save(Naukowy naukowy){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("naukowo_dydaktyczni").usingColumns("Nr_pracownika","Tytul_naukowy","OKNO");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(naukowy);
        insertActor.execute(param);
    }


    public Naukowy get(int nrNaukowego) {
        String sql = "SELECT * FROM NAUKOWO_DYDAKTYCZNI WHERE NR_PRACOWNIKA = ?";
        Object[] args = {nrNaukowego};
        Naukowy naukowy = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Naukowy.class));
        return naukowy;
    }



    public void update(Naukowy dziekanat) {
        String sql = "UPDATE NAUKOWO_DYDAKTYCZNI SET TYTUL_NAUKOWY=:tytulNaukowy, OKNO=:OKNO WHERE NR_PRACOWNIKA =:nrPracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dziekanat);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM NAUKOWO_DYDAKTYCZNI WHERE NR_PRACOWNIKA = ?";
        jdbcTemplate.update(sql, id);
    }

}
package bdbt.jednostka_akademicka.poczta;


import bdbt.jednostka_akademicka.zapis.Zapis;
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
public class PocztaDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczta> list() {
        String sql = "SELECT * FROM POCZTY ";
        List<Poczta> listaPoczt = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return listaPoczt;
    }

    public void save(Poczta poczta){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("poczty").usingColumns("Nr_poczty","Kod_poczty","Poczta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        insertActor.execute(param);
    }

    public Poczta get(int nrPoczty) {
        String sql = "SELECT * FROM POCZTY WHERE NR_POCZTY = ?";
        Object[] args = {nrPoczty};
        Poczta poczta = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }



    public void update(Poczta poczta) {
        String sql = "UPDATE POCZTY SET KOD_POCZTY=:kodPoczty, POCZTA=:miasto  WHERE NR_POCZTY=:nrPoczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM POCZTY WHERE  NR_POCZTY = ?";
        jdbcTemplate.update(sql, id);
    }

}
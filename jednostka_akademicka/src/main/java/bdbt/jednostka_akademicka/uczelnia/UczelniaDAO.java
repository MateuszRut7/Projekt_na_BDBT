package bdbt.jednostka_akademicka.uczelnia;


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
public class UczelniaDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UczelniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Uczelnia> list() {
        String sql = "SELECT * FROM UCZELNIE";
        List<Uczelnia> ListaUczelni = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Uczelnia.class));
        return ListaUczelni;
    }

    public void save(Uczelnia uczelnia){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("uczelnie").usingColumns("Nazwa","Typ_uczelni","Rodzaj","Nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczelnia);
        insertActor.execute(param);
    }

    public Uczelnia get(int nrUczelni) {
        String sql = "SELECT * FROM UCZELNIE WHERE NR_UCZELNI = ?";
        Object[] args = {nrUczelni};
        Uczelnia uczelnia = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Uczelnia.class));
        return uczelnia;
    }



    public void update(Uczelnia uczelnia) {
        String sql = "UPDATE UCZELNIE SET NAZWA=:nazwa, TYP_UCZELNI=:typUczelni, RODZAJ=:rodzaj, NR_ADRESU=:nrAdresu WHERE NR_UCZELNI=:nrUczelni";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczelnia);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM UCZELNIE WHERE  NR_UCZELNI = ?";
        jdbcTemplate.update(sql, id);
    }

}


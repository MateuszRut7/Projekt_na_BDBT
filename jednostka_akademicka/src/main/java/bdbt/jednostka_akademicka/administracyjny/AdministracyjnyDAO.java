package bdbt.jednostka_akademicka.administracyjny;

import bdbt.jednostka_akademicka.naukowi.Naukowy;
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
public class AdministracyjnyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdministracyjnyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Administracyjny> list() {

        String sql = "SELECT * FROM ADMINISTRACYJNI";
        List<Administracyjny> ListaAdministracyjnych = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Administracyjny.class));

        return ListaAdministracyjnych;
    }

    public void save(Administracyjny administracyjny){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("administracyjni").usingColumns("Nr_pracownika","MS_Office","Nr_biura_dziekanatu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(administracyjny);
        insertActor.execute(param);
    }


    public Administracyjny get(int nrAdministracyjny) {
        String sql = "SELECT * FROM ADMINISTRACYJNI WHERE NR_PRACOWNIKA = ?";
        Object[] args = {nrAdministracyjny};
        Administracyjny administracyjny = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Administracyjny.class));
        return administracyjny;
    }



    public void update(Administracyjny dziekanat) {
        String sql = "UPDATE ADMINISTRACYJNI SET MS_OFFICE=:msOffice, NR_BIURA_DZIEKANATU=:nrBiuraDziekanatu WHERE NR_PRACOWNIKA =:nrPracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dziekanat);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ADMINISTRACYJNI WHERE NR_PRACOWNIKA = ?";
        jdbcTemplate.update(sql, id);
    }

}
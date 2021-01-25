package bdbt.jednostka_akademicka.rektor;

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
public class RektorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RektorDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Rektor> list() {

        String sql = "SELECT * FROM REKTORZY";
        List<Rektor> ListaJezykow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Rektor.class));

        return ListaJezykow;
    }

    public void save(Rektor rektor){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("rektorzy").usingColumns("Imie","Nazwisko","Data_urodzenia","Nr_uczelni","Nr_adresu","Nr_uzytkownika");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rektor);
        insertActor.execute(param);
    }


    public Rektor get(int nrRektora) {
        String sql = "SELECT * FROM REKTORZY WHERE NR_REKTORA = ?";
        Object[] args = {nrRektora};
        Rektor rektor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Rektor.class));
        return rektor;
    }



    public void update(Rektor rektor) {
        String sql = "UPDATE REKTORZY SET IMIE=:imie, NAZWISKO=:nazwisko,DATA_URODZENIA=:dataUrodzenia,NR_UCZELNI=:nrUczelni,NR_ADRESU=:nrAdresu,NR_UZYTKOWNIKA=:nrUzytkownika WHERE NR_REKTORA=:nrRektora";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rektor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM REKTORZY WHERE  NR_REKTORA = ?";
        jdbcTemplate.update(sql, id);
    }

}
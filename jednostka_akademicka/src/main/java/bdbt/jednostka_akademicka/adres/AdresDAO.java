package bdbt.jednostka_akademicka.adres;

import bdbt.jednostka_akademicka.poczta.Poczta;
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
public class AdresDAO {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list() {
        String sql = "SELECT * FROM ADRESY ";
        List<Adres> listaAdresow = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return listaAdresow;
    }

    public void save(Adres adres){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("Miasto","Ulica","Nr_lokalu","Nr_poczty");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }

    public Adres get(int nrAdresu) {
        String sql = "SELECT * FROM ADRESY WHERE NR_ADRESU = ?";
        Object[] args = {nrAdresu};
        Adres adres = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }



    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET MIASTO=:miasto, ULICA=:ulica, NR_LOKALU=:nrLokalu, NR_POCZTY=:nrPoczty  WHERE NR_ADRESU=:nrAdresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ADRESY WHERE  NR_ADRESU = ?";
        jdbcTemplate.update(sql, id);
    }

}
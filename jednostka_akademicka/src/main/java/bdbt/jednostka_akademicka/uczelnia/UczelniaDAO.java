package bdbt.jednostka_akademicka.uczelnia;

import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        insertActor.withTableName("UCZELNIE").usingColumns("Nazwa","Typ_uczelni","Rodzaj","Nr_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczelnia);
        insertActor.execute(param);
    }
    
    public Uczelnia get(int id){
        return null;
    }

    public void update (Uczelnia uczelnie){

    }

    public void delete (int id){

    }

}

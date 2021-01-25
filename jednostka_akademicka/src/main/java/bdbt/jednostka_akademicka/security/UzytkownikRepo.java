package bdbt.jednostka_akademicka.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UzytkownikRepo extends JpaRepository<Uzytkownik, Integer> {


    List<Uzytkownik> findAll();

    Optional<Uzytkownik> findById(Integer nr_uzytkownika);

    boolean existsById(Integer nr_uzytkownika);

    Optional<Uzytkownik> findByLogin(String login);

    Uzytkownik save(Uzytkownik entity);

}

package bdbt.jednostka_akademicka.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UzytkownikRepo extends JpaRepository<Uzytkownik, In> {

    Optional<Uzytkownik> findByLogin(String login);
}

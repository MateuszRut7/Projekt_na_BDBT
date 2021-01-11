package bdbt.jednostka_akademicka.uzytkownik;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UzytkownikRepo extends JpaRepository<Uzytkownik,Integer> {
}

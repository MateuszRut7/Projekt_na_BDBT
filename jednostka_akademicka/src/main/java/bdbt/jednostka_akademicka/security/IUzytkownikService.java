package bdbt.jednostka_akademicka.security;

import java.util.Optional;

public interface IUzytkownikService {

        Optional<Uzytkownik> findById(Integer id);

}

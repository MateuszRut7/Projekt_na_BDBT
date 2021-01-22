/*package bdbt.jednostka_akademicka.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Test {

    public Test(UzytkownikRepo uzytkownikRepo, PasswordEncoder passwordEncoder) {

        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.setNr_uzytkownika(5);
        uzytkownik.setLogin("niee");
        uzytkownik.setHaslo(passwordEncoder.encode("1234"));
        uzytkownik.setRola("ROLE_ADMIN");
        uzytkownikRepo.save(uzytkownik);

    }
}
*/
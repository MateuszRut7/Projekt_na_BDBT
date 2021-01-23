package bdbt.jednostka_akademicka.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UzytkownikService {
    private UzytkownikRepo uzytkownikRepo;
    private PasswordEncoder passwordEncoder;

    public UzytkownikService(UzytkownikRepo uzytkownikRepo, PasswordEncoder passwordEncoder) {
        this.uzytkownikRepo = uzytkownikRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUzytkownik(Uzytkownik uzytkownik){
        uzytkownik.setHaslo(passwordEncoder.encode(uzytkownik.getHaslo()));
        uzytkownikRepo.save(uzytkownik);
    }
}

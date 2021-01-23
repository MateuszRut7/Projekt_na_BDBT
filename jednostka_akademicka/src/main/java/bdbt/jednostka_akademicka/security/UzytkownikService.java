package bdbt.jednostka_akademicka.security;

import bdbt.jednostka_akademicka.instytut.Instytut;
import bdbt.jednostka_akademicka.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UzytkownikService {
    private UzytkownikRepo uzytkownikRepo;
    private PasswordEncoder passwordEncoder;


    public UzytkownikService(UzytkownikRepo uzytkownikRepo, PasswordEncoder passwordEncoder) {
        this.uzytkownikRepo = uzytkownikRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public Optional<Uzytkownik> findById(int id) {
        return uzytkownikRepo.findById(id);
    }

    public Iterable<Uzytkownik> findAll() {
        return uzytkownikRepo.findAll();
    }

    public void addUzytkownik(Uzytkownik uzytkownik){
        uzytkownik.setHaslo(passwordEncoder.encode(uzytkownik.getHaslo()));
        uzytkownikRepo.save(uzytkownik);
    }
}

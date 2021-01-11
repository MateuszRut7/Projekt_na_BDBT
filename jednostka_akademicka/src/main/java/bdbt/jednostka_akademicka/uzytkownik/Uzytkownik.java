package bdbt.jednostka_akademicka.uzytkownik;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Uzytkownik  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Login nie moze byc pusty")
    private String login;
    @NotBlank(message = "Haslo nie moze byc puste")
    private String haslo;
    private String rola;

    public Uzytkownik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}

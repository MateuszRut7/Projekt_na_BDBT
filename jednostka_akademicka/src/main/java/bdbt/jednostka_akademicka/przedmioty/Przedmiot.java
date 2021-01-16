package bdbt.jednostka_akademicka.przedmioty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Przedmiot {
    private int nrPrzedmiotu;
    private String Nazwa;
    private int liczbaGodzin;
    private int ECTS;
    private int nrPracownika;
    private int nrInstytutu;
}


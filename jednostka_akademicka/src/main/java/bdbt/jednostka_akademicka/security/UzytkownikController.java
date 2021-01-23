package bdbt.jednostka_akademicka.security;

import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UzytkownikController {
    private UzytkownikService uzytkownikService;

    public UzytkownikController(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
    }



    @RequestMapping("/uzytkownicy")
    public String pokaz(Model model){
        Iterable<Uzytkownik> ListaUzytkownikow = uzytkownikService.findAll();
        model.addAttribute("ListaUzytkownikow", ListaUzytkownikow );
        return "uzytkownicy";

    }

    @GetMapping("/sing-up")
    public String singUp(Model model){
        model.addAttribute("uzytkownik",new Uzytkownik());
        return "rejestracja";
    }

    @PostMapping("/sing-up")
    public String register(@Valid Uzytkownik uzytkownik, Errors errors){
        if (errors.hasErrors()){
            return "rejestracja";
        }
        uzytkownikService.addUzytkownik(uzytkownik);
        return "rejestracja";
    }
}

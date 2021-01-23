package bdbt.jednostka_akademicka.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UzytkownikController {
    private UzytkownikService uzytkownikService;

    public UzytkownikController(UzytkownikService uzytkownikService) {
        this.uzytkownikService = uzytkownikService;
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

package bdbt.jednostka_akademicka.security;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @RequestMapping("/{id}")
    public String getById( @PathVariable(name = "id") int id, Model model){
       Optional<Uzytkownik> uzytkownik =  uzytkownikService.findById(id);
        model.addAttribute("ListaUzytkownikow", uzytkownik );
        return "uzytkownicy";
    }

    /*
    @GetMapping("/uzytkownicy/{nr_uzytkownika}")
    ResponseEntity<Uzytkownik> readTask(@PathVariable int nr_uzytkownika) {
        return repository.findById(nr_uzytkownika)
                .map(task -> ResponseEntity.ok(task)) // This can be written as .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
     */

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

package bdbt.jednostka_akademicka.jezyki;

import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import bdbt.jednostka_akademicka.uczelnia.UczelniaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private JezykDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Jezyk>ListaJezykow = dao.list();
        model.addAttribute("ListaUczelni", ListaJezykow );
        return "index";

    }

    @RequestMapping("/new")
    public String showNewForm(Model model){
        Jezyk jezyk = new Jezyk();
        model.addAttribute("jezyki",jezyk);
        return "new_form";
    }
}
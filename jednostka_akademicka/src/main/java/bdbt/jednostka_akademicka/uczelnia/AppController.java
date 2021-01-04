package bdbt.jednostka_akademicka.uczelnia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UczelniaDAO dao;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Uczelnia> ListaUczelni = dao.list();
        model.addAttribute("ListaUczelni", ListaUczelni );
        return "index";

    }

    @RequestMapping("/new")
    public String showNewForm(Model model){
        Uczelnia uczelnie = new Uczelnia();
        model.addAttribute("uczelnie",uczelnie);
        return "new_form";
    }
}

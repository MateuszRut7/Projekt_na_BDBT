package bdbt.jednostka_akademicka.administracyjny;

import bdbt.jednostka_akademicka.naukowi.Naukowy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/administracyjni")
public class AdministracyjnyController{


    @Autowired
    private AdministracyjnyDAO administracyjnyDAO;


    @RequestMapping("/")
    public String pokaz(Model model){
        List<Administracyjny> ListaAdministracyjnych = administracyjnyDAO.list();
        model.addAttribute("ListaAdministracyjnych", ListaAdministracyjnych );
        return "administracyjni";

    }

    @RequestMapping("/{nrPracownika}")
    public String getById(@PathVariable(name = "nrPracownika") int nrPracownika, Model model){
        Administracyjny administracyjny =  administracyjnyDAO.get(nrPracownika);
        model.addAttribute("ListaAdministracyjnych", administracyjny );
        return "administracyjni";
    }


    @RequestMapping("/nowy-administracyjny")
    public String nowyNaukowy(Model model){
        Administracyjny administracyjny = new  Administracyjny();
        model.addAttribute("administracyjny",administracyjny);
        return "nowy-administracyjny";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("administracyjny") Administracyjny administracyjny) {
        administracyjnyDAO.save(administracyjny);

        return "redirect:/administracyjni/";
    }

    @RequestMapping("/edit/{nrPracownika}")
    public ModelAndView showEditForm(@PathVariable(name = "nrPracownika") int nrPracownika) {
        ModelAndView mav = new ModelAndView("edytuj-administracyjny");
        Administracyjny administracyjny = administracyjnyDAO.get(nrPracownika);
        mav.addObject("administracyjny", administracyjny);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("administracyjny") Administracyjny administracyjny) {
        administracyjnyDAO.update(administracyjny);

        return "redirect:/administracyjni/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        administracyjnyDAO.delete(id);
        return "redirect:/administracyjni/";
    }


}
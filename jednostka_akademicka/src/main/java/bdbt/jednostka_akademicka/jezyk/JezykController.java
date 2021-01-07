package bdbt.jednostka_akademicka.jezyk;

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
@RequestMapping("/jezyki")
public class JezykController{


    @Autowired
    private JezykDAO jezykDAO;



    @RequestMapping("/")
    public String pokaz(Model model){
        List<Jezyk> ListaJezykow = jezykDAO.list();
        model.addAttribute("ListaJezykow", ListaJezykow );
        return "jezyki";

    }

    @RequestMapping("/nowy-jezyk")
    public String nowyJezyk(Model model){
        Jezyk jezyk = new Jezyk();
        model.addAttribute("jezyk",jezyk);
        return "nowy-jezyk";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("jezyk") Jezyk jezyk) {
        jezykDAO.save(jezyk);

        return "redirect:/jezyki/";
    }

    @RequestMapping("/edit/{nrJezyka}")
    public ModelAndView showEditForm(@PathVariable(name = "nrJezyka") int nrJezyka) {
        ModelAndView mav = new ModelAndView("edytuj-jezyk");
        Jezyk jezyk = jezykDAO.get(nrJezyka);
        mav.addObject("jezyk", jezyk);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("jezyk") Jezyk jezyk) {
        jezykDAO.update(jezyk);

        return "redirect:/jezyki/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        jezykDAO.delete(id);
        return "redirect:/jezyki/";
    }

}

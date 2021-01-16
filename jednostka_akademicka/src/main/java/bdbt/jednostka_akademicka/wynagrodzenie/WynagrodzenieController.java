package bdbt.jednostka_akademicka.wynagrodzenie;

import bdbt.jednostka_akademicka.wydzial.Wydzial;
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
@RequestMapping("/wynagrodzenia")
public class WynagrodzenieController{


    @Autowired
    private WynagrodzenieDAO wynagrodzenieDAO;



    @RequestMapping("/")
    public String pokaz(Model model){
        List<Wynagrodzenie> ListaWynagrodzen = wynagrodzenieDAO.list();
        model.addAttribute("ListaWynagrodzen", ListaWynagrodzen );
        return "wynagrodzenia";

    }

    @RequestMapping("/{id}")
    public String getById(@PathVariable(name = "id") int id, Model model){
        Wynagrodzenie wynagrodzenie =  wynagrodzenieDAO.get(id);
        model.addAttribute("ListaWynagrodzen", wynagrodzenie );
        return "wynagrodzenia";
    }

    @RequestMapping("/nowe-wynagrodzenie")
    public String nowyWydzial(Model model){
        Wynagrodzenie wynagrodzenie = new Wynagrodzenie();
        model.addAttribute("wynagrodzenie",wynagrodzenie);
        return "nowe-wynagrodzenie";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("wynagrodzenie") Wynagrodzenie wynagrodzenie) {
        wynagrodzenieDAO.save(wynagrodzenie);

        return "redirect:/wynagrodzenia/";
    }

    @RequestMapping("/edit/{nrWynagrodzenia}")
    public ModelAndView showEditForm(@PathVariable(name = "nrWynagrodzenia") int nrWynagrodzenia) {
        ModelAndView mav = new ModelAndView("edytuj-wynagrodzenie");
        Wynagrodzenie wynagrodzenie = wynagrodzenieDAO.get(nrWynagrodzenia);
        mav.addObject("wynagrodzenie", wynagrodzenie);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("wynagrodzenie") Wynagrodzenie wynagrodzenie) {
        wynagrodzenieDAO.update(wynagrodzenie);

        return "redirect:/wynagrodzenia/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        wynagrodzenieDAO.delete(id);
        return "redirect:/wynagrodzenia/";
    }

}
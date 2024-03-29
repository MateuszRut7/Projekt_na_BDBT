package bdbt.jednostka_akademicka.wydzial;

import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
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
@RequestMapping("/wydzialy")
public class WydzialController{


    @Autowired
    private WydzialDAO wydzialDAO;



    @RequestMapping("/")
    public String pokaz(Model model){
        List<Wydzial> ListaWydzialow = wydzialDAO.list();
        model.addAttribute("ListaWydzialow", ListaWydzialow );
        return "wydzialy";

    }

    @RequestMapping("/{id}")
    public String getById(@PathVariable(name = "id") int id, Model model){
        Wydzial wydzial =  wydzialDAO.get(id);
        model.addAttribute("ListaWydzialow", wydzial );
        return "wydzialy";
    }

    @RequestMapping("/nowy-wydzial")
    public String nowyWydzial(Model model){
        Wydzial wydzial = new Wydzial();
        model.addAttribute("wydzial",wydzial);
        return "nowy-wydzial";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("wydzial") Wydzial wydzial) {
        wydzialDAO.save(wydzial);

        return "redirect:/wydzialy/";
    }

    @RequestMapping("/edit/{nrWydzialu}")
    public ModelAndView showEditForm(@PathVariable(name = "nrWydzialu") int nrWydzialu) {
        ModelAndView mav = new ModelAndView("edytuj-wydzial");
        Wydzial wydzial = wydzialDAO.get(nrWydzialu);
        mav.addObject("wydzial", wydzial);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("wydzial") Wydzial wydzial) {
        wydzialDAO.update(wydzial);

        // do poprawki
        return "redirect:/wydzialy/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        wydzialDAO.delete(id);
        return "redirect:/wydzialy/";
    }

}
package bdbt.jednostka_akademicka.przedmioty;

import bdbt.jednostka_akademicka.dziekanat.Dziekanat;
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
@RequestMapping("/przedmioty")
public class PrzedmiotController{


    @Autowired
    private PrzedmiotDAO przedmiotDAO;


    @RequestMapping("/{nrPrzedmiotu}")
    public String getById(@PathVariable(name = "nrPrzedmiotu") int nrPrzedmiotu, Model model){
        Przedmiot przedmiot =  przedmiotDAO.get(nrPrzedmiotu);
        model.addAttribute("ListaPrzedmiotow", przedmiot );
        return "przedmioty";
    }

    @RequestMapping("/")
    public String pokaz(Model model){
        List<Przedmiot> ListaPrzedmiotow = przedmiotDAO.list();
        model.addAttribute("ListaPrzedmiotow", ListaPrzedmiotow );
        return "przedmioty";

    }

    @RequestMapping("/nowy-przedmiot")
    public String nowyPrzedmiot(Model model){
        Przedmiot przedmiot = new Przedmiot();
        model.addAttribute("przedmiot",przedmiot);
        return "nowy-przedmiot";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("przedmiot") Przedmiot przedmiot) {
        przedmiotDAO.save(przedmiot);

        return "redirect:/przedmioty/";
    }

    @RequestMapping("/edit/{nrprzedmiotu}")
    public ModelAndView showEditForm(@PathVariable(name = "nrprzedmiotu") int nrprzedmiotu) {
        ModelAndView mav = new ModelAndView("edytuj-przedmiot");
        Przedmiot przedmiot = przedmiotDAO.get(nrprzedmiotu);
        mav.addObject("przedmiot", przedmiot);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("przedmiot") Przedmiot przedmiot) {
        przedmiotDAO.update(przedmiot);

        return "redirect:/przedmioty/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        przedmiotDAO.delete(id);
        return "redirect:/przedmioty/";
    }


}
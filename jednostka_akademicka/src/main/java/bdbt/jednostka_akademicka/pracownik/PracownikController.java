package bdbt.jednostka_akademicka.pracownik
        ;


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
@RequestMapping("/pracownicy")
public class PracownikController {

    @Autowired
    private PracownikDAO pracownikDAO;


    @RequestMapping("/")
    public String pokaz(Model model){
        List<Pracownik> ListaPracownikow = pracownikDAO.list();
        model.addAttribute("ListaPracownikow", ListaPracownikow );
        return "pracownicy";

    }


    @RequestMapping("/nowy-pracownik")
    public String showNewForm(Model model){
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik",pracownik);
        return "nowy-pracownik";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikDAO.save(pracownik);

        return "redirect:/pracownicy/";
    }

    @RequestMapping("/edit/{nrPracownika}")
    public ModelAndView showEditForm(@PathVariable(name = "nrPracownika") int nrPracownika) {
        ModelAndView mav = new ModelAndView("edytuj-pracownika");
        Pracownik pracownik = pracownikDAO.get(nrPracownika);
        mav.addObject("pracownik", pracownik);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikDAO.update(pracownik);

        return "redirect:/pracownicy/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        pracownikDAO.delete(id);
        return "redirect:/pracownicy/";
    }
}
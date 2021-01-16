package bdbt.jednostka_akademicka.instytut;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
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
@RequestMapping("/instytuty")
public class InstytutController {


    @Autowired
    private InstytutDAO instytutDAO;


    @RequestMapping("/")
    public String pokaz(Model model) {
        List<Instytut> ListaInstytuty = instytutDAO.list();
        model.addAttribute("ListaInstytuty", ListaInstytuty);
        return "instytuty";

    }

    @RequestMapping("/{id}")
    public String getById(@PathVariable(name = "id") int id, Model model) {
        Instytut instytut = instytutDAO.get(id);
        model.addAttribute("ListaInstytuty", instytut);
        return "instytuty";
    }

    @RequestMapping("/nowy-instytut")
    public String nowyInstytut(Model model) {
        Instytut instytut = new Instytut();
        model.addAttribute("instytut", instytut);
        return "nowy-instytut";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("instytut") Instytut instytut) {
        instytutDAO.save(instytut);

        return "redirect:/instytuty/";
    }

    @RequestMapping("/edit/{nrInstytutu}")
    public ModelAndView showEditForm(@PathVariable(name = "nrInstytutu") int nrInstytutu) {
        ModelAndView mav = new ModelAndView("edytuj-instytut");
        Instytut instytut = instytutDAO.get(nrInstytutu);
        mav.addObject("instytut", instytut);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("instytut") Instytut instytut) {
        instytutDAO.update(instytut);

        return "redirect:/instytuty/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        instytutDAO.delete(id);
        return "redirect:/instytuty/";
    }
}
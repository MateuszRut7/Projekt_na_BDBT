package bdbt.jednostka_akademicka.dziekanat;

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
@RequestMapping("/dziekanaty")
public class DziekanatController{


    @Autowired
    private DziekanatDAO dziekanatDAO;


    @RequestMapping("/{nrBiuraDziekanatu}")
    public String getById(@PathVariable(name = "nrBiuraDziekanatu") int nrBiuraDziekanatu, Model model){
        Dziekanat dziekanat =  dziekanatDAO.get(nrBiuraDziekanatu);
        model.addAttribute("ListaDziekanatow", dziekanat );
        return "dziekanaty";
    }

    @RequestMapping("/")
    public String pokaz(Model model){
        List<Dziekanat> ListaDziekanatow = dziekanatDAO.list();
        model.addAttribute("ListaDziekanatow", ListaDziekanatow );
        return "dziekanaty";

    }

    @RequestMapping("/nowy-dziekanat")
    public String nowyDziekanat(Model model){
        Dziekanat dziekanat = new Dziekanat();
        model.addAttribute("dziekanat",dziekanat);
        return "nowy-dziekanat";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("dziekanat") Dziekanat dziekanat) {
        dziekanatDAO.save(dziekanat);

        return "redirect:/dziekanaty/";
    }

    @RequestMapping("/edit/{nrBiuraDziekanatu}")
    public ModelAndView showEditForm(@PathVariable(name = "nrBiuraDziekanatu") int nrBiuraDziekanatu) {
        ModelAndView mav = new ModelAndView("edytuj-dziekanat");
        Dziekanat dziekanat = dziekanatDAO.get(nrBiuraDziekanatu);
        mav.addObject("dziekanat", dziekanat);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("dziekanat") Dziekanat dziekanat) {
        dziekanatDAO.update(dziekanat);

        return "redirect:/dziekanaty/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dziekanatDAO.delete(id);
        return "redirect:/dziekanaty/";
    }


}
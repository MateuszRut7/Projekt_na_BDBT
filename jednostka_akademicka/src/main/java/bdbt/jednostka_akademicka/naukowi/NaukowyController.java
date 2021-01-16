package bdbt.jednostka_akademicka.naukowi;

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
@RequestMapping("/naukowi")
public class NaukowyController{


    @Autowired
    private NaukowyDAO naukowyDAO;


    @RequestMapping("/")
    public String pokaz(Model model){
        List<Naukowy> ListaNaukowych = naukowyDAO.list();
        model.addAttribute("ListaNaukowych", ListaNaukowych );
        return "naukowi";

    }

    @RequestMapping("/{nrPracownika}")
    public String getById(@PathVariable(name = "nrPracownika") int nrPracownika, Model model){
        Naukowy naukowy =  naukowyDAO.get(nrPracownika);
        model.addAttribute("ListaNaukowych", naukowy );
        return "naukowi";
    }


    @RequestMapping("/nowy-naukowy")
    public String nowyNaukowy(Model model){
        Naukowy naukowy = new Naukowy();
        model.addAttribute("naukowy",naukowy);
        return "nowy-naukowy";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("naukowy") Naukowy naukowy) {
        naukowyDAO.save(naukowy);

        return "redirect:/naukowi/";
    }

    @RequestMapping("/edit/{nrPracownika}")
    public ModelAndView showEditForm(@PathVariable(name = "nrPracownika") int nrPracownika) {
        ModelAndView mav = new ModelAndView("edytuj-naukowy");
        Naukowy naukowy = naukowyDAO.get(nrPracownika);
        mav.addObject("naukowy", naukowy);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("naukowy") Naukowy naukowy) {
        naukowyDAO.update(naukowy);

        return "redirect:/naukowi/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        naukowyDAO.delete(id);
        return "redirect:/naukowi/";
    }


}
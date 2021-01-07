package bdbt.jednostka_akademicka.uczelnia;


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
@RequestMapping("/uczelnie")
public class UczelniaController {

    @Autowired
    private UczelniaDAO uczDAO;


    @RequestMapping("/")
    public String pokaz(Model model){
        List<Uczelnia> ListaUczelni = uczDAO.list();
        model.addAttribute("ListaUczelni", ListaUczelni );
        return "uczelnie";

    }


    @RequestMapping("/nowa-uczelnia")
    public String showNewForm(Model model){
        Uczelnia uczelnie = new Uczelnia();
        model.addAttribute("uczelnie",uczelnie);
        return "nowa-uczelnia";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("uczelnia") Uczelnia uczelnia) {
        uczDAO.save(uczelnia);

        return "redirect:/uczelnie/";
    }

    @RequestMapping("/edit/{nrUczelni}")
    public ModelAndView showEditForm(@PathVariable(name = "nrUczelni") int nrUczelni) {
        ModelAndView mav = new ModelAndView("edytuj-uczelnie");
        Uczelnia uczelnia = uczDAO.get(nrUczelni);
        mav.addObject("uczelnia", uczelnia);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("uczelnia") Uczelnia uczelnia) {
        uczDAO.update(uczelnia);

        // do poprawki
        return "redirect:/uczelnie/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        uczDAO.delete(id);
        return "redirect:/uczelnie/";
    }
}
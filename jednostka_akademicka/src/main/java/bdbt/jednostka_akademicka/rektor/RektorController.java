package bdbt.jednostka_akademicka.rektor;

import bdbt.jednostka_akademicka.jezyk.Jezyk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rektorzy")
public class RektorController {


    @Autowired
    private RektorDAO rektorDAO;



    @RequestMapping("/")
    public String pokaz(Model model){
        List<Rektor> ListaRektorow = rektorDAO.list();
        model.addAttribute("ListaRektorow", ListaRektorow );
        return "rektorzy";

    }

    @RequestMapping("/{id}")
    public String getById(@PathVariable(name = "id") int id, Model model){
        Rektor rektor =  rektorDAO.get(id);
        model.addAttribute("ListaRektorow", rektor );
        return "rektorzy";
    }

    @RequestMapping("/nowy-rektor")
    public String nowyJezyk(Model model){
        Rektor rektor = new Rektor();
        model.addAttribute("rektor",rektor);
        return "nowy-rektor";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("rektor") @Valid Rektor rektor) {
        rektorDAO.save(rektor);

        return "redirect:/rektorzy/";
    }

    @RequestMapping("/edit/{nrRektora}")
    public ModelAndView showEditForm(@PathVariable(name = "nrRektora") int nrRektora) {
        ModelAndView mav = new ModelAndView("edytuj-rektora");
        Rektor rektor = rektorDAO.get(nrRektora);
        mav.addObject("rektor",  rektor);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("rektor") @Valid Rektor rektor) {
        rektorDAO.update(rektor);

        return "redirect:/rektorzy/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        rektorDAO.delete(id);
        return "redirect:/rektorzy/";
    }
}

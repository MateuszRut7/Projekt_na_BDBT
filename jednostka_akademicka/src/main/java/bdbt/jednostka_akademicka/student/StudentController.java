package bdbt.jednostka_akademicka.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequestMapping("/studenci")
@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;


    @RequestMapping("/")
    public String pokaz( Model model){
        List<Student> ListaStudentow = studentDAO.list();
        model.addAttribute("ListaStudentow", ListaStudentow );
        return "studenci";

    }

    @RequestMapping("/student/{id}")
    public String getById(@PathVariable(name = "id") int id,  Model model){
        Student student =  studentDAO.get(id);
        model.addAttribute("ListaStudentow", student );
        return "studenci";
    }

    @RequestMapping("/uzytkownik/{id}")
    public String getByUzytkownik(@PathVariable(name = "id") int id,  Model model){
        Student student =  studentDAO.getByUzytkownik(id);
        model.addAttribute("ListaStudentow", student );
        return "studenci";
    }


    @RequestMapping("/nowy-student")
    public String showNewForm( Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "nowy-student";
    }

    @RequestMapping( value = "/save", method = RequestMethod.POST)
    public String save( @ModelAttribute("student") @Valid Student student,
                        Errors errors) {
        if(errors.hasErrors()){
            System.out.println("nie dziala");
            return "redirect:/studenci/";
        }
        studentDAO.save(student);

        return "redirect:/studenci/";
    }

    @RequestMapping("/edit/{nrStudenta}")
    public ModelAndView showEditForm( @PathVariable(name = "nrStudenta") int nrStudenta) {
        ModelAndView mav = new ModelAndView("edytuj-studenta");
        Student student = studentDAO.get(nrStudenta);
        mav.addObject("student", student);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update( @ModelAttribute("student") @Valid Student student,
                          Errors errors){

        if(errors.hasErrors()){
            System.out.println("nie dziala");
            return "redirect:/studenci/";
        }

        studentDAO.update(student);
        return "redirect:/studenci/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        studentDAO.delete(id);
        return "redirect:/studenci/";
    }
}

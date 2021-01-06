package bdbt.jednostka_akademicka.student;

import bdbt.jednostka_akademicka.uczelnia.Uczelnia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/studenci")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;


    @RequestMapping("/")
    public String pokazStudentow(Model model){
        List<Student> ListaStudentow = studentDAO.list();
        model.addAttribute("ListaStudentow", ListaStudentow );
        return "studenci";

    }


    @RequestMapping("/nowy-student")
    public String showNewForm(Model model){
        Student studenci = new Student();
        model.addAttribute("studenci",studenci);
        return "nowy-student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student) {
        studentDAO.save(student);

        return "nowy-student";
    }

    @RequestMapping("/edit/{nrStudenta}")
    public ModelAndView showEditForm(@PathVariable(name = "nrStudenta") int nrStudenta) {
        ModelAndView mav = new ModelAndView("edytuj-uczelnie");
        Student student = studentDAO.get(nrStudenta);
        mav.addObject("student", student);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("student") Student student) {
        studentDAO.update(student);

        // do poprawki
        return "studenci";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        studentDAO.delete(id);
        return "studenci";
    }
}
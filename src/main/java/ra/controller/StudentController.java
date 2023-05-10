package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.entity.Students;
import ra.model.service.student.StudentServiceIMPL;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("studentController")
public class StudentController {
    StudentServiceIMPL studentServiceIMPL = new StudentServiceIMPL();
    @GetMapping("/GetAll")
    public String getAll(Model model) throws SQLException {
        List<Students> list = studentServiceIMPL.findAll();
        model.addAttribute("list_student", list);
        return "students";
    }
    @PostMapping("/Create")
    public String create(@RequestParam String name, @RequestParam int age, @RequestParam boolean sex, @RequestParam String address, Model model) throws SQLException {
        Students newStudents = new Students(0,name,age,sex,address);
        studentServiceIMPL.save(newStudents);
        return getAll(model);
    }
    @GetMapping("/Add")
    public String add (){
        return "create";
    }
}

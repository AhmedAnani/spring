package com.example.test.Controller;

import com.example.test.Model.Customers;
import com.example.test.Model.Employees;
import com.example.test.Services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmpController {
    @Autowired
  private EmpServices empService;

    @GetMapping("/all")
  private   List<Employees> getemp(){
    return empService.getAllEmp();
    }
    @PostMapping("/add")
    private String postemp(@RequestBody Employees employees){
        try{
            empService.saveEmp(employees);
            return "Employee Saved ";
        }catch (Exception e){
            return e.toString();
        }
    }
    @GetMapping("/getid/{id}")
    private Optional<Employees>getId(@PathVariable int id){
      return   empService.getById(id);
    }
    @GetMapping("/getname/{name}")
    private List<Employees>getname(@PathVariable String name){
        return empService.getByName(name);
    }
}

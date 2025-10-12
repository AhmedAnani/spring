package com.example.test.Services;

import com.example.test.Model.Employees;
import com.example.test.repository.emplyecrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServices {
    @Autowired
    emplyecrud Emplyecrud;

   public List<Employees> getAllEmp(){
       return Emplyecrud.findAll();
    }
    public void saveEmp(Employees employees){
        Emplyecrud.save(employees);

   }
   public Optional<Employees> getById(Integer id){
      return Emplyecrud.findById(id);
   }
    public List<Employees>getByName(String name){
       return Emplyecrud.findByFirstName(name);
    }

}

package com.kashuba.simplewebapp.controller;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.service.EmployeeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService defaultEmployeeService;

  @PostMapping
  public Long createClient(@RequestBody EmployeeDto employeeDto) {
    return defaultEmployeeService.create(employeeDto);
  }

  @GetMapping("/{id}")
  public EmployeeDto get(@PathVariable Long id) {
    return defaultEmployeeService.get(id);
  }

  @GetMapping("/all")
  public List<EmployeeDto> getAll() {
    return defaultEmployeeService.getAll();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    defaultEmployeeService.delete(id);
  }

  @PutMapping
  public Long update(@Valid @RequestBody EmployeeDto employeeDto) {
    return defaultEmployeeService.update(employeeDto);
  }
}
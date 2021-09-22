package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

  Long create(EmployeeDto employeeDto);

  Long update(EmployeeDto employeeDto);

  void delete(Long id);

  List<EmployeeDto> getAll();

  EmployeeDto get(Long id);
}
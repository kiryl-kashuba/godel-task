package com.kashuba.simplewebapp.dao;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import java.util.List;

public interface EmployeeDao {

  Long create(EmployeeDto employeeDto);

  EmployeeDto get(Long id);

  List<EmployeeDto> getAll();

  Long update(EmployeeDto employeeDto);

  void delete(Long id);
}


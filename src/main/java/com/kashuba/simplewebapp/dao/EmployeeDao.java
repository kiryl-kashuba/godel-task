package com.kashuba.simplewebapp.dao;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import java.util.List;

public interface EmployeeDao {

  int create(EmployeeDto employeeDto);

  EmployeeDto get(Long id);

  List<EmployeeDto> getAll();

  int update(EmployeeDto employeeDto);

  int delete(Long id);
}


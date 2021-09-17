package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.dao.EmployeeDao;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements Crud<EmployeeDto> {

  @Autowired
  private EmployeeDao employeeDao;

  @Override
  public int create(EmployeeDto employeeDto) {
    return employeeDao.create(employeeDto);
  }

  @Override
  public int update(EmployeeDto employeeDto) {
    return employeeDao.update(employeeDto);
  }

  @Override
  public void delete(Long id) {
    employeeDao.delete(id);
  }

  @Override
  public List<EmployeeDto> findAll() {
    return employeeDao.getAll();
  }

  @Override
  public EmployeeDto find(Long id) {
    return employeeDao.get(id);
  }
}


package com.kashuba.simplewebapp.service;

import com.kashuba.simplewebapp.dao.EmployeeDao;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmployeeService implements EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;

  @Override
  public Long create(EmployeeDto employeeDto) {
    return employeeDao.create(employeeDto);
  }

  @Override
  public Long update(EmployeeDto employeeDto) {
    return employeeDao.update(employeeDto);
  }

  @Override
  public void delete(Long id) {
    employeeDao.delete(id);
  }

  @Override
  public List<EmployeeDto> getAll() {
    return employeeDao.getAll();
  }

  @Override
  public EmployeeDto get(Long id) {
    return employeeDao.get(id);
  }
}
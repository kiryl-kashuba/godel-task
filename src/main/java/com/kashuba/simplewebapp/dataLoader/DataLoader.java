package com.kashuba.simplewebapp.dataLoader;

import com.kashuba.simplewebapp.dao.EmployeeDao;
import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.dto.Gender;
import com.kashuba.simplewebapp.service.EmployeeService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void run(ApplicationArguments args) {
    jdbcTemplate.execute("drop table IF EXISTS employee");
    jdbcTemplate.execute("create table employee(" +
        "employee_id serial, first_name varchar(100), last_name varchar(100), department_id integer, job_title "
        + "varchar(100), gender varchar(30), date_of_birth date)");
    employeeService.create(new EmployeeDto( "Evgen",
        "Borisov", 42L, "back-end developer",
        Gender.MALE, Date.valueOf("2000-12-12")));
    employeeService.create(new EmployeeDto( "Francois",
        "Coty", 13L, "back-end developer",
        Gender.MALE, Date.valueOf("2000-12-12")));
    employeeService.create(new EmployeeDto( "Ernest",
        "Bo", 12L, "back-end developer",
        Gender.MALE, Date.valueOf("2000-12-12")));
    employeeService.create(new EmployeeDto( "Mark",
        "Buxton", 61L, "back-end developer",
        Gender.MALE, Date.valueOf("2000-12-12")));
  }
}

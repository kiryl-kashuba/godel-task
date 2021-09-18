package com.kashuba.simplewebapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.dto.Gender;
import com.kashuba.simplewebapp.service.DefaultEmployeeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CrudTest {

  @Autowired
  private DefaultEmployeeService defaultEmployeeService;

  @Test
  public void create() throws ParseException {
    Integer check = defaultEmployeeService.create(new EmployeeDto(22L, "Stan", "Fillow",
        543L, "dancer", Gender.MALE,
        new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998")));
    assertThat(check).isGreaterThan(0);
  }

  @Test
  public void get() {
    EmployeeDto employeeDto = defaultEmployeeService.get(22L);
    assertThat(employeeDto.getEmployeeId()).isEqualTo(22);
  }

  @Test
  public void getAll() {
    List<EmployeeDto> employees = defaultEmployeeService.getAll();
    Assertions.assertThat(employees.size()).isGreaterThan(0);
  }
}
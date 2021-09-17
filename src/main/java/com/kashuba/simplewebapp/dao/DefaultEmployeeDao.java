package com.kashuba.simplewebapp.dao;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.dto.Gender;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultEmployeeDao implements EmployeeDao {

  private static final String createQuery = "INSERT INTO EMPLOYEE VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
  private static final String getQuery = "SELECT * FROM EMPLOYEE WHERE employee_id = ?";
  private static final String getAllQuery = "SELECT * FROM EMPLOYEE";
  private static final String updateQuery = "UPDATE EMPLOYEE SET first_name = ?, last_name = ?, department_id = ?, "
      + "job_title = ?, "
      + "gender = ?, date_of_birth = ? WHERE employee_id=?";
  private static final String deleteQuery = "DELETE from EMPLOYEE where employee_id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private EmployeeDto mapRowToEmployee(ResultSet resultSet, int rowNum) throws SQLException {
    return EmployeeDto.builder()
        .employeeId(resultSet.getLong("employee_id"))
        .firstName(resultSet.getString("first_name"))
        .lastName(resultSet.getString("last_name"))
        .departmentId(resultSet.getLong("department_id"))
        .jobTitle(resultSet.getString("job_title"))
        .gender((Gender.valueOf(resultSet.getString("gender"))))
        .dateOfBirth(resultSet.getTimestamp("date_of_birth"))
        .build();
  }

  public int create(EmployeeDto employeeDto) {
    return jdbcTemplate.update(createQuery, employeeDto.getFirstName(),
        employeeDto.getLastName(), employeeDto.getDepartmentId(), employeeDto.getJobTitle(),
        employeeDto.getGender().toString(), employeeDto.getDateOfBirth());
  }

  public EmployeeDto get(Long id) {
    return jdbcTemplate.queryForObject(getQuery, this::mapRowToEmployee, id);
  }

  public List<EmployeeDto> getAll() {
    return jdbcTemplate.query(getAllQuery, this::mapRowToEmployee);
  }

  public int update(EmployeeDto employeeDto) {
    return jdbcTemplate.update(updateQuery, employeeDto.getFirstName(), employeeDto.getLastName(),
        employeeDto.getDepartmentId(), employeeDto.getJobTitle(), employeeDto.getGender().toString(),
        employeeDto.getDateOfBirth(), employeeDto.getEmployeeId());
  }

  public int delete(Long id) {
    return jdbcTemplate.update(deleteQuery, id);
  }
}

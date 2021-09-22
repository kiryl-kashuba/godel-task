package com.kashuba.simplewebapp.dao;

import com.kashuba.simplewebapp.dto.EmployeeDto;
import com.kashuba.simplewebapp.dto.Gender;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
  KeyHolder keyHolder = new GeneratedKeyHolder();
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

  public Long create(EmployeeDto employeeDto) {
    jdbcTemplate.update(connection -> {
      PreparedStatement stmt = connection.prepareStatement(createQuery, new String[]{"employee_id"});
      stmt.setString(1, employeeDto.getFirstName());
      stmt.setString(2, employeeDto.getLastName());
      stmt.setLong(3, employeeDto.getDepartmentId());
      stmt.setString(4, employeeDto.getJobTitle());
      stmt.setString(5, employeeDto.getGender().toString());
      stmt.setDate(6, new Date(employeeDto.getDateOfBirth().getTime()));
      return stmt;
    }, keyHolder);
    return keyHolder.getKey().longValue();
  }

  public EmployeeDto get(Long id) {
    return jdbcTemplate.queryForObject(getQuery, this::mapRowToEmployee, id);
  }

  public List<EmployeeDto> getAll() {
    return jdbcTemplate.query(getAllQuery, this::mapRowToEmployee);
  }

//  public int update2(EmployeeDto employeeDto) {
//    return jdbcTemplate.update(updateQuery, employeeDto.getFirstName(), employeeDto.getLastName(),
//        employeeDto.getDepartmentId(), employeeDto.getJobTitle(), employeeDto.getGender().toString(),
//        employeeDto.getDateOfBirth(), employeeDto.getEmployeeId());
//  }

  public Long update(EmployeeDto employeeDto) {
    jdbcTemplate.update(connection -> {
      PreparedStatement stmt = connection.prepareStatement(updateQuery, new String[]{"employee_id"});
      stmt.setString(1, employeeDto.getFirstName());
      stmt.setString(2, employeeDto.getLastName());
      stmt.setLong(3, employeeDto.getDepartmentId());
      stmt.setString(4, employeeDto.getJobTitle());
      stmt.setString(5, employeeDto.getGender().toString());
      stmt.setDate(6, new Date(employeeDto.getDateOfBirth().getTime()));
      stmt.setLong(7, employeeDto.getEmployeeId());
      return stmt;
    }, keyHolder);
    return keyHolder.getKey().longValue();
  }

  public void delete(Long id) {
    jdbcTemplate.update(deleteQuery, id);
  }
}

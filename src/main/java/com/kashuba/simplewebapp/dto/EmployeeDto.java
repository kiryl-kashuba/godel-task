package com.kashuba.simplewebapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

  private Long employeeId;
  private String firstName;
  private String lastName;
  private Long departmentId;
  private String jobTitle;
  private Gender gender;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date dateOfBirth;

  @JsonCreator
  public EmployeeDto(
      @JsonProperty("employeeId") Long employeeId,
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("departmentId") Long departmentId,
      @JsonProperty("jobTitle") String jobTitle,
      @JsonProperty("gender") Gender gender,
      @JsonProperty("dateOfBirth") Date dateOfBirth) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentId = departmentId;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
  }

  public EmployeeDto(String firstName, String lastName, Long departmentId, String jobTitle,
      Gender gender, Date dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentId = departmentId;
    this.jobTitle = jobTitle;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
  }
}
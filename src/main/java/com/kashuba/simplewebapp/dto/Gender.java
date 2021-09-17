package com.kashuba.simplewebapp.dto;

public enum Gender {
  MALE("MALE"),
  FEMALE("FEMALE");

  private final String title;

  Gender(String title) {
    this.title = title;
  }
}
package com.malcolmscruggs.wellframe;

import lombok.Data;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
public class Patient {
  private @Id @GeneratedValue Long id;
  private String name;

  Patient(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package com.malcolmscruggs.wellframe;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@Entity
public class Medication {

  private @Id @GeneratedValue Long medicationId;

  @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Patient> patients;

  private String name;

  Medication(String name) {
    this.name = name;
    this.patients = new HashSet<>();
  }

  public boolean addPatient(Patient patient) {
    return patients.add(patient);
  }

  public boolean removePatient(Patient patient) {
    return patients.remove(patient);
  }
}

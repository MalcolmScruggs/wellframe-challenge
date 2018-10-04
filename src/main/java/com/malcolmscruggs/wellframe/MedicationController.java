package com.malcolmscruggs.wellframe;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicationController {

  private final MedicationRepository medicationRepository;
  private final PatientRepository patientRepository;

  MedicationController(MedicationRepository medicationRepository,
                       PatientRepository patientRepository) {
    this.medicationRepository = medicationRepository;
    this.patientRepository = patientRepository;
  }

  @GetMapping("/medications")
  List<Medication> allMedications() {
    return medicationRepository.findAll();
  }

  @GetMapping("/medications/{id}")
  Medication oneMedication(@PathVariable Long id) throws MedError {
    return medicationRepository.findById(id)
            .orElseThrow(() -> new MedError("no medicaiton with id:" + id));
  }

  @PostMapping("/medications")
  Medication newMedication(@RequestBody Medication newMedication) {
    return medicationRepository.save(newMedication);
  }

  @GetMapping("/patients")
  List<Patient> allPatients() {
    return patientRepository.findAll();
  }

  @GetMapping("/patients/{id}")
  Patient onePatient(@PathVariable Long id) throws MedError {
    return patientRepository.findById(id)
            .orElseThrow(() -> new MedError("no patient with id:" + id));
  }

  @PostMapping("/patients")
  Patient newPatient(@RequestBody Patient newPatient) {
    return patientRepository.save(newPatient);
  }

  @PutMapping("/medications/{medicineId}/perscriptions")
  Medication perscribeMedicine(@PathVariable("medicineId") Long medicationId,
                            @RequestBody Long patientId) throws MedError {
    Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new MedError("no patient with id:" + patientId));
    return medicationRepository.findById(medicationId)
            .map(medication -> {
              medication.addPatient(patient);
              return medicationRepository.save(medication);
            })
            .orElseThrow(() -> new MedError("no medice with id:" + medicationId));
  }

  @DeleteMapping("/medications/{medicineId}/perscriptions")
  Medication unperscribeMedicine(@PathVariable("medicineId") Long medicationId,
                                 @RequestBody Long patientId) throws MedError {
    Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new MedError("no patient with id:" + patientId));
    return medicationRepository.findById(medicationId)
            .map(medication -> {
              medication.removePatient(patient);
              return medicationRepository.save(medication);
            })
            .orElseThrow(() -> new MedError("no medice with id:" + medicationId));
  }
}

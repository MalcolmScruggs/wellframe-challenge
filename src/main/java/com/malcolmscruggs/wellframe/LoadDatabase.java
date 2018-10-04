package com.malcolmscruggs.wellframe;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creates demo objects in the system
 */
@Configuration
@Slf4j
public class LoadDatabase {
  @Bean
  CommandLineRunner initDatabase(MedicationRepository repository, PatientRepository patientRepository) {
    return args -> {
      repository.save(new Medication("Medication 1"));
      repository.save(new Medication("Medication 2"));
      patientRepository.save(new Patient("Test Patient"));
    };
  }
}

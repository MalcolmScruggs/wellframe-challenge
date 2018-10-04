Run with: mvn spring-boot:run 
More info on running here: https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html)


Routes: see MedicationController.java for complete list
- Add a new medication to the list of available medications (/medications)
- Create a new patient (/patients)
- Assign a patient a new medication from the list of available medications (/medications/{medicineId}/perscriptions)
- Remove a medication from the list of medications assigned to a patient (/medications/{medicineId}/perscriptions)
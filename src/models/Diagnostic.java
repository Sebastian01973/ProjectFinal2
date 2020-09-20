package models;

import java.time.LocalDate;

public class Diagnostic {

    private Patient patient;
    private LocalDate dateOfDiagnostic;
    private LocalDate dateOfDeath;
    private LocalDate dateOfRecovered;
    private int idCases;

    public Diagnostic(int number,Patient patient, LocalDate dateOfDiagnostic, LocalDate dateOfDeath, LocalDate dateOfRecovered) {
        this.dateOfDiagnostic = dateOfDiagnostic;
        this.patient = patient;
        this.idCases = number;
        validateRecovered(dateOfRecovered);
        validateDeath(dateOfDeath);
    }
    
    public void validateRecovered(LocalDate date) {
    	this.dateOfRecovered = (patient.getStates() == Attention.RECOVERED || date == null)?date:null;
    }
    
    public void validateDeath(LocalDate date) {
    	this.dateOfDeath = (patient.getStates() == Attention.DECEASED || date == null)?date:null;
    }

	public Patient getPatient() {
		return patient;
	}

	public LocalDate getDateOfDiagnostic() {
		return dateOfDiagnostic;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}

	public LocalDate getDateOfRecovered() {
		return dateOfRecovered;
	}

	public int getIdCases() {
		return this.idCases;
	}

	public Object[] toObjectVector() {
		return new Object[] {
				idCases
				,getPatient().getGender()
				,getPatient().getAge(),
				getPatient().getStates(),
				getPatient().getLocation(),
				getPatient().getHealthCondition(),
				dateOfDiagnostic,dateOfRecovered,dateOfDeath
		};
	}

	public boolean isValidateDepartments(Departments department){
    	return (department.equals(patient.getLocation()));
	}

	public boolean isValidateAttention(Attention attention){
    	return (attention.equals(patient.getStates()));
	}

	public boolean isValidateHealth(HealthCondition condition){
    	return (condition.equals(patient.getHealthCondition()));
	}

	public boolean isValidateGender(Gender gender){
    	return  (gender.equals(patient.getGender()));
	}

	public boolean isValidateDepartments(String key){
		return (key.equals(patient.getLocation().getKeys()));
	}

	public boolean isValidateAttention(String key){
		return (key.equals(patient.getStates().getKey()));
	}

	public boolean isValidateHealth(String key){
		return (key.equals(patient.getHealthCondition().getKey()));
	}

}

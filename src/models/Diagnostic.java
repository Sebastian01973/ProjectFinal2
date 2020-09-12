package models;

import java.time.LocalDate;

public class Diagnostic {

    private Patient patient;
    private LocalDate dateOfDiagnostic;
    private LocalDate dateOfDeath;
    private LocalDate dateOfRecovered;
    private int number;

    public Diagnostic(int number,Patient patient, LocalDate dateOfDiagnostic, LocalDate dateOfDeath, LocalDate dateOfRecovered) {
        this.dateOfDiagnostic = dateOfDiagnostic;
        this.patient = patient;
        this.number = number;
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

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDate getDateOfDiagnostic() {
		return dateOfDiagnostic;
	}

	public void setDateOfDiagnostic(LocalDate dateOfDiagnostic) {
		this.dateOfDiagnostic = dateOfDiagnostic;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(LocalDate dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public LocalDate getDateOfRecovered() {
		return dateOfRecovered;
	}

	public void setDateOfRecovered(LocalDate dateOfRecovered) {
		this.dateOfRecovered = dateOfRecovered;
	}
	
	public int getNumber() {
		return this.number;
	}
	
}

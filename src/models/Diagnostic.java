package models;

import java.time.LocalDate;

public class Diagnostic {

    private Patient patient;
    private LocalDate dateOfDiagnostic;
    private LocalDate dateOfDeath;
    private LocalDate dateOfRecovered;
    private boolean isDeath;
    private boolean isRecuperated;

    public Diagnostic(Patient patient, LocalDate dateOfDiagnostic, LocalDate dateOfDeath, LocalDate dateOfRecovered,boolean isDeath,boolean isRecuperated) {
        this.isDeath = isDeath;
        this.isRecuperated = isRecuperated;
        validateDeath(dateOfDeath, (byte)1);
        this.dateOfDiagnostic = dateOfDiagnostic;
        this.patient = patient;
        validateDeath(dateOfRecovered, (byte)2);
    }

    public void validateDeath(LocalDate date,byte index){
        switch (index) {
            case 1:
                this.dateOfDeath = (isDeath) ? date:null;
                break;
            case 2:
                this.dateOfRecovered = (isRecuperated) ? date:null;
                break;
        }
    }
}

package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagePatients {

	private ArrayList<Diagnostic> diagnosticList;

	public ManagePatients() {
		this.diagnosticList = new ArrayList<>();
	}

	public Diagnostic createDiagnostic(int number, String location, Atention attention, byte age, Gender gender, HealthCondition healthCondition, LocalDate...dates){
		return new Diagnostic(number,new Patient(location,attention,age,gender,healthCondition),dates[0],dates[1],dates[2]);
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		diagnosticList.add(diagnostic);
	}
	


	public Object[] toObjectVector(int index) {
		Diagnostic diagnostic = diagnosticList.get(index);
		return new Object[] {
				diagnostic.getNumber(),diagnostic.getPatient().getGender().getGender(),
				diagnostic.getPatient().getStates().toString(),
				diagnostic.getPatient().getLocation(),diagnostic.getPatient().getHealthCondition().toString(),
				diagnostic.getDateOfDiagnostic(),diagnostic.getDateOfRecovered(),diagnostic.getDateOfDeath()
		};
	}
	
	public ArrayList<Object[]> getMatrixList(){
		ArrayList<Object[]> matrix = new ArrayList<>();
		for (int i = 0; i < diagnosticList.size(); i++) {
			matrix.add(toObjectVector(i));
		}
		return matrix;
	}
}

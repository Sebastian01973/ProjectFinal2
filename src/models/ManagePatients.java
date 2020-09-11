package models;

import java.util.ArrayList;

public class ManagePatients {
	private ArrayList<Diagnostic> diagnosticList;

	public ManagePatients() {
		this.diagnosticList = new ArrayList<>();
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

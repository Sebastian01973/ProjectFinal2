package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagePatients {

	private ArrayList<Diagnostic> diagnosticList;

	public ManagePatients() {
		this.diagnosticList = new ArrayList<>();
	}

	public Diagnostic createDiagnostic( Departments location, Attention attention, int age, Gender gender, HealthCondition healthCondition, LocalDate...dates){
		return new Diagnostic(0,new Patient(location,attention,age,gender,healthCondition),dates[0],dates[1],dates[2]);
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		diagnosticList.add(diagnostic);
	}

	public int[] countTotalCases(){
		Departments[] deps = Departments.values();
		int[] countCases = new int[Departments.values().length];
		int size = diagnosticList.size();
		for (int i = 0; i < size; i++) {
			countCases[i] = diagnosticList.get(i).countTotalCases(deps[i]);
		}
		return countCases;
	}


	public Object[] getDatasDepartament(){
		Object[] auxObject = new Object[3];
		return auxObject;
	}

	public ArrayList<Object[]> getMatrixList(){
		ArrayList<Object[]> matrix = new ArrayList<>();
		int size = diagnosticList.size();
		for (Diagnostic diagnostic: diagnosticList) {
			matrix.add(diagnostic.toObjectVector());
		}
		return matrix;
	}
}
